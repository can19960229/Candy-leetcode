package collection;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/8 16:29
 * version 1.0
 * Description: 创建课程类和学生类来理解 list 和 Arraylist
 * 课程类
 */

import java.util.Objects;

/**
 * 课程类
 * 由于只是测试 所以属性写成了公有属性
 */
public class Course {

    public String id;

    public String name;

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        if (!(o instanceof Course))
            return false;
        Course course = (Course) o;
        if (this.name == null){
            if (course.name == null)
                return true;
            else
                return false;
        }else {
            if (this.name.equals(course.name))
                return true;
            else
                return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
