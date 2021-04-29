package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/28 10:21
 *
 * @Classname JZ41
 * Description: 和为S的连续正数序列
 */

import java.util.ArrayList;

/**
 *
 */
public class JZ41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
        ArrayList<ArrayList<Integer>> resp = new ArrayList<>();
        if (sum < 0){
            return resp;
        }
        int leftP = 1;
        int rightP = 2;
        int sumVal = leftP + rightP;
        //滑动窗口法
        while (sum > rightP){
            if (sumVal < sum){
                rightP++;
            }else if (sumVal > sum){
                sumVal -= leftP;
                leftP++;
            }else {
                //满足之和等于给出的数字，则加入到集合中
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = leftP;i <= rightP;i++){
                    list.add(i);
                }
                resp.add(list);
                //加入完第一个结果后，继续第二个，窗口往后加1
                rightP++;
                sumVal += rightP;
            }
        }
        return resp;
    }
}
