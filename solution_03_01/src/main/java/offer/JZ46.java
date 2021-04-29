package offer;
/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/24 17:31
 *
 * @Classname JZ46
 * Description: 约瑟夫环问题——孩子们的游戏（圆圈中最后剩下的数字）
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class JZ46 {
    public int LastRemaining_Solution_1(int n, int m) {
        if (n <= 0 || m <= 0)
            return -1;
        return n == 1 ? 0 : (LastRemaining_Solution_1(n - 1,m) + m) % n;
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1){
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        //构建list
        for (int i = 0;i < n;i++){
            list.add(i);
        }
        int cur = -1;
        while (list.size() > 1){
            for (int i = 0;i < m;i++){
                cur++;
                if (cur == list.size()){
                    cur = 0;
                }
            }
            list.remove(cur);
            cur--;//cur--的原因，因为新的list中cur指向了下一个元素，为了保证移动m个准确性，所以cur向前移动一位。

        }
        return list.get(0);
    }
}
