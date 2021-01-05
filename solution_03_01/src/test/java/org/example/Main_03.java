package org.example;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/12/20 12:41
 * version 1.0
 * Description: 测试
 */

import java.util.Scanner;

/**
 *
 */
public class Main_03 {

    public static void swap(int[] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = k - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]){
                    swap(arr,j,j + 1);
                }
            }
        }
        k = k -2;
        for(int i = n - 1;i > k;i--){
            for (int j = 0;j < i;j++){
                if(arr[j] > arr[i]){
                    swap(arr,j,j+1);
                }
            }
        }
        for (int i = n - 1;i > k;i--){
            for(int j = k;j < i;j++){
                if (arr[j] < arr[j+ 1]){
                    swap(arr,j,j+ 1);
                }
            }
        }
        for (int e : arr) {
            System.out.print(e + " ");
        }
    }
}
