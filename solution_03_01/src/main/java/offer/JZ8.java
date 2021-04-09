package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/9 19:38
 *
 * @Classname JZ8
 * Description: 跳台阶
 */

/**
 *
 */
public class JZ8 {
    public int JumpFloor(int target){
        int a = 1, b = 1;
        for (int i = 2; i <= target; i++) {
            a = a + b;
            b = a - b;
        }
        return a;
    }

}
