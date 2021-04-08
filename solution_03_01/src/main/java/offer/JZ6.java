package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/8 10:35
 *
 * @Classname JZ6
 * Description: 旋转数组的最小数字
 */

/**
 *
 */
public class JZ6 {

    public static int minNumberInRotateArray(int[] array){
        if (array.length == 1){
            return 0;
        }
        int l = 0;
        int r = array.length - 1;
        while (l < r - 1){
            int mid = (l + r) >> 1;
            if (array[mid] >= array[l]){
                l = mid;
            }else if (array[mid] <= array[r]){
                r = mid;
            }
        }
        return array[r];
    }

    public static void main(String[] args) {
        System.out.println(minNumberInRotateArray(new int[]{3,4,5,1,2}));
    }

}
