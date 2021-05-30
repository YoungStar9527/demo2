package com.star.jvm.demo.arith;

/**
 * 二维数组中的查找
 */
public class Test1 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int itemp = matrix.length-1;
        int jtemp = 0;
        for(int i = itemp; i >= 0; i--){
            for(int j = jtemp; j < matrix[i].length; j++){
                if(matrix[i][j] == target){
                    return true;
                }
                if(matrix[i][j] < target){
                    jtemp +=1;
                }else if(matrix[i][j] > target){
                    itemp-=1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "We are happy.";
    }
}
