package sort;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/22 10:02
 *
 * @Classname quickSort_1
 * Description: 测试
 */

/**
 *
 */
public class quickSort_1 {
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if (low > high){
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];
        while (i < j){
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j){
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j){
                i++;
            }
            //如果满足条件留交换
            if (i < j){
                t = arr[j];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //最后将基准位于i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半边数组
        quickSort(arr,low,j- 1);
        quickSort(arr,j+1,high);
    }

    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr,0,arr.length - 1); //将数组进行排序
        for (int value : arr) {
            System.out.println(value);
        }
    }
}
