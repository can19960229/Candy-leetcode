package collection;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/8 16:36
 * version 1.0
 * Description: 测试
 */

import java.util.*;

/**
 *备选课程类
 */
public class ListTest {
    /**
     * 用于存放备选课程的list
     */
    public List coursesToSelect;

    public ListTest() {
        //通过构造函数对属性进行实例化
        this.coursesToSelect = new ArrayList();
    }

    /**
     * 用于往coursesToSelect中添加备选课程
     *
     * add方法往list中添加元素
     */
    public void testAdd(){
        //创建一个课程对象，并通过调用add方法，添加到备选课程List中
        Course cr1 = new Course("1", "数据结构");
        coursesToSelect.add(cr1);
        //当对象存入都变成object类型  取出时需要类型转换
        Course temp = (Course) coursesToSelect.get(0);
        System.out.println("添加了课程：" + temp.id + " : " + temp.name);

        //指定位置进行插入 会把之前添加的“数据结构”课程挤到第1个位置 新插入的在第0个位置
        Course cr2 = new Course("2", "电路基础");
        coursesToSelect.add(0,cr2);
        //当对象存入都变成object类型  取出时需要类型转换
        Course temp2 = (Course) coursesToSelect.get(0);
        System.out.println("添加了课程：" + temp2.id + " : " + temp2.name);

        Course[] course = {new Course("3", "高等数学"),new Course("4", "英语")};
        //使用Arrays.asList()方法 把course数组转换成一个list集合
        coursesToSelect.addAll(Arrays.asList(course));
        Course temp3 = (Course) coursesToSelect.get(2);
        Course temp4 = (Course) coursesToSelect.get(3);

        System.out.println("添加了两门课程：" + temp3.id + ": " + temp3.name + ";" +
                temp4.id + ": " + temp4.name);

        //进行插入到指定位置 插入到下标为2的位置
        Course[] course2 = {new Course("5", "离散数学"),new Course("6", "政治")};
        coursesToSelect.addAll(2,Arrays.asList(course2));
        Course temp5 = (Course) coursesToSelect.get(2);
        Course temp6 = (Course) coursesToSelect.get(3);

        System.out.println("添加了两门课程：" + temp5.id + ": " + temp5.name + ";" +
                temp6.id + ": " + temp6.name);




        //测试可重复添加
        coursesToSelect.add(cr2);
        //当对象存入都变成object类型  取出时需要类型转换
        Course temp0 = (Course) coursesToSelect.get(0);
        System.out.println("添加了课程：" + temp0.id + " : " + temp0.name);

    }

    /**
     * 取得list中元素的方法
     * list 中的size方法取得列表中元素的长度
     *
     */

    public void testGet(){
        int size = coursesToSelect.size();

        System.out.println("有如下课程待选");
        for (int i = 0; i <size;i++){
            Course cr = (Course) coursesToSelect.get(i);
            System.out.println("课程：" + cr.id + ":" + cr.name);
        }
    }

    /**
     * Iterator 返回在此collection的元素上进行迭代的迭代器
     * 迭代器就是会用来遍历集合中元素的 不具备存储元素的功能 依赖于集合存在 不能独立存在
     * 通过迭代器进行List遍历
     */
    public void testIterator(){
        //通过集合的iterator方法，取得迭代器的实例
        Iterator it = coursesToSelect.iterator();
        System.out.println("有如下课程待选（通过迭代器访问）：");
        while (it.hasNext()) {
            Course cr = (Course)it.next();
            System.out.println("课程： " + cr.id + ": " + cr.name);
        }

        //for循环遍历
        System.out.println("有如下课程待选（通过for循环访问）：");

        for(int x=0; x<coursesToSelect.size();x++){
            Course cr1 = (Course)coursesToSelect.get(x);
            System.out.println( "课程： " + cr1.id + "----"+cr1.name);
        }

    }

    /**
     * 通过for each方法访问集合元素
     */
    public void testForEach(){
        System.out.println("有如下课程待选（通过for each访问）：");
        for (Object obj: coursesToSelect) {
            Course cr = (Course) obj;
            System.out.println("课程： " + cr.id + ": " + cr.name);
        }
    }

    /**
     * 去除list中重复的课程 使用选择排序
     * @param
     */
    public void testPass(){
        for (int x=0; x<coursesToSelect.size();x++){
            for (int y=x+1;y<coursesToSelect.size();y++){
                if (coursesToSelect.get(x).equals(coursesToSelect.get(y))){
                    coursesToSelect.remove(y);
                    y--;
                }
            }
        }
    }


    /**
     * Vector：动态数组
     * 特有的功能：在实现List接口之前的功能
     *      A：添加元素
     *          public void addElement(Object obj)  ----    add(Object obj)
     *      B：遍历元素
     *          public Object elementAt(int index)     ---  get(int index)
     *          public int size()
     *
     *          public Enumeration elements()          ---   Iterator
     *              hasMoreElements                         hasNext()
     *              nextElement                             next()
     */
    public static void testVector(){
        Vector v = new Vector();
        v.addElement("hello");
        v.addElement("world");

        for (int x = 0;x<v.size();x++){
            String s = (String)v.elementAt(x);
            System.out.println(s);
        }
        System.out.println("---------");
        Enumeration en = v.elements();
        while (en.hasMoreElements()){
            String s = (String) en.nextElement();
            System.out.println(s);
        }

    }

    public static void main(String[] args) {
        ListTest lt = new ListTest();
        lt.testAdd();
        lt.testGet();
        lt.testIterator();

        lt.testPass();
        lt.testForEach();
//        testVector();
    }
}
