package offer;/**
 * Copyright (C), 2019-2021
 * author  candy_chen
 * date   2021/4/27 15:36
 *
 * @Classname JZ63
 * Description: 数据流中的中位数
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 */
public class JZ63 {
    ArrayList<Integer> array = new ArrayList<>();
    public void Insert(Integer num) {
        array.add(num);
    }

    public Double GetMedian() {
        Collections.sort(array);
        int index = array.size() / 2;
        if (array.size() % 2 != 0){
            return (double)array.get(index);
        }else {
            return ((double)(array.get(index - 1)) + (double)array.get(index))/2;
        }
    }

}
