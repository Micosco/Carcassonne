package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.game.Player;
import com.mcsc.carcassonne.game.RoundStagePointer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 用于进行游戏的棋盘
 * 保存游戏主要数据
 *
 * @author WhiteWing
 */
public class Board {
    private BoardPosition[][] board;
    private int boardSize;
    private int tileCount;
    private BoardPosition lastPlaced;
    private TileStack tileStack = new TileStack("base");

    public static final int DEFAULT_SIZE = 201;

    public Board() {
        this(DEFAULT_SIZE);
    }

    public Board(int boardSize) {
        this.boardSize = boardSize;
        board = new BoardPosition[boardSize][boardSize];
        tileCount = 0;

        int halfOfBoardSize = boardSize / 2;
        //在board上每个设置放置一个不包含板块的BoardPosition对象
        //坐标轴方向与swing相同，原点为(boardSize / 2, boardSize / 2)
        for (int i = 0, x = -halfOfBoardSize; i < boardSize; i++, x++) {
            for (int j = 0, y = -halfOfBoardSize; j < boardSize; j++, y++) {
                board[i][j] = new BoardPosition(x, y);
                board[i][j].setParent(this);
            }
        }
    }

    /**
     * 在指定位置放置板块
     *
     * @param x    指定位置的横坐标
     * @param y    指定位置的纵坐标
     * @param tile 要放置的板块
     */
    public void placeTile(int x, int y, Tile tile) {
        board[x + boardSize / 2][y + boardSize / 2].placeTile(tile);
        lastPlaced = board[x + boardSize / 2][y + boardSize / 2];
        RoundStagePointer.getDefaultStagePointer().nextStage();
    }

    /**
     * 在中心位置放置第一个板块
     * 在仅使用基础包时， 放置初始板块
     * TODO 在河流扩展包可用时， 放置由玩家选择的初始河流板块
     *
     * @param tile 要放置的板块
     */
    public void placeFirstTile(Tile tile) {
        board[boardSize / 2][boardSize / 2].placeTile(TileStack.getOriginTile());
    }

    /**
     * 在指定区域放置米宝
     *
     * @param region 要放置米宝的区域
     */
    public void placeMeeple(EdgeDirectionEnum region) {
        lastPlaced.getTile().placeMeeple(region);
    }

    /**
     * 当放置最后一个板块后，结算分数
     *
     * @return 每位玩家的分数
     */
    public Map<Player, Integer> settleScore() {
        Map<Player, Integer> scores = new HashMap<Player, Integer>(0);
        Set<EdgeDirectionEnum> effectiveDirection = new HashSet<>();

        //排除4个角
        for (var direction : EdgeDirectionEnum.values()) {
            if (direction.ordinal() % 2 == 0) {
                effectiveDirection.add(direction);
            }
        }

        for (int i = 0; i < 8; i++) {
            ScoreInfo score = new ScoreInfo();
            Set<BoardPosition> visited = new HashSet<>();

            Tile lastTile = lastPlaced.getTile();
            if (lastTile.getEdge(EdgeDirectionEnum.valueOf(i)) == EdgeTypeEnum.CITY) {
                summary(EdgeDirectionEnum.valueOf(i), lastPlaced, effectiveDirection, visited,
                        2, EdgeTypeEnum.CITY, score);
            } else if (lastTile.getEdge(EdgeDirectionEnum.valueOf(i)) == EdgeTypeEnum.ROAD) {
                summary(EdgeDirectionEnum.valueOf(i), lastPlaced, effectiveDirection, visited,
                        1, EdgeTypeEnum.ROAD, score);
            }

            if (!score.isNoScore() && score.getScore() > 0) {
                for (var player : score.getMeeplesCount().keySet()) {
                    scores.put(player,
                            score.getScore() * score.getMeeplesCount().get(player)
                                    + scores.getOrDefault(player, 0));
                }

                for (var pos : visited) {
                    pos.getTile().clearMeeple();
                }
            }
        }

        RoundStagePointer.getDefaultStagePointer().nextStage();

        return scores;
    }

    public BoardPosition getPositionByDirection(BoardPosition startPosition, EdgeDirectionEnum direction) {
        //将矩阵下标修正为坐标
        int offset = boardSize / 2;
        switch (direction) {
            case N:
                return board[startPosition.getX() + offset][startPosition.getY() - 1 + offset];
            case S:
                return board[startPosition.getX() + offset][startPosition.getY() + 1 + offset];
            case E:
                return board[startPosition.getX() + 1 + offset][startPosition.getY() + offset];
            case W:
                return board[startPosition.getX() - 1 + offset][startPosition.getY() + offset];
            default:
                return startPosition;
        }
    }

    /**
     * 结算路或城的得分
     *
     * @param startEdge          开始结算的边缘
     * @param startPosition      开始结算的板块位置
     * @param effectiveDirection 有效的方向
     * @param visitedPositions   访问过的板块
     * @param weight             每个板块得分
     * @param result             得分
     */
    private void summary(EdgeDirectionEnum startEdge, BoardPosition startPosition,
                         Set<EdgeDirectionEnum> effectiveDirection,
                         Set<BoardPosition> visitedPositions, int weight, EdgeTypeEnum type, ScoreInfo result) {
        if (startPosition.getTile() == null) {
            result.setNoScore(true);
            return;
        }
        if (startPosition.getTile().getEdge(startEdge) != type) {
            result.setNoScore(true);
            return;
        }
        if (visitedPositions.contains(startPosition)) {
            return;
        }

        //当前板块分数结算
        visitedPositions.add(startPosition);
        result.addScore(weight);

        var adjacentTiles = startPosition.getAdjacentTiles(startEdge);

        //当前板块米宝统计
        Meeple meeple = startPosition.getTile().getMeeple();
        if (meeple != null && adjacentTiles.containsKey(startPosition.getTile().getMeeplePosition()))
            result.addMeepleCount(meeple.getBelongTo());


        //获取需要访问的方向
        Set<EdgeDirectionEnum> needVisit =
                adjacentTiles.keySet().stream().filter(effectiveDirection::contains)
                        .filter(e -> !visitedPositions.contains(adjacentTiles.get(e)))
                        .collect(Collectors.toSet());

        //DFS遍历
        for (var direct : needVisit) {
            summary(direct.getOpposite(), adjacentTiles.get(direct), effectiveDirection, visitedPositions, weight,
                    type, result);
        }
    }

    private void clearMeeples(Set<BoardPosition> visitedPositions) {
        for (var pos : visitedPositions) {
            pos.getTile().clearMeeple();
        }
    }

    public BoardPosition getLastPlaced() {
        return lastPlaced;
    }

    public BoardPosition get(int x, int y) {
        return board[x + boardSize / 2][y + boardSize / 2];
    }

    public TileStack getTileStack() {
        return tileStack;
    }

    public int getTileCount() {
        return tileCount;
    }

    public BoardPosition[][] getBoard() {
        return board;
    }
}
