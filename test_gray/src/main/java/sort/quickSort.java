package sort;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/7/3 10:50
 * version 1.0
 * Description: 快速排序
 *
 * partition()  分治法(双边循环法)
 * partitionV2()  分治法(单边循环法)
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 */
public class quickSort {
    /**
     *  递归实现快排
     */

    public static void quickSort(int[] arr,int startIndex,int endIndex){
        //递归结束条件：startIndex大于或等于endIndex时
        if (startIndex >= endIndex){
            return;
        }
        //得到基准元素位置
        int pivotIndex = partition(arr,startIndex,endIndex);
        //根据基准元素，分成两部分进行递归排序
        quickSort(arr,startIndex,pivotIndex-1);
        quickSort(arr,pivotIndex +1,endIndex);
    }
    /**
     * 非递归实现快排
     * 转换成栈的实现，在栈中存储每一次方法调用的参数
     * 该方法引入一个存储Map类型元素的栈，用于存储每一次交换时的起始下标和结束下标
     * 每一次循环，都会让栈顶元素出栈，通过partition方法进行分治，并且按照基准元素的位置分成左右两部分，左右两部分再分别入栈。
     * 当栈位空时，说明排序完毕，退出循环。
     */
    public static void quickSort_(int[] arr,int startIndex,int endIndex){
        //用一个集合栈来代替递归的函数栈
        Stack<Map<String,Integer>> quickSortStack = new Stack<Map<String, Integer>>();
        //整个数列的起止下标，以哈希的形式入栈
        Map rootParam = new HashMap();
        rootParam.put("startIndex",startIndex);
        rootParam.put("endIndex",endIndex);
        quickSortStack.push(rootParam);

        //循环结束条件：栈为空时
        while (!quickSortStack.isEmpty()){
            //栈顶元素出栈，得到起止下标
            Map<String,Integer> param = quickSortStack.pop();
            //得到基准元素位置
            int pivotIndex = partition(arr,param.get("startIndex"),param.get("endIndex"));
            //根据基准元素分成两部分，把每一部分的起止下标入栈
            if (param.get("startIndex") < pivotIndex -1){
                Map<String,Integer> leftParam = new HashMap<String, Integer>();
                leftParam.put("startIndex",param.get("startIndex"));
                leftParam.put("endIndex",pivotIndex-1);
                quickSortStack.push(leftParam);
            }
            if (pivotIndex +1 < param.get("endIndex")){
                Map<String,Integer> rightParam = new HashMap<String, Integer>();
                rightParam.put("startIndex",pivotIndex +1);
                rightParam.put("endIndex",param.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }

    /**
     * partition方法实现了元素的交换，让数列中的元素依据自身大小，分别交换到基准元素的左右两边
     * 分治 (双边循环法)
     * @param arr 待交换的数组
     * @param startIndex   起始下标
     * @param endIndex  结束下标
     */
    private static int partition(int[] arr,int startIndex,int endIndex){
        //取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right){
            //控制right指针比较并左移
            while (left<right && arr[right] >pivot){
                right--;
            }
            //控制left指针比较并右移
            while (left<right && arr[left] <= pivot){
                left++;
            }
            //交换left和right指针所指向的元素
            if (left<right){
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }

        //pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;

        return left;
    }

    /**
     *
     *  分治法(单边循环法)
     * @param arr   待交换的数组
     * @param startIndex    起始下标
     * @param endIndex      结束下标
     */

    private static int partitionV2(int[] arr,int startIndex,int endIndex){
        //取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        //mark代表小于基准元素的区域边界
        int mark = startIndex;
        //从基准元素的下一个位置开始遍历数组
        for (int i = startIndex+1; i < endIndex; i++) {
            //如果小于基准元素，则一，把mark指针右移1位，因为小于pivot的区域边界增大了1；
            // 二，让最新遍历到的元素和mark指针所在位置的元素交换，因为最新遍历的元素归属于小于pivot的区域
            if (arr[i] <pivot){
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    private static void quickSortV3(int[] array,int begin,int end){
        if (end <= begin) return;
        int pivot = partitionV3(array,begin,end);
        quickSort(array,begin,pivot-1);
        quickSort(array,pivot+1,end);
    }
    static int partitionV3(int[] a,int begin,int end){
        //pivot 标杆位置 counter:小于pivot的元素的个数
        int pivot = end,counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]){
                int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
        return counter;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,4,6,5,3,2,8,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
