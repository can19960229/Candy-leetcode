package tree_tree;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/23 17:07
 * version 1.0
 * Description: 测试
 */

import java.util.Arrays;

/**
 *
 */
public class test {

    public static void upAdjust(int[] array){
        int childIndex = array.length-1;
        int parentIndex = (childIndex -1)/2;
        //temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        while (childIndex >0 && temp < array[parentIndex]){
            //无序真正交换，只需要单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex -1)/2;
        }
        array[childIndex] = temp;
    }

    /**
     * "下沉操作"
     * @param array 待调整的堆
     * @param parentIndex  要“下沉”的父节点
     * @param length    堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length){
        //temp保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length){
            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]){
                childIndex++;
            }
            //如果父节点小于任何一个孩子的值，则直接跳出
            if (temp <= array[childIndex])
                break;
            //无须整整交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] =temp;
    }


    /**
     * 构建堆
     * @param array 待调整的堆
     */
    public static void buildHeap(int[] array){
        //从最后一个非叶子节点开始，依次做“下沉”操作
        for (int i = (array.length -2)/2; i>= 0; i--){
            downAdjust(array,i,array.length);
        }
    }
    public static void main(String[] args) {
        int[] array = new int[] {1,3,2,6,5,7,8,9,0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));

    }
}
