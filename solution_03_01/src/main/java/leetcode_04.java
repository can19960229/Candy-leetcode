/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/9/18 11:11
 * version 1.0
 * Description: 测试
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class leetcode_04 {


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0){
            if(n % 2 == 0)
                return (nums2[n/2] + nums2[n/2-1])/2.0;
            else{
                return nums2[n/2];
            }
        }else if(n == 0){
            if(m % 2 == 0)
                return (nums1[m/2] + nums1[m/2-1])/2.0;
            else{
                return nums1[m/2];
            }
        }else{
           /* if(m == n){
                return (nums1[m - 1] + nums2[n - 1])/2;
            }else if(m > n){
                int k = m - n;
                if(k % 2 != 0){
                    return nums1[m - 1];
                }else{
                    return (nums1[m - 2] + nums1[m - 1])/2;
                }
            }else{
                int k = n - m;
                if(k % 2 != 0){
                    return nums2[n - 1];
                }else{
                    return (nums2[n - 2] + nums2[n - 1])/2;
                }
            }*/
            //把两个数组拼接起来
            ArrayList<Integer> alist = new ArrayList<Integer>(nums1.length + nums2.length);

            for (int j = 0; j < nums1.length; j++) {
                alist.add(nums1[j]);
            }

            for (int k = 0; k < nums2.length; k++) {
                alist.add(nums2[k]);
            }

            int c[] = new int[alist.size()];

            for (int i = 0; i < alist.size(); i++) {
                c[i] = alist.get(i);
            }

            //如果第一个数组的最大值小于第二个数组，则拼接起来就是有序的，可以直接通过下标找出中位数

            //需要把数组重新排序，找到中位数
            //可以用二分法进行排序
            Arrays.sort(c);
            if(c.length % 2 == 0){
                double ans = (c[c.length/2] + c[c.length/2-1])/2.0;
                return ans;
            }else{
                return c[c.length/2];
            }

        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0,0,0,0,0};
        int[] nums2 = {-1,0,0,0,0,0,1};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

}

