package cap_1_4;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/9/9 16:53
 * version 1.0
 * Description: 测试
 */

import edu.princeton.cs.algs4.Heap;

import java.util.Arrays;

/**
 *
 */
public class Test {
    //java 大顶堆的简单实现

        public void heapSort(int[] num){
            int n = num.length;
            for(int i = n/2;i>=0;i--){   //建堆，从n/2开始向上调整
                adjustHeap(num, i, n);
            }
            for(int j=n-1;j>=0;j--){
                swap(num,0, j);         //交换开始和最后位置上的数字
                adjustHeap(num, 0, j);    //交换之后再调整堆
            }
        }
        public void adjustHeap(int[] num,int s,int n){  //由于根节点编号是从0开始的，所以其左子树是2*i+1
            for(int i=s;i<n;){
                int max = i;
                if((2*i+1)<n&&num[2*i+1]>num[max]) max = 2*i+1;
                if((2*i+2)<n&&num[2*i+2]>num[max]) max = 2*i+2;
                if(max!=i){
                    swap(num,i,max);
                    i=max;
                }else break;

            }

        }
        public void swap(int[] num,int i,int j){
            int tem = num[i];
            num[i] = num[j];
            num[j] = tem;
        }
        public static void main(String[] args) {
            Test heap = new Test();
            int[] num = new int[]{1,5,4,7,2,6,3};
            heap.heapSort(num);
            System.out.println(Arrays.toString(num));
        }


}
