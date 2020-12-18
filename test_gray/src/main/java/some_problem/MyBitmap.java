package some_problem;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/8/5 16:12
 * version 1.0
 * Description: 位图算法 Bitmap
 */

/**
 *内存中连续的二进制位(bit)所组成的数据结构，该算法主要用于对大量整数做去重和查询操作
 */
public class MyBitmap {
    //每一个word是一个long类型元素，对应一个64位二进制数据
    private long[] words;
    //Bitmap的位数大小
    private int size;

    public MyBitmap(int size){
        this.size = size;
        this.words = new long[(getWordIndex(size-1) + 1)];
    }

    /**
     * 判断Bitmap某一位的状态
     * @param bitIndex 位图的第bitIndex位(bitIndex=0代表Bitmap左数第1位)
     * @return
     */
    public boolean getBit(int bitIndex){
        if (bitIndex<0||bitIndex>size-1){
            throw new IndexOutOfBoundsException("超过Bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }

    /**
     * 把Bitmap某一位设置为true
     * @param bitIndex  位图的第bitIndex位 (bitIndex=0代表Bitmap左数第1位)
     */
    public void setBit(int bitIndex){
        if (bitIndex<0 || bitIndex>size-1){
            throw new IndexOutOfBoundsException("超过Bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }

    /**
     * 定位Bitmap某一位所对应的word
     * @param bitIndex  位图的第bitIndex位(bitIndex =0 代表Bitmap左数第1位)
     * @return
     */
    private int getWordIndex(int bitIndex){
        //右移6位，相当于除以64
        return bitIndex >> 6;
    }

    public static void main(String[] args) {
        MyBitmap bitmap = new MyBitmap(128);
        bitmap.setBit(126);
        bitmap.setBit(75);
        System.out.println(bitmap.getBit(126));
        System.out.println(bitmap.getBit(78));
    }
}
