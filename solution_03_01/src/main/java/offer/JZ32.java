package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/21 10:05
 *
 * @Classname JZ32
 * Description: 把数组排成最小的数
 */

/**
 *
 */
public class JZ32 {

    //方法 一
    public String minNumber(int[] nums){
        String[] strs = new String[nums.length];
        for (int i = 0;i < nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        fastSort(strs,0,strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    private void fastSort(String[] strs, int l, int r) {
        if (l >= r)
            return;
        int i = l,j = r;
        String tmp = strs[i];
        while (i<j){
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) >= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        fastSort(strs,l,i - 1);
        fastSort(strs,i + 1,r);
    }
    //方法 二
    public String PrintMinNumber(int [] numbers) {
        //把参与比较的两个数尝试拼接起来比较大小再排序
        //如 2  21 因为212 < 221 所以排序为21 2
        boolean changed = true;
        for (int i = numbers.length -1;i > 0 && changed;i--){
            changed = false;

        }
        return "";
    }


}
