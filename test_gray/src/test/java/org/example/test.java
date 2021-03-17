package org.example;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/13 14:34
 *
 * @Classname test
 * Description: 测试
 */

/**
 *
 */
public class test {

        public static void main(String[] args) {
            char[] buf={'a','b','c'};
            prem(buf,0,buf.length-1);
        }

        public static void prem(char[] buf,int start,int end){
            if(start==end){//输出排列好的数组
                for(char c:buf){
                    System.out.print(c);
                }
                System.out.println();
            }else{
                for(int i=start;i<=end;i++){
                    //System.out.println("i:"+i);
                    char temp=buf[start];//前后元素交换
                    buf[start]=buf[i];
                    buf[i]=temp;

                    prem(buf,start+1,end);//递归交换后面的元素

                    temp=buf[start];
                    buf[start]=buf[i];
                    buf[i]=temp;

                }
            }
        }

}
