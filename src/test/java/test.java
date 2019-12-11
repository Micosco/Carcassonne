import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class test {
    static void mark(int[] nums,int[][] Array)
    {
        Array[nums[0]][nums[1]] = 1;
        Array[nums[1]][nums[0]] = 1;

    }
    static void remark(int[] nums,int[][] Array)
    {
        Array[nums[0]][nums[1]] = 0;
        Array[nums[1]][nums[0]] = 0;

    }
    static void markField(int[] nums, int[][] Array)
    {
        for (int i = 0; i < nums.length; i++) {
            int[] numPair = new int[2];
            for (int j = 0; j < nums.length; j++) {
                numPair[0] = nums[i];
                numPair[1] = nums[j];
                mark(numPair,Array);
            }
            for (int j = 0; j < nums.length; j++) {
                numPair[0] = nums[j];
                numPair[1] = nums[j];
                remark(numPair,Array);
            }
        }
    }


    public static void main(String[]args){
        int[] nums = new int[2];
        int[][] AdjMatrix = new int[9][9];
        Scanner in = new Scanner(System.in);
        while(true)
        {
            String temp = in.next();
            if(temp.equals("q")) {
                //System.out.println(Arrays.deepToString(AdjMatrix));
                for(var a : AdjMatrix)
                {
                    System.out.println(","+Arrays.toString(a));
                }
                AdjMatrix = new int[9][9];
            }
            else if(temp.equals("f")){
                int length = in.nextInt();
                int[] fieldNums = new int[length];
                for (int i = 0; i < fieldNums.length; i++) {
                    fieldNums[i] = in.nextInt();
                }
                markField(fieldNums,AdjMatrix);
            }
            else {
                nums[0] = Integer.parseInt(temp);
                nums[1] = in.nextInt();
                mark(nums, AdjMatrix);
            }

        }
    }
}