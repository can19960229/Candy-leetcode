package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/9 19:42
 *
 * @Classname JZ9
 * Description: 变态跳台阶
 */

/**
 * 可以跳一级，两级，n级
 */
public class JZ9 {
    public int JumpFloorII(int target){
        if (target <= 0)
            return -1;
        else if (target == 1)
            return 1;
        else
            return 2 * JumpFloorII(target - 1);
    }
}
