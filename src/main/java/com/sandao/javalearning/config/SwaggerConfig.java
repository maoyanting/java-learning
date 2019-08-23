package com.sandao.javalearning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/08/21
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.infoApi().build());
        return docket;
    }

    /**
     * 文档信息配置
     */
    private ApiInfoBuilder infoApi() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        //标题
        apiInfoBuilder.title("Swagger 文档");
        //文档描述
        apiInfoBuilder.description("Swagger 文档 描述");
        //服务条款网址
        apiInfoBuilder.termsOfServiceUrl("https://maoyanting.com");
        //联系方式
        apiInfoBuilder.contact(new Contact("sandao","https://maoyanting.com","fhmaoyanting@163.com"));
        //开源协议
        apiInfoBuilder.license("MIT 协议");
        //开源协议地址
        apiInfoBuilder.licenseUrl("http://www.opensource.org/licenses/MIT");
        //版本号
        apiInfoBuilder.version("1.0");

        return apiInfoBuilder;
    }
}

