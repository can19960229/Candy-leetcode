package sort;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/7/13 15:32
 * version 1.0
 * Description: 测试
 */

import java.util.Arrays;

/**
 *计数排序
 */
public class countSort {
    /*
    传统的计数排序
     */
    public static int[] countSort(int[] array) {
        //1.得到数列的最大值
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //2.根据数列最大值确定统计数组的长度
        int[] countArray = new int[array.length];
        //3.遍历数列，填充统计数组
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;//每一个整数按照其值对号入座，同时对应数组下标的元素进行加1操作
        }
        //4.遍历统计数组，输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;

    }

    /*
    计数排序的优化
     */
    public static int[] countSort2(int[] array){
        //1.得到数列的最大值和最小值，并计算出差值d
        int max = array[0];
        int min = array[0];
        for (int i=0;i<array.length;i++){
            if (array[i]>max){
                max = array[i];
            }
            if (array[i]<min){
                min = array[i];
            }
        }
        int d = max - min;
        //2.创建统计数组并统计数列中对应元素的个数
        int[] countArray = new int[d+1];
        for (int i=0;i<array.length;i++){
            countArray[array[i]-min]++;
        }
        //3.统计数组做变形，后面的元素邓毅前面元素之和
        /*
         相加的目的：让统计数组存储的元素值，等于相应整数的最终排序位置的序号。
         */
        for (int i =1;i<countArray.length;i++){
            countArray[i] += countArray[i-1];
        }
        //4.倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
        int[] sortedArray = new int[array.length];
        for (int i=array.length-1;i>=0;i--){
            /*
            * 先找到统计数组中下标为
            * */
            sortedArray[countArray[array[i] - min] -1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 4, 6, 5, 3, 2, 8, 1, 7, 5, 6, 0, 10};
        int[] sortedArray = countSort2(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
