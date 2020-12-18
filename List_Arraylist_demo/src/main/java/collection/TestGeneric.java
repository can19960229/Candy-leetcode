package collection;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/8 21:39
 * version 1.0
 * Description: 测试
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TestGeneric {

    /**
     * 带有泛型——course的List类型属性
     */
    public List<Course> courses;

    public TestGeneric() {
        this.courses = new ArrayList<Course>();
    }

    /**
     * 测试添加
     * @param
     */
    public void testAdd(){
        Course cr1 = new Course("1","大学语文");
        courses.add(cr1);
        //泛型集合中，不能添加泛型规定的类型及其子类型以外的对象，否则会报错
        // courses.add("能否添加一些奇怪的东西呢");

        Course cr2 = new Course("2","大学英语");
        courses.add(cr2);
    }

    /**
     *测试循环遍历
     * @param
     */

    public void testForEach(){
        for (Course cr:courses) {
            System.out.println(cr.id + ":" +cr.name);
        }
    }

    /**
     *泛型集合可以添加泛型的子类型的对象实例
     * @param
     */
    public void testChild(){
        ChildCourse cc = new ChildCourse();
        cc.id = "3";
        cc.name = "我是子类型的课程对象实例";
        courses.add(cc);
    }

    public static void main(String[] args) {
        TestGeneric tg = new TestGeneric();
        tg.testAdd();
        tg.testForEach();
        tg.testChild();
        tg.testForEach();
    }
}
