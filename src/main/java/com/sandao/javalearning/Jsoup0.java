package com.sandao.javalearning;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 测试Jsoup
 * @author maoyanting
 * @version V1.0
 * @date 2019/07/26
 */
public class Jsoup0 {
    public static void main(String[] args) {
        deleteHtml();
    }

    private static void deleteHtml(){
        String html = "";
        Document doc = Jsoup.parse(html);
        String text = doc.body().text();
        System.out.println(text);
    }
}
