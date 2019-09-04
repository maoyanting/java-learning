package com.sandao.javalearning.collection;

import java.util.HashMap;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/03
 */
public class MapTest {
    public static void main(String[] args) {
        testMapValue();
    }

    private static void testMapValue(){
        HashMap<String,String> map = new HashMap<>();
        map.put("1","first");
        map.put("2","second");
        map.put("3","third");
        //map.put 会返回 old value
        System.out.println("1 map old value: "+map.put("1","replace first"));
        System.out.println("4 map old value: "+map.put("4","replace fourth"));
    }
}
