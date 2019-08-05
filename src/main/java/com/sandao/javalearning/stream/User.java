package com.sandao.javalearning.stream;

import lombok.Data;

import java.util.Map;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/08/03
 */
@Data
public class User {
    private String name;
    private String sex;
    private String age;
    private Map<String,String> extend;
}
