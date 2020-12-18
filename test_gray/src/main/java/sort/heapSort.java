package sort;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/9/27 17:04
 * version 1.0
 * Description: 堆排序
 */

/**
 *
 */
public class heapSort {
    static void heapify(int[] array,int length,int i){
        int left = 2 * i + 1,right = 2 * i + 2;
        int largest = i;

        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i){
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length,largest);
        }
    }
    public static void heapSort(int[] array){
        if (array.length == 0) return;

        int length = array.length;
        for (int i = length / 2 - 1;i >= 0; i--) {
            heapify(array,length,i);
        }
        for (int i = length - 1; i >= 0;i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array,i,0);
        }
    }

}
