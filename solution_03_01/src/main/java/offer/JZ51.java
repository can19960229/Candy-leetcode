package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/15 11:42
 *
 * @Classname JZ51
 * Description: 构建乘积数组
 */

/**
 *
 */
public class JZ51 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            temp = A[i];
            A[i] = 1;
            B[i] = 1;
            for (int j = 0; j < A.length; j++) {
                B[i] *= A[j];
            }
            A[i] = temp;
        }
        return B;
    }
}
