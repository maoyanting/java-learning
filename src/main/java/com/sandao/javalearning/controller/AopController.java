package com.sandao.javalearning.controller;

import com.sandao.javalearning.aop.annotation.MyAuth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/08/13
 */
@RestController
public class AopController {

    @GetMapping("/hello")
    @MyAuth(className = "hello word")
    public String testController(){
        return "hello word!";
    }
}
