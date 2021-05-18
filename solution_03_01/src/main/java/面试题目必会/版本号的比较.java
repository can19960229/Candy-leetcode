package 面试题目必会;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/5/17 16:28
 *
 * @Classname 版本号的比较
 * Description: 测试
 */

/**
 * 版本号有两段式“v1.2”，有三段式“v3.2.5”,还有更多的。如何比较他们的大小？
 *
 *  0代表相等，1代表左边大，-1代表右边大
 */
public class 版本号的比较 {
    public static int compareVersion1(String v1,String v2){
        String[] s1 = v1.split("\\.");
        String[] s2 = v2.split("\\.");
        int n1 = s1.length,n2 = s2.length;
        //比较版本号
        int i1,i2;
        for (int i = 0; i < Math.max(n1, n2); i++) {
            //在短字符串末尾补0
            i1 = i < n1 ? Integer.parseInt(s1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(s2[i]) : 0;
            if (i1 != i2){
                return i1 > i2 ? 1 : -1;
            }
        }
        //版本号相等，返回0
        return 0;
    }

    public static int compareVersion(String version1, String version2) {

        // 两个字符串的长度
        int n = version1.length(), m = version2.length();

        int i = 0;
        int j = 0;

        while (i < n || j < m) {
            // 用v1,v2来计算每一个块中版本号的大小
            int v1 = 0;
            int v2 = 0;

            // 若当前的字符不是分隔符，则计算
            while (i < n && version1.charAt(i) != '.') {
                v1 = v1 * 10 + version1.charAt(i) - '0';
                i++;
            }

            while (j < m && version2.charAt(j) != '.') {
                v2 = v2 * 10 + version2.charAt(j) - '0';
                j++;
            }
            // 判断当前块中的版本号是否一致
            if (v1 != v2) {
                if (v1 > v2) {
                    return 1;
                }
                return -1;
            }
            // 跳过分隔符
            i++;
            j++;
        }

        // 全部比较完了，没有不等的则返回0
        return 0;

    }




    public static void main(String[] args) {
        System.out.println(compareVersion("1.2","3.2.5"));
    }
}
