package com.mcsc.carcassonne.CardReader;

import com.mcsc.carcassonne.utility.AdjacencyMatrix;
import org.json.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LeoDuan
 * @since 12
 * {@code JsonReader}Json文件读取类
 * 用于从板块的配置文件中读取各个板块的信息。
 */
public class JsonReader {
    /**
     * @value 文件路径，用于初始化对象时存入读取文件的相对路径。
     */
    private String filePath;

    /**
     * 构造方法
     * @param filePath ,传入文件相对路径。
     */
    JsonReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * {@link com.mcsc.carcassonne.utility.AdjacencyMatrix}
     * 该函数将{@code JsonArray}对象转换得到的{@code Object[][]}矩阵转换成{@code AdjacencyMatrix}对象
     */
    private AdjacencyMatrix convertToAdjacencyMatrix(Object[][] formerMatrix) {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(formerMatrix.length, formerMatrix.length);
        for (int i = 0; i < formerMatrix.length; i++) {
            for (int j = 0; j < formerMatrix.length; j++) {
                adjacencyMatrix.setAdjacent(i, j, (boolean) formerMatrix[i][j]);
            }
        }
        return adjacencyMatrix;
    }

    /**
     *
     * @param name，用于指定读入板块名称
     * @return AdjacencyMatrix对象
     * @throws IOException，可能由FileReader抛出，原因是有可能找不到路径名
     *
     */
    public AdjacencyMatrix getAdjacencyMatrix(String name) throws IOException {
        FileReader fileReader = new FileReader(new File(filePath));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder fileStr = new StringBuilder();
        String tempStr = bufferedReader.readLine();
        while (tempStr != null) {
            fileStr.append(tempStr);
            tempStr = bufferedReader.readLine();
        }
        //将json文件内容读入fileStr字符串中
        JSONObject jsonObject = new JSONObject(fileStr.toString());
        JSONArray jsonArray = jsonObject.getJSONObject(name).getJSONArray("adjacencyMatrix");
        //解析fileStr字符串，将邻接矩阵读入jsonArray中
        Object[][] adjacencyMatrix = new Object[jsonArray.length()][jsonArray.length()];
        int i = 0;
        List arrayList1 = jsonArray.toList();
        for (var innerArray : arrayList1) {
            adjacencyMatrix[i] = ((ArrayList) innerArray).toArray();
            i++;
        }
        for (Object[] matrix : adjacencyMatrix) {
            for (Object o : matrix) {
                System.out.println(o);
            }
        }
        //将jsonArray转换成Object[][]
        AdjacencyMatrix outputMatrix ;
        outputMatrix = convertToAdjacencyMatrix(adjacencyMatrix);
        //调用方法将Object[][]转换成AdjacencyMatrix对象
        return outputMatrix;
    }
}
