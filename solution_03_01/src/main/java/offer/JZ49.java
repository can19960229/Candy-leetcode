package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/24 17:35
 *
 * @Classname JZ49
 * Description: 测试
 */

/**
 *
 */
public class JZ49 {
    public int StrToInt(String str){
        int res = 0;
        int flag = 0; //用来标识是整数还是负数
        for (int i = 0;i < str.length();i++){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                res = res * 10 + str.charAt(i) - '0';
            }else if (str.charAt(i) == '+'){
                if (i > 0 || flag != 0)
                    return 0;
                flag = 1;  //置为整数
            }else if (str.charAt(i) == '-'){
                if (i > 0 || flag != 0) //
                    return 0;
                flag = -1;  //置为负数
            }else
                return 0;
        }
        return flag >= 0 ? res : res * flag;
    }
}
