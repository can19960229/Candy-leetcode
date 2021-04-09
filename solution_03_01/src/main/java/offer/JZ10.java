package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/9 19:44
 *
 * @Classname JZ10
 * Description: 小矩形无重复覆盖大矩形
 */

/**
 *
 */
public class JZ10 {
    public int rectCover(int target){
        int number = 1;
        int sum = 1;
        if (target <= 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        while (target-- >= 2){
            sum += number;
            number = sum - number;
        }
        return sum;
    }
}
