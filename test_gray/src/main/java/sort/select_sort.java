package sort;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/9/24 21:17
 * version 1.0
 * Description: 测试
 */

/**
 * 选择排序
 */
public class select_sort {
    public static void selctionSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }
    public static void swap(int[] arr,int i,int j){
/*
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

*/
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
