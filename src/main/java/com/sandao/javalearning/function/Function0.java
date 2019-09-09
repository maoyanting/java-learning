package com.sandao.javalearning.function;

import com.sandao.javalearning.user.User;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * jdk1.8的函数练习
 *
 * @author maoyanting
 * @version V1.0
 * @date 2019/07/22
 */
public class Function0 {
    public static void main(String[] args) {
//        testConsumer();
//        testSupplier();
//        testFunction();
//        testPredicate();
//        testOptional();
        testRedoce();
    }

    /**
     * 消费型接口 无返回值
     */
    private static void testConsumer() {
        Consumer<String> consumer = System.out::println;
        Consumer<String> consumer2 = s -> System.out.println("连续消费2：" + s.split(",")[0]);
        consumer.accept("hello function");
        consumer.andThen(consumer2).accept("连续消费 hello function");
    }

    /**
     * 供给型接口 有返回值
     */
    private static void testSupplier() {
        Supplier<String> supplier = () -> "我要变的很有钱";
        System.out.println(supplier.get());
    }

    /**
     * 函数型接口
     */
    private static void testFunction() {
        Function<Integer, Integer> function1 = e -> e * 2;
        Function<Integer, Integer> function2 = e -> e * e;

        Integer apply1 = function1.andThen(function2).apply(3);
        Integer apply2 = function1.apply(3);
        Integer apply3 = function1.compose(function2).apply(3);

        System.out.println("测试两个Function： " + apply1);
        System.out.println("测试两个Function： " + apply3);
        System.out.println("测试Function： " + apply2);
    }

    /**
     * 断言型接口 返回布尔值
     */
    private static void testPredicate() {
        Predicate<String> predicate1 = s -> false;
        Predicate<String> predicate2 = Objects::nonNull;
        //两个结果均为true才返回true
        boolean test = predicate1.and(predicate2).test("||测试");
        System.out.println("测试与函数：" + test);

        //取反
        Predicate<String> predicate = s -> s.length() > 0;
        boolean result = predicate.negate().test("取反");
        System.out.println("测试取反：" + result);
    }

    /**
     * Optional测试
     */
    private static void testOptional() {
        Function<String, String> function = e -> e + "存在";

        String testString = "函数";
        String testStringNull = null;
        Optional<String> optional = Optional.ofNullable(testString);
        Optional<String> optional2 = Optional.ofNullable(testStringNull);

        System.out.println("Optional函数测试:" + optional.map(function).orElse("不存在"));
        System.out.println("Optional函数测试:" + optional2.map(function).orElse("不存在"));

        optional.ifPresent(System.out::println);
        optional2.ifPresent(System.out::println);
    }

    /**
     * reduce 函数
     * 入参的 BinaryOperator 函数， 传入的两个参数的类型和返回类型要求相同
     */
    private static void testRedoce() {
        /**
         * item 依次是 Stream的第二、三个元素
         * acc 的初始值是 Stream的第一个元素
         * acc 是上次函数执行的返回值
         */
        Optional accResult = Stream.of(1, 2, 3, 4)
                .reduce((acc, item) -> {
                    System.out.println("acc : " + acc);
                    acc += item;
                    System.out.println("item: " + item);
                    System.out.println("acc+ : " + acc);
                    System.out.println("--------");
                    return acc;
                });

        /**
         * item 依次是 Stream的第一、二、三个元素
         * 这里指定了 acc 初始值
         */
        int accResult2 = Stream.of(1, 2, 3, 4)
                .reduce(0, (acc, item) -> {
                    System.out.println("acc : " + acc);
                    acc += item;
                    System.out.println("item: " + item);
                    System.out.println("acc+ : " + acc);
                    System.out.println("--------");
                    return acc;
                });

        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        // 求和，sumValue = 10, 无起始值 由于可能没有足够的元素，返回的是 Optional
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();

        List<User> userList = User.init();
        userList.stream()
                .reduce((acc, item) -> {
                    System.out.println("----当前年龄最大的用户---"+acc);
                    return acc.getAge() > item.getAge()?acc:item;
                }).ifPresent(System.out::println);
    }
}
