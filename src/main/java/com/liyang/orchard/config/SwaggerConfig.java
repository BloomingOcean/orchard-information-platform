package com.liyang.orchard.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2 // 启用 Swagger2
@Profile({"dev","test","local"})
public class SwaggerConfig {

    @Value("${sys.version}")
    private String systemPublish;

    /**
     * swagger2的配置文件
     * @return Docket
     */
    @Bean
    public Docket studentApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ORCHARDAPI")
                .pathMapping("/")
                .select()
                    .apis(RequestHandlerSelectors.basePackage("com"))
                    //不监控 测试api
                    .paths(Predicates.not(PathSelectors.regex("/Ex.*")))
                    //过滤的接口
                    .paths(PathSelectors.regex("/.*"))
                .build()
                // 统一加入Authorize/ToKen等公共参数
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .apiInfo(studentApiInfo());
    }

    /**
     * 设置api信息
     * @return Api构建
     */
    private ApiInfo studentApiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("果园平台后台系统API")
                // 定义版本号
                .version(systemPublish)
                // 设置联系人
                .contact(
                        new Contact("Liyang  ->GitHub", "https://github.com/MyGentleLife", "1519365158@qq.com"))
                // 描述
                .description("果园平台后台系统-系统管理API")
                .build();
    }

    private List<ApiKey> securitySchemes() {
        return new ArrayList(
                Collections.singleton(new ApiKey("Authorization", "Authorization", "header")));
    }

    private List<SecurityContext> securityContexts() {
        return new ArrayList(
                Collections.singleton(SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build())
        );
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return new ArrayList(
                Collections.singleton(new SecurityReference("Authorization", authorizationScopes)));
    }

//    /**
//     * swagger2的配置文件
//     * 设置Api组
//     * @return Docket
//     */
//    @Bean
//    public Docket teacherApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("TeacherAPI")
//                .pathMapping("/")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com"))
//                //不监控 测试api
//                .paths(Predicates.not(PathSelectors.regex("/Ex.*")))
//                //过滤的接口
//                .paths(PathSelectors.regex("/.*"))
//                .build()
//                .apiInfo(studentApiInfo());
//    }
//
//    /**
//     * 设置api信息
//     * @return Api构建
//     */
//    private ApiInfo teacherApiInfo() {
//        return new ApiInfoBuilder()
//                // 设置页面标题
//                .title("管理系统")
//                // 定义版本号
//                .version(systemPublish)
//                // 设置联系人
//                .contact(
//                        new Contact("Liyang  ->GitHub", "https://github.com/MyGentleLife", "1519365158@qq.com"))
//                // 描述
//                .description("管理-API")
//                .build();
//    }

}
