package labuladong_learn.someIdea.Conquer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/23 16:52
 *
 * @Classname solveSudoku
 * Description: 解数独
 */

/**
 *
 */
public class solveSudu {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        backtrack(board,0,0);

    }

    private boolean backtrack(char[][] board, int i, int j) {

        int m = 9;
        int n = 9;
        if(j == n){
            //穷举到最后一列的话，就换到下一行重新开始
            return backtrack(board,i+1,0);
        }
        if (i == m){
            //找到一个可行解，触发base case
            return true;
        }
        if (board[i][j] != '.'){
            //有预设数字，不用我们穷举
            return backtrack(board,i,j+1);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            //如果遇到不合法的数字，就跳过
            if (!isVaild(board,i,j,ch)){
                continue;
            }
            board[i][j] = ch;
            //如果找到一个可行解，立即结束
            if (backtrack(board,i,j+1)){
                return true;
            }
            board[i][j] = '.';
        }
        //穷举完1——9，依然没有找到可行解
        //需要前面的格子换个数字穷举
        return false;

    }

    private boolean isVaild(char[][] board, int r, int c, int n) {
        for (int i = 0; i < 9; i++) {
            //判断行是否存在重复
            if (board[r][i] == n)
                return false;
            //判断列是否存在重复
            if (board[i][c] == n)
                return false;
            //判断3x3方框是否存在重复
            if (board[(r/3)*3 + i/3][(c/3)*3 + i%3] == n)
                return false;
        }
        return true;
    }


}
