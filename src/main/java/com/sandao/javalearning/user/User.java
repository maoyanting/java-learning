package com.sandao.javalearning.user;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/08/03
 */
@Data
@ApiModel
public class User {
    @ApiModelProperty("姓名")
    @NotBlank(groups = {ValidationStepOne.class})
    private String name;
    @NotBlank(groups = {ValidationStepTwo.class})
    private String sex;
    private Integer age;
    private CareerEnum career;
    private List<User> children;

    public interface ValidationStepOne {
    }
    public interface ValidationStepTwo {
    }

    /**
     * 创建随机数据
     */
    public static List<User> init(){
        List<User> userList = Lists.newLinkedList();
        List<String> nameList =  Arrays.asList("张三", "王五", "李白","杜甫","白居易");
        Random random = new Random();
        for (int j = 0; j < 5; j++) {
            User user = new User();
            user.setAge(random.nextInt(30));
            user.setName(nameList.get(j));
            user.setSex(random.nextBoolean()?"男":"女");
            user.setCareer(CareerEnum.values()[j%CareerEnum.values().length]);
            userList.add(user);
        }
        return userList;
    }
}
