package collection;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/8 16:31
 * version 1.0
 * Description: 测试
 */

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *学生类
 */
public class Student implements Comparable<Student>{

    public String id;

    public String name;

    public Set<Course> courses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        //把所选课程进行初始化 不能直接实例化Set Set为一个接口
        this.courses = new HashSet<Course>();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Student o) {


        return this.id.compareTo(o.id);
    }
}
