package content;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/3/1 17:10
 *
 * @Classname test
 * Description: 算法竞赛：排列巨人
 */

/**
 *
 */
public class Tester_01{
    public static void main(String[] args){
        int n = 12;
        int count = n * f(n - 1);
        System.out.print("对于12名巨人的排列方式有" + count +"种：" );

        int[] buf = {1,2,3,4,5,6,7,8,9,10,11,12};
        prem(buf,0,buf.length - 1);


        return;
    }

    private static void prem(int[] buf, int start, int end) {
        int count = 12;
        if(start==end){//输出排列好的数组
            System.out.print("{");
            for(int c:buf){
                System.out.print(c);
                if (count > 1){
                    System.out.print(",");
                    count--;
                }

            }
            System.out.print("}");
            System.out.print("、");
        }else{
            for(int i=start;i<=end;i++){
                int temp=buf[start];//前后元素交换
                buf[start]=buf[i];
                buf[i]=temp;

                prem(buf,start+1,end);//递归交换后面的元素

                temp=buf[start];
                buf[start]=buf[i];
                buf[i]=temp;

            }
        }
    }

    private static int f(int i) {

        int count = 1;
        if (i > 0){
            count  = i *  f(i - 1) ;
        }
        return count;
    }

}
