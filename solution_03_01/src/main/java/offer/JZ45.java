package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/27 11:09
 *
 * @Classname JZ45
 * Description: 扑克牌的顺子
 */


/**
 * 统计数组各个位置出现的字符个数，
 * base case分析，出现多个重复数字，但重复数字不是0，则直接返回false
 * 找到左边第一个不为0的元素的下标，
 * 从尾部开始定位右边第一个不为0的元素的下标
 * 获取到元素数组的长度，统计里面0的个数，如果0的个数能够填补数组中的空缺，则输出true，不能的话，则说明不连续，输出false
 *
 */
public class JZ45 {
    public static boolean isContinuous(int[] numbers){
        if (numbers == null || numbers.length == 0) return false;
        int[] cards = new int[14];
        for (int i : numbers){
            cards[i]++;
            if (i != 0 && cards[i] > 1)  //如果存在重复的数字则直接返回false，但是数组中的0是可以重复的
                return false;
        }
        int start = 1;
        while (start < cards.length && cards[start] == 0) //找到左边第一个非零的元素的下标
            start++;
        int end = cards.length - 1;
        while (end > 0 && cards[end] == 0) //找到右边第一个非零元素的下标
            end--;
        for (int i = start + 1;i <= end;i++){  //遍历获取到的元素的长度，并统计里面0的个数，如果出现0，则进行减1
            if (cards[i] == 0)
                cards[0]--;
        }
        return cards[0] >= 0; //如果最后数组中0的个数>= 0；则说明扑克牌是连续的，其中的空位可以用0补齐，否则是不连续的
    }

    public static void main(String[] args) {
        System.out.println(isContinuous(new int[]{0,3,2,6,4}));
    }
}
