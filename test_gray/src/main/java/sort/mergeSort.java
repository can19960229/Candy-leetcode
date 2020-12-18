package sort;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/12/5 19:45
 * version 1.0
 * Description: 测试
 */

/**
 *
 */
public class mergeSort {
    public static void mergeSort(int[] array,int left,int right){
        if (right <= left) return;
        int mid = (left + right) >> 1;//  (left + right) / 2

        mergeSort(array, left, mid);
        mergeSort(array,mid + 1,right);
        merge(array,left,mid,right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left,j = mid + 1,k = 0;

        //两个数组要合并在一起的数组
        while (i <= mid && j <= right){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        //也可以用System.arraycopy(a,start1,b,start2,length)
    }
}
