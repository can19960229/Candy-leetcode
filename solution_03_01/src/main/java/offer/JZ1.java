package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/7 15:42
 *
 * @Classname JZ1
 * Description: 二维数组中查找目标值
 */

/**
 *
 */
public class JZ1 {

    public static boolean find1(int[][] array,int target){
        if (array == null || array.length == 0){
            return false;
        }
        int row = 0;
        int column = array[0].length - 1;

        while (row < array.length && column >= 0){
            if (array[row][column] == target){
                return true;
            }
            if (array[row][column] > target){
                column--;
            }else {
                row++;
            }
        }
        return false;
    }
    public static boolean find2(int[][] array,int target) {
        if (array == null || array.length == 0){
            return false;
        }
        int left = 0;
        int right = array.length * array[0].length - 1;
        int col = array[0].length;

        while (left <= right){
            int mid = (left + right) / 2;
            int value = array[mid / col][mid % col];
            if (value == target){
                return true;
            }else if (value < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
}
