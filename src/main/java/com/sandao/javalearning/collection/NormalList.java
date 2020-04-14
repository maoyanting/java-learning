package com.sandao.javalearning.collection;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/08/01
 */
public class NormalList {
    public static void main(String[] args) {

        String[] params = new String[3];
        params[0] = "发发发";
        params[1] = "发发的发";
        params[2] = "啊啊啊啊";
        System.out.println(Arrays.toString(params));
    }

    public static void testInit(){
        // 1 普通初始化
        List listA = new LinkedList();
        // 2 产生的list不可编辑
        List<String> jdks = Arrays.asList("JDK6", "JDK8", "JDK10");
        // 2.1 转化为可编辑状态
        jdks = new ArrayList<>(jdks);
        jdks.add("JDK11");
        System.out.println("Arrays.asList 产生的list："+jdks);
        // 3 产生的list不可编辑
        List<String> apples = Collections.nCopies(3, "apple");
        // 3.1 转化为可编辑状态
        apples = new ArrayList<>(apples);
        apples.add("bad apple");
        System.out.println("Collections.nCopies 产生的list："+apples);
        // 4 jdk1.8 以后的 StreamTest 方法
        List<String> colors = Stream.of("blue", "red", "yellow").collect(Collectors.toList());
        colors.add("green");
        System.out.println("StreamTest 产生的list："+colors);
        // 5 google 工具包
        List listB = Lists.newLinkedList();
        // 5.1 字符串转 list，产生的list不可编辑
        String str = "1-2-3-4-5-6";
        List<String> listC = Splitter.on("-").splitToList(str);
        // 5.2 转化为可编辑状态
        listC = new ArrayList<>(listC);
        listC.add("8");
        System.out.println("google工具包 产生的list："+listC);
        //6 空列表 不可编辑
        List<String> emptyList = Collections.emptyList();

    }
}
