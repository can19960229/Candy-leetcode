package 笔试汇总.华为;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/7 17:15
 *
 * @Classname HJ16
 * Description: 购物单
 */

import java.util.Scanner;

/**
 * 加了附加条件的背包问题
 */
public class HJ16 {
    static class Good{
        int v;
        int vp;
        public Good(int v,int vp){
            this.v = v;
            this.vp = vp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //总钱数
        int N = sc.nextInt();
        //购买物品个数
        int m = sc.nextInt();
        int[] f = new int[N + 1];
        //分组，goods[i][0]为主件，goods[i][1]为附件1，goods[i][2]为附件2
        Good[][] goods1 = new Good[60][4];
        for (int i = 1; i <= m; i++) {
            int v = sc.nextInt();  //该物品的价格
            int p = sc.nextInt();  //该物品的重要度
            int q = sc.nextInt();  //该物品是主件还是附件 q=0 主件； q > 0 附件，是主件所属的编号

            Good t = new Good(v,v*p);
            if (q == 0){
                goods1[i][0] = t;
            }else {
                if (goods1[q][1] == null){
                    goods1[q][1] = t;
                }else {
                    goods1[q][2] = t;
                }
            }
        }


        for (int i = 1; i <= m; i++) {  //  m （ <60 ）为希望购买物品的个数
            for (int j = N; j >= 0 && goods1[i][0] != null; j--) {
                //以下代码从分组中选择价值最大的。共五种情况：不选主件，选主件，选附件1和主件，选附件2和主件，选附件1和附件2和主件
                // 主件
                Good master = goods1[i][0];
                //情形1：不买主件
                int max = f[j];

                // 情形2: 购买主件
                if (j >= master.v && max < f[j - master.v] + master.vp) {
                    //f[j - master.v] ： 当用钱买下主件后剩余的钱，能买到的最大权重
                    max = f[j - master.v] + master.vp;
                }

                // 情形3：购买主件和附件1（附件1存在即代表主件存在）
                int vt;
                if (goods1[i][1] != null) {
                    if (j >= (vt = master.v + goods1[i][1].v)
                            && max <  f[j - vt] + master.vp + goods1[i][1].vp) {
                        max = f[j - vt] + master.vp + goods1[i][1].vp;
                    }
                }
                // 附件2存在即代表主件及附件1存在）
                // 情形4: 购买主件及附件2
                if (goods1[i][2] != null) {
                    if (j >= (vt = master.v + goods1[i][1].v + goods1[i][2].v)
                            && max < f[j - vt] + master.vp + goods1[i][1].vp + goods1[i][2].vp) {
                        max = f[j - vt] + master.vp + goods1[i][1].vp + goods1[i][2].vp;
                    }
                }
                f[j] = max;
            }
        }

        System.out.println(f[N]);

    }
}
