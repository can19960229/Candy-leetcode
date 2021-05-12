package newCode_300;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/12 22:48
 *
 * @Classname NC156
 * Description: 测试
 */

/**
 *
 */
public class NC_156 {
    public int foundOnceNumber (int[] arr, int k) {
        int[] binarySum = new int[32];
        for (int i = 0; i < 32; i++) {//求每个二进制位是的和
            int sum = 0;
            for (int num : arr) {
                sum += (num >> i & 1); //依次右移num，同1相与，计算每一位上1的个数
            }
            binarySum[i] = sum;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (binarySum[i] % k != 0){
                res +=1 << i;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
