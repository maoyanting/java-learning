package com.sandao.javalearning.stream;

import lombok.Data;

import java.util.List;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/08/03
 */
@Data
public class User {
    private String name;
    private String sex;
    private Integer age;
    private List<User> children;
}
