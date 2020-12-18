package some_problem;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/7/20 20:37
 * version 1.0
 * Description: 判断一个数是否为2的整数次幂
 */

/**
 *
 */
public class isPowerOf2 {

    /**
     * 时间复杂度O(logn)
     * @param num
     * @return
     */

    public static boolean isPowerOf2_v1(int num){
        int temp = 1;
        while (temp <= num){
            if (temp == num){
                return true;
            }
            temp = temp << 2;  //把乘以2的操作改成向左移位，移位运算的性能比乘法高
        }
        return false;
    }

    /**
     * 时间复杂度O(1)
     * 按位与运算进行判断
     * @param num
     * @return
     */
    public static boolean isPowerOf2(int num){
        return (num & num -1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2(32));
        System.out.println(isPowerOf2(19));
    }
}
