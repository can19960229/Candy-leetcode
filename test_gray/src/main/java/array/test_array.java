package array; /**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/16 9:58
 * version 1.0
 * Description: 数组
 */

/**
 *测试数组从中间插入元素
 */

public class test_array {
    private int[] array;
    private int size;

    public test_array(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     *
     * @param element 插入的元素
     * @param index 插入的位置
     * @throws Exception
     */
   public void insert (int element,int index) throws Exception{
        //判断访问下标是否超出范围
       if (index <0 || index >size){
           throw new IndexOutOfBoundsException("超出数组实际范围");
       }
       //从右向左循环，将元素逐个向右挪1位
        for (int i=size -1;i>=index;i--){
            array[i+1] = array[i];
        }
        //腾出的位置放入新元素
        array[index] = element;
        size++;
   }

    /**
     * 数组扩容
     */

   public void resize(){
       int[] arrayNew = new int[array.length*2];
       //从旧数组复制到新数组
       System.arraycopy(array,0,arrayNew,0,array.length);
       array = arrayNew;
   }

    /**
     * 数组删除元素
     * @param index 删除的位置
     * @return
     */
    public int delete(int index){
        if (index <0 || index >size){
            throw new IndexOutOfBoundsException("超出数组实际范围");
        }
        int deletedElement = array[index];
        //从左向右循环
        for (int i=index;i<size-1;i++){
            array[i] = array[i+1];
        }
        size--;
        return deletedElement;
    }

    /**
     * 输出数组
     */
   public void output(){
        for (int i=0;i<size;i++){
            System.out.println(array[i]);
        }
   }

    public static void main(String[] args) throws Exception {
        test_array test_array = new test_array(10);
        test_array.insert(3,0);
        test_array.insert(7,1);
        test_array.insert(9,2);
        test_array.insert(5,3);
        test_array.insert(6,1);
        test_array.output();

    }

}
