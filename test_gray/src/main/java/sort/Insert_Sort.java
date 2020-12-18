package sort;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/9/24 21:31
 * version 1.0
 * Description: 测试
 */

/**
 *  插入排序
 *  一堆有序的扑克牌，插入一张牌
 */
public class Insert_Sort {
    public static void insertionSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr,j,j+1);
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
