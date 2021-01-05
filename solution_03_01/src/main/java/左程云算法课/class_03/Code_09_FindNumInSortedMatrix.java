package 左程云算法课.class_03; /**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2021/1/5 20:37
 * version 1.0
 * Description: 测试
 */

/**
 * 在行列都排好序的矩阵中找数
 */
public class Code_09_FindNumInSortedMatrix {
    public static boolean isContains(int[][] matrix,int x){
        int row = 0;    //行
        int col = matrix[0].length - 1; //列
        while (row < matrix.length && col > -1){
            if (matrix[row][col] == x){
                return true;
            }else if (matrix[row][col] > x){
                col--;
            }else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        int K = 233;
        System.out.println(isContains(matrix, K));
    }
}
