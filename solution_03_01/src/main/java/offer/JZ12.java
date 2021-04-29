package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/23 9:36
 *
 * @Classname JZ12
 * Description: 数值的整数次方
 */

/**
 *
 */
public class JZ12 {
    public double Power(double base,int exponent){
        if (exponent == 0){
            return 1;
        }
        else if (exponent == 1){
            return base;
        }
        else if (exponent > 1){
            double sum = 1;
            for (int i = 1; i <= exponent;i++){
                sum = sum * base;
            }
            return sum;
        }else {
            double sum = 1;
            for (int i = -1;i >= exponent;i--){
                sum = sum * base;
            }
            return 1/sum;
        }
    }
}
