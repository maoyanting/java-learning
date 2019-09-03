package com.sandao.javalearning.controller;

import com.sandao.javalearning.user.Good;
import com.sandao.javalearning.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/08/21
 */
@Api(tags = "用户相关接口")
@RestController()
@Validated
public class UserController {

    @GetMapping("/testValidName")
    @ApiOperation("校验用户接口")
    public String testValidName(@Validated(User.ValidationStepOne.class) User user, BindingResult userBindingResult, @Valid Good good, BindingResult goodBindingResult){
        //参数校验
        if (userBindingResult.hasErrors()) {
            return "user false";
        }
        if (goodBindingResult.hasErrors()) {
            return "good false";
        }
        return "hello word!";
    }

    @GetMapping("/testValidName2")
    @ApiOperation("校验用户接口")
    public String testValidName2(@Valid User user, BindingResult userBindingResult){
        //参数校验
        if (userBindingResult.hasErrors()) {
            return "user false";
        }
        return "hello word!";
    }

    @GetMapping("/testValidSex")
    @ApiOperation("校验用户接口")
    public String testValidSex(@Validated(User.ValidationStepTwo.class) User user, BindingResult userBindingResult){
        //参数校验
        if (userBindingResult.hasErrors()) {
            return "user false";
        }
        return "hello word!";
    }

    @GetMapping("/testValidParam")
    @ApiOperation("校验基本类型")
    public String testValidParam(@NotNull(message = "name not null") String name,@NotNull(message = "age not null") Integer age){
        return "hello word!";
    }
}
