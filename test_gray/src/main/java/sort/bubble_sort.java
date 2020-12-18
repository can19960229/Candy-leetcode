package sort;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/29 16:12
 * version 1.0
 * Description: 冒泡排序
 */

import java.util.Arrays;

/**
 *
 */
public class bubble_sort {
    /**
     * 冒泡排序优化版本一
     * 问题：经过多轮排序后，数列已经有序了，剩下的几轮排序就不必执行了，可以提前结束
     * 解决：判断数列是否已经有序，并做出标记
     * 如果本轮排序中有元素交换，则说明数列无序，如果没有元素交换，则说明数列已经有序，直接跳出大循环。
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;

            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //因为有元素进行交换，所以不是有序的，标记变为false
                    isSorted = false;

                }
            }
            if (isSorted){
                break;
            }
        }
    }

    /**
     * 冒泡排序优化版本二
     * 优化二：
     * 问题：后半部分元素中的最小值大于前半部分元素的最大值，即右边的许多元素已经有序了
     * 解决：对数列有序区的界定
     * 每一轮排序后，记录下来最后一次元素交换的位置，该位置即为无序数列的边界，再往后就是有序区了
     * @param array
     */
    public static void sort_2(int[] array) {
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = array.length -1;
        for (int i = 0; i < array.length - 1; i++) {
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;

            for (int j = 0; j < sortBorder; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //因为有元素进行交换，所以不是有序的，标记变为false
                    isSorted = false;
                    //把无序数列的边界更新为最后一次交换元素位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted){
                break;
            }
        }
    }
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                int temp = 0;
                if (arr[i] > arr[i + 1]){
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i+1] = temp;

                }
            }
        }
    }

    /**
     * 鸡尾酒排序代码
     * @param array
     */

    public static void sort03(int array[]){
        //..........

    }

    public static void main(String[] args) {
        int[] array = new int[]{5,8,6,3,9,2,1,7};
        sort_2(array);
        System.out.println(Arrays.toString(array));
    }
}
