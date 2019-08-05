package com.sandao.javalearning.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 流计算
 * @author maoyanting
 * @version V1.0
 * @date 2019/08/02
 */
public class Stream {
    static {

    }
    public static void main(String[] args) {
        List<User> userList= new LinkedList<>();
        User userA = new User();
        userA.setAge("23");
        userA.setName("A");
        userA.setSex("女");
        User userB = new User();
        userB.setAge("24");
        userB.setName("B");
        userB.setSex("男");
        userList.add(userA);
        userList.add(userB);
        testFindAny(userList);
        testMap(userA);
    }

    private static void testFindAny(List<User> users){
        List<String> sex = new LinkedList<>();
        users.stream()
                .filter(user -> "女".equals(user.getSex()))
                .findAny()
                .ifPresent(user -> sex.add(user.getName()));
        System.out.println(sex);
    }

    private static void testMap(User user){
        Map<String,String> extend = user.getExtend();
        extend.put("测试map初始化","测试map初始化");
        System.out.println(user);
    }
}
