package com.sandao.javalearning.collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/04
 */
public class CollectionTest {
    public static void main(String[] args) {
        List<Integer> integers = new LinkedList<>();
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        Collections.reverse(integers);
        System.out.println(integers);
    }
}
