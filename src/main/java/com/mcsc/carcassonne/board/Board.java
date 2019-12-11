package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.game.GameState;
import com.mcsc.carcassonne.game.Player;
import com.mcsc.carcassonne.game.RoundStagePointer;

import java.util.*;
import java.util.stream.Collector;
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

        for (int i = 0; i < 8; i += 2) {
            int score = 0;
            HashSet<BoardPosition> visitedPositions = new HashSet<>();
            if (lastPlaced.getTile().getLayer().getEdges()[i] == EdgeTypeEnum.CITY) {
                score = summary(EdgeDirectionEnum.valueOf(i), lastPlaced, effectiveDirection, visitedPositions, 2,
                        EdgeTypeEnum.CITY);
            } else if (lastPlaced.getTile().getLayer().getEdges()[i] == EdgeTypeEnum.ROAD) {
                score = summary(EdgeDirectionEnum.valueOf(i), lastPlaced, effectiveDirection, visitedPositions, 1,
                        EdgeTypeEnum.ROAD) ;
            }
            score = Math.max(score, 0);
            if (score > 0) clearMeeples(visitedPositions);
            Meeple meeple = lastPlaced.getTile().getMeeples()[i];
            if (meeple != null)
                scores.put(meeple.getBelongTo(), score + scores.getOrDefault(meeple.getBelongTo(), 0));
        }

        RoundStagePointer.getDefaultStagePointer().nextStage();

        return scores;
    }

    public BoardPosition getPositionByDirection(BoardPosition startPosition, EdgeDirectionEnum direction) {
        //将矩阵下标修正为坐标
        int offset = boardSize / 2;
        switch (direction) {
            case N -> {return board[startPosition.getX() + offset][startPosition.getY() - 1 + offset];}
            case S -> {return board[startPosition.getX() + offset][startPosition.getY() + 1 + offset];}
            case E -> {return board[startPosition.getX() + 1 + offset][startPosition.getY() + offset];}
            case W -> {return board[startPosition.getX() - 1 + offset][startPosition.getY() + offset];}
            default -> {return startPosition;}
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
     * @return 路的得分，负数表示路未完成
     */
    private int summary(EdgeDirectionEnum startEdge, BoardPosition startPosition,
                        Set<EdgeDirectionEnum> effectiveDirection,
                        Set<BoardPosition> visitedPositions, int weight, EdgeTypeEnum type) {
        if (startPosition.getTile() == null) return Integer.MIN_VALUE;
        if (startPosition.getTile().getLayer().getEdges()[startEdge.ordinal()] != type)
            return Integer.MIN_VALUE;
        //每个板块得分
        int totalScore = weight;
        visitedPositions.add(startPosition);
        //获取与当前位置联通的板块
        Map<EdgeDirectionEnum, BoardPosition> adjacentPositions = startPosition.getAdjacentTiles(startEdge);
        //获取需要访问的板块
        Set<EdgeDirectionEnum> needVisit = adjacentPositions.keySet().stream().filter(effectiveDirection::contains)
                .filter(e -> !visitedPositions.contains(adjacentPositions.get(e))).collect(Collectors.toSet());
        //访问并计算分数
        for (var direct : needVisit) {
          //  visitedPositions.add(adjacentPositions.get(direct));
            int score = summary(EdgeDirectionEnum.valueOf((direct.ordinal() + 4) % 8),
                    adjacentPositions.get(direct), effectiveDirection, visitedPositions, weight, type);
            if (score < 0) totalScore = Integer.MIN_VALUE;
        }
        return totalScore;
    }

    private void clearMeeples(Set<BoardPosition> visitedPositions) {
        for (var pos : visitedPositions){
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
