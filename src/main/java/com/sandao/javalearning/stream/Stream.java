package com.sandao.javalearning.stream;

import com.google.common.collect.Lists;

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
        List<User> userList = init();
        System.out.println("全部用户："+userList);
        testFindAny(userList);
        testMap(userList);
    }

    private static List<User> init(){
        List<User> userList = Lists.newLinkedList();
        List<String> nameList =  Arrays.asList("张三", "王五", "李白","杜甫","白居易");
        Random random = new Random();
        for (int j = 0; j < 5; j++) {
            User user = new User();
            user.setAge(random.nextInt(30));
            user.setName(nameList.get(j));
            user.setSex(random.nextBoolean()?"男":"女");
            userList.add(user);
        }
        return userList;
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
