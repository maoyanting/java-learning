package com.sandao.javalearning.vavr;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import io.vavr.collection.List;
import io.vavr.control.Option;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/09
 */
public class VavrTest {
    public static void main(String[] args) {
//        testList();
//        testOption();
        testTuple();
    }

    private static void testList(){
        int count = Arrays.asList(1, 2, 3).stream().reduce((i, j) -> i + j).get();
        int count2 = IntStream.of(1, 2, 3).sum();
        Long count3 = (Long)List.of(1, 2, 3).sum();
        System.out.println(count);
        System.out.println(count2);
        System.out.println(count3);
    }

    private static void testOption(){
        Option<Object> noneOption = Option.of(null);
        Option<Object> someOption = Option.of("这里是啥");
//        Object nullObj = null;
        System.out.println(noneOption.getOrElse("else is null"));
        System.out.println(someOption.getOrElse("else is null2"));
//        System.out.println(nullObj.toString());
    }

    private static void testTuple(){
        //元组 Tuple3可以储存三个对象
        Tuple3<String, Integer, Double> tuple3 = Tuple.of("Java", 8, 1.8);
        String element1 = tuple3._1;
        int element2 = tuple3._2();
        double element3 = tuple3._3();

        //元组 Tuple2可以储存两个对象
        Tuple2<String, Integer> tuple2 = Tuple.of("Java", 8);
        String ele1 = tuple2._1;
        Integer ele2 = tuple2._2;


        print(element1,element2,element3);

    }

    private static void print(Object... objects){
        for (Object object:objects){
            System.out.print(object + "  --  ");
        }
    }
}
