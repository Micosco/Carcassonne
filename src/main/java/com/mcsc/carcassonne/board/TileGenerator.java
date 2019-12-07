package com.mcsc.carcassonne.board;

import com.mcsc.carcassonne.utility.AdjacencyMatrix;
import org.json.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author LeoDuan
 * @since 12
 * {@code JsonReader}Json文件读取类
 * 用于从板块的配置文件中读取各个板块的信息。
 * 每个板块是一个对象，存入牌堆
 */
public class TileGenerator {
    /**
     * @value 文件路径，用于初始化对象时存入读取文件的相对路径。
     */
    private String filePath;
    private StringBuilder fileStr;
    private JSONObject jsonObject;

    /**
     * 构造方法
     *
     * @param filePath ,传入文件相对路径。
     */
    public TileGenerator(String filePath){
        this.filePath = filePath;
        try {
            FileReader fileReader = new FileReader(new File(filePath));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            this.fileStr = new StringBuilder();
            String tempStr = bufferedReader.readLine();
            while (tempStr != null) {
                fileStr.append(tempStr);
                tempStr = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将json文件内容读入fileStr字符串中。
        assert fileStr != null;
        this.jsonObject = new JSONObject(fileStr.toString());
        //该jsonObject对象存储了格式化过的json文件内容。
    }
    private boolean boolAdjacency(Object matrix)
    {
        boolean value = false;
        if(matrix.equals(1))
            value = true;
        return value;
    }
    private AdjacencyMatrix convertToAdjacencyMatrix(Object[][] formerMatrix) {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(formerMatrix.length, formerMatrix.length);
        for (int i = 0; i < formerMatrix.length; i++) {
            for (int j = 0; j < formerMatrix.length; j++) {
                adjacencyMatrix.setAdjacent(i, j, boolAdjacency(formerMatrix[i][j]));
            }
        }
        return adjacencyMatrix;
    }

    public AdjacencyMatrix getAdjacencyMatrix(String name){
        JSONArray jsonArray = jsonObject.getJSONObject(name).getJSONArray("AdjacencyMatrix");
        //解析fileStr字符串，将邻接矩阵读入jsonArray中
        Object[][] adjacencyMatrix = new Object[jsonArray.length()][jsonArray.length()];
        int i = 0;
        List arrayList1 = jsonArray.toList();
        for (var innerArray : arrayList1) {
            adjacencyMatrix[i] = ((ArrayList) innerArray).toArray();
            i++;
        }
        //将jsonArray转换成Object[][]
        AdjacencyMatrix outputMatrix;
        outputMatrix = convertToAdjacencyMatrix(adjacencyMatrix);
        //调用方法将Object[][]转换成AdjacencyMatrix对象
        return outputMatrix;
    }

    public boolean isChurch(String name) {
        boolean isChurch = jsonObject.getJSONObject(name).getBoolean("isChurch");
        return isChurch;
    }

    public EdgeTypeEnum StringToEdgeTypeEnum(String edge) {
        EdgeTypeEnum typeEnum = null;
        if (edge.equals("field"))
            typeEnum = EdgeTypeEnum.FIELD;
        else if (edge.equals("city"))
            typeEnum = EdgeTypeEnum.CITY;
        else if (edge.equals("road"))
            typeEnum = EdgeTypeEnum.ROAD;
        else if (edge.equals("river"))
            typeEnum = EdgeTypeEnum.RIVER;
        return typeEnum;
    }

    public EdgeTypeEnum[] getEdgeTypeEnum(String name) {
        String[] stringEdges = new String[8];
        EdgeTypeEnum[] edges = new EdgeTypeEnum[8];
        for (int i = 0; i < 8; i++) {
            stringEdges[i] = jsonObject.getJSONObject(name).getJSONObject("edgeType").getString(String.valueOf(i));
        }
        for (int i = 0; i < 8; i++) {
            edges[i] = StringToEdgeTypeEnum(stringEdges[i]);
        }
        return edges;
    }

    public String getExpansionName(String name) {
        return jsonObject.getJSONObject(name).getString("expansion");
    }
    public int getTotalTileNum(String expansion) {
        String name = expansion + "TileNum";
        return jsonObject.getInt(name);
    }
}