package sort;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/23 9:51
 *
 * @Classname mergeSort_1
 * Description: 归并排序
 */

import java.util.Arrays;

/**
 *
 */
public class mergeSort_1 {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int[] temp = new int[arr.length]; //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length - 1,temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right){
            int mid = (left + right) / 2;
            sort(arr,left,mid,temp);
            sort(arr,mid + 1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = right;//右序列指针
        int t = 0;
        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid){//将左边剩余元素填进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right){//将右边剩余元素填进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right){
            arr[left++] = temp[t++];
        }
    }
}
