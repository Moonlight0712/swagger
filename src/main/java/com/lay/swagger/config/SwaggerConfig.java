package com.lay.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author Dragon code!
 * @create 2022-08-24 17:20
 *
 * swagger2的配置类
 *
 * 如何做到只在生产环境使用我们的swagger，而不是在发布的时候使用？
 * 1.判断是否是生产环境。
 * 2.具体做法是配置多个配置文件，然后根据配置文件写入不同的值
 */
//@Configuration
////开启swagger
//@EnableSwagger2
public class SwaggerConfig {
    //配置swagger的docket的bean实例
    //使用docket对象去接管了他原来的配置
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                //选择是否启动swagger，false表示不能在浏览器中启动swagger
                .enable(false)
                .select()
                //RequestHandlerSelectors,配置要扫描接口的方式
                //basePackages指定要扫描的包
                //any扫描全部
                //none都不扫描
                //withClassAnnotation：扫描类上的注解
                .apis(RequestHandlerSelectors.basePackage("com.lay.swagger.controller"))
                //过滤什么路径
                .paths(PathSelectors.ant("/jay/**"))
                .build();
    }

    /**
     * DEFAULT = new ApiInfo("Api Documentation", "Api Documentation", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
     *
     * @return
     */
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("汤世佳", "", "854108766@qq.com");
        return new ApiInfo("搁浅的Swagger文档", "我只能永远读着对白", "1.0", "", contact, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }

}
