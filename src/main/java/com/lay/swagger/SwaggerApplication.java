package com.lay.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * swagger2教程：
 * 视频文档信息：https://mp.weixin.qq.com/s/0-c0MAgtyOeKx6qzmdUG0w
 * swagger页面：http://localhost:8080/swagger-ui.html
 *
 * swagger3教程：https://blog.csdn.net/m0_53157173/article/details/119454044?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522166134918216782350811093%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=166134918216782350811093&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_click~default-2-119454044-null-null.142^v42^pc_rank_34,185^v2^control&utm_term=swagger3.0.0%E4%BD%BF%E7%94%A8%E6%95%99%E7%A8%8B&spm=1018.2226.3001.4187
 * swagger页面：http://localhost:8080/swagger-ui/index.html
 *
 * github示例：https://github.com/CoderFreeMan/swagger-demo
 * https://blog.csdn.net/dejunyang/article/details/89527586
 */
@EnableOpenApi
@SpringBootApplication
public class SwaggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
    }
}
