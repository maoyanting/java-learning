package com.sandao.javalearning.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/08/21
 */
@Data
@ApiModel
public class Good {
    @NotNull
    @ApiModelProperty("名称")
    private String goodName;
    @NotNull
    @ApiModelProperty("价格")
    private String price;
}
