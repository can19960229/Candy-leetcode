package some_problem;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/8/4 20:25
 * version 1.0
 * Description: 寻找缺失的整数
 */

/**
 *一个无序数组里有99个不重复正整数，范围从1到100，唯独缺少一个整数。如何找出这个缺失的整数？
 */
public class FindLostNum {
    public static int[] findLostNum(int[] array){
        //用于存储2个出现奇数次的整数
        int result[] = new int[2];
        //第1次进行整体异或运算
        int xorResult = 0;
        for (int i=0;i<array.length;i++){
            xorResult ^= array[i];
        }
        //如果进行异或运算的结果为0，则说明输入的数组不符合题目要求
        if (xorResult == 0){
            return null;
        }
        //确定2个整数的不同为，以此来做分组
        int separator = 1;
        while (0==(xorResult&separator)){
            separator<<=1;
        }
        //第2次分组进行异或运算
        for (int i=0;i<array.length;i++){
            if (0==(array[i]&separator)){
                result[0]^=array[i];
            }else {
                result[1]^=array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {4,1,2,2,5,1,4,3};
        int[] result = findLostNum(array);
        System.out.println(result[0] + "," + result[1]);
    }
}
