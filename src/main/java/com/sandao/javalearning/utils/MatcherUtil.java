package com.sandao.javalearning.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2020/08/27
 */
public class MatcherUtil {
    public static void main(String[] args) {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher matcher = r.matcher(line);
        while(matcher.find()){
            System.out.println(matcher.group());//从开头逐个匹配，返回值为”是否发现匹配项“
//            if(matcher.groupCount() > 0){
//                for(int i = 1; i <= matcher.groupCount(); ++i){
//                    System.out.println(matcher.group(i));
//                }
//            }
        }
    }
}
