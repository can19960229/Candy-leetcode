package labuladong_learn.someIdea.Conquer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/25 16:20
 *
 * @Classname gParenthesis
 * Description: 括号生成
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class gParenthesis {
    public List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        //特判
        if (n == 0){
            return res;
        }
        //执行深度优先遍历，搜索可能的结果
        dfs("",n,n,res);
        return res;
    }

    private void dfs(String curStr, int left, int right, List<String> res) {
        //因为每一次尝试，都是用新的字符串变量，所以无需回溯
        //在递归终止的时候，直接把它添加到结果集即可
        if (left == 0 && right == 0){
            res.add(curStr);
            return;
        }
        //剪枝
        if (left > right){
            return;
        }
        if (left > 0){
            dfs(curStr + "(", left - 1, right, res);
        }
        if (right > 0){
            dfs(curStr + ")",left,right - 1,res);
        }
    }
}
