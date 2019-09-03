package com.sandao.javalearning.collection.stream;

import com.sandao.javalearning.user.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 流计算
 *
 * @author maoyanting
 * @version V1.0
 * @date 2019/08/02
 */
public class Stream {

    public static void main(String[] args) {
        List<User> userList = User.init();
        System.out.println("全部用户："+userList);
        testFindAny(userList);
        testMap(userList);
    }

    private static void testFindAny(List<User> users) {
        List<String> sex = new LinkedList<>();
        users.stream()
                .filter(user -> "女".equals(user.getSex()))
                .findAny()
                .ifPresent(user -> sex.add(user.getName()));
        List<String> nameList = users.stream()
                .filter(user -> "女".equals(user.getSex()))
                .map(User::getName)
                .collect(Collectors.toList());
        System.out.println("获取某个女性名字："+sex);
        System.out.println("获取所有女性名字："+nameList);
    }

    private static void testMap(List<User> users) {
        System.out.println("测试map相关：");
        /**
         * mapToInt限制ToIntFunction返回值为整型,mapToLong,MapToBollean同理
         */
        System.out.println("获取所有人年龄：");
        users.stream().mapToInt(User::getAge).forEach(System.out::print);
        System.out.println("获取所有人姓名：");
        users.stream().map(User::getName).forEach(System.out::print);

    }
}
