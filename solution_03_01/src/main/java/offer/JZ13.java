package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/9 19:54
 *
 * @Classname JZ13
 * Description: 调整数组顺序使奇数位于偶数前面
 */

/**
 *
 */
public class JZ13 {
    /**
     *
     * 此方法可以把奇偶数分开，但是不能保证奇数和奇数，偶数与偶数的相对位置不变
     * @param array
     * @return
     */
    public int[] reOrderArray(int[] array) {
        if (array == null || array.length == 0)
            return array;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            //偶数
            while (left <= right && array[left] % 2 != 0) {
                left++;
            }
            //奇数
            while (left <= right && array[right] % 2 == 0) {
                right--;
            }
            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
        return array;
    }

        /**
         * 保证了相对位置，但是引入了新的数组，牺牲了空间
         * @param array int整型一维数组
         * @return int整型一维数组
         */
        public int[] reOrderArray_1 (int[] array) {
            // write code here
            int[] arr=new int[array.length];
            int num=0;
            for(int a:array){
                if((a&1)==1) num++;//奇数
            }
            int i=0;
            for(int a:array){
                if((a&1)==1){ //奇数
                    arr[i++]=a;
                }else{
                    arr[num++]=a;
                }
            }
            return arr;
        }

}


