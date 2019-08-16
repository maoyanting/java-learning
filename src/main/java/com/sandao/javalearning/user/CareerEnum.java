package com.sandao.javalearning.user;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/08/14
 */
public enum  CareerEnum {
    /**
     *
     */
    WRITER("writer","作家"),
    ENGINEER("engineer","工程师");
    private String code;
    private String name;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    CareerEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
