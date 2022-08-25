package com.lay.swagger.config;


import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.sun.org.apache.bcel.internal.generic.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.util.AntPathMatcher;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Dragon code!
 * @create 2022-08-24 22:03
 *
 * swagger3的配置类
 *
 * 访问地址：http://localhost:8080/swagger-ui/index.html
 * (swagger2.xx版本访问的地址为http://localhost:8080/swagger-ui.html)
 *
 * 配置knife4j后新的访问界面：http://localhost:8081/doc.html
 */
@EnableKnife4j //在上面配置Swagger的Swagger3Config中添加@EnableKnife4j注解，该注解可以开启knife4j的增强功能。

@Configuration
@EnableOpenApi //开启Swagger3
public class SwaggerConfiguration {
    //配置Swagger的Docket的bean实例
    @Bean
    public Docket docket1(Environment environment) {
        //设置要配置的Swagger环境
        Profiles profiles = Profiles.of("dev", "test");
        //通过environment.acceptsProfiles判断是否处在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//配置Swagger信息
                .enable(flag)
                .groupName("接口分组一")
                .select()
                /**
                 * apis():指定扫描的接口
                 *  RequestHandlerSelectors:配置要扫描接口的方式
                 *       basePackage:指定要扫描的包
                 *       any:扫面全部
                 *       none:不扫描
                 *       withClassAnnotation:扫描类上的注解(参数是类上注解的class对象)
                 *       withMethodAnnotation:扫描方法上的注解(参数是方法上的注解的class对象)
                 */
                .apis(RequestHandlerSelectors.basePackage("com.lay.swagger"))
                /**
                 * paths():过滤路径:只有被过滤筛(也就是过滤的才会在页面显示出来)选出来并且在指定包下面的请求路径才会显示在页面上
                 *  PathSelectors:配置过滤的路径
                 *      any:过滤全部路径
                 *      none:不过滤路径
                 *      ant:过滤指定路径:按照按照Spring的AntPathMatcher提供的match方法进行匹配
                 *      regex:过滤指定路径:按照String的matches方法进行匹配
                 */
//                .paths(PathSelectors.ant("/jay/**"))
                .paths(PathSelectors.any())
                .build()
                .protocols(new HashSet<>(Arrays.asList("http", "https")));   //支持的通讯协议集合;
//                ;

    }

    @Bean
    public Docket docket2(Environment environment) {
        //设置要配置的Swagger环境
        Profiles profiles = Profiles.of("dev", "test");
        //通过environment.acceptsProfiles判断是否处在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//配置Swagger信息
                .enable(flag)
                .groupName("接口分组二")
                .select()
                /**
                 * apis():指定扫描的接口
                 *  RequestHandlerSelectors:配置要扫描接口的方式
                 *       basePackage:指定要扫描的包
                 *       any:扫面全部
                 *       none:不扫描
                 *       withClassAnnotation:扫描类上的注解(参数是类上注解的class对象)
                 *       withMethodAnnotation:扫描方法上的注解(参数是方法上的注解的class对象)
                 */
                .apis(RequestHandlerSelectors.basePackage("com.lay.swagger"))
                /**
                 * paths():过滤路径:只有被过滤筛(也就是过滤的才会在页面显示出来)选出来并且在指定包下面的请求路径才会显示在页面上
                 *  PathSelectors:配置过滤的路径
                 *      any:过滤全部路径
                 *      none:不过滤路径
                 *      ant:过滤指定路径:按照按照Spring的AntPathMatcher提供的match方法进行匹配
                 *      regex:过滤指定路径:按照String的matches方法进行匹配
                 */
//                .paths(PathSelectors.ant("/jay/**"))
                .paths(PathSelectors.any())
                .build()
                .protocols(new HashSet<>(Arrays.asList("http", "https")));   //支持的通讯协议集合;
//                ;

    }

    //配置Swagger信息
    /*String title, String description,
     String version, String termsOfServiceUrl,
     Contact contact, String license,
     String licenseUrl,
     Collection<VendorExtension> vendorExtensions*/
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "搁浅项目",
                "搁浅的Swagger API文档",
                "2.0",//版本信息
                "https://blog.csdn.net/m0_53157173/article/details/119454044?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522166134918216782350811093%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=166134918216782350811093&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_click~default-2-119454044-null-null.142^v42^pc_rank_34,185^v2^control&utm_term=swagger3.0.0%E4%BD%BF%E7%94%A8%E6%95%99%E7%A8%8B&spm=1018.2226.3001.4187",//团队信息的url
                new Contact("swagger教程", "https://blog.csdn.net/m0_53157173/article/details/119454044?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522166134918216782350811093%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=166134918216782350811093&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_click~default-2-119454044-null-null.142^v42^pc_rank_34,185^v2^control&utm_term=swagger3.0.0%E4%BD%BF%E7%94%A8%E6%95%99%E7%A8%8B&spm=1018.2226.3001.4187", "854108766@qq.com"),//作者信息
                /*Contact(String name, String url, String email)*/
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }
}
