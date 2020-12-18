package collection;/**
 * Copyright (C), 2019-2020
 * author  candy_chen
 * date   2020/6/9 17:43
 * version 1.0
 * Description: 测试
 */

import java.util.Comparator;

/**
 *
 */
public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        // TODO Auto-generated method stub
        return o1.name.compareTo(o2.name);
    }
}
