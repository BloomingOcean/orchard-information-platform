package com.liyang.orchard.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2 // 启用 Swagger2
//@Profile({"dev","test","local"})
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
//                .securitySchemes(Arrays.asList(securityScheme()))
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

    /**
     * 采用了 OAuthBuilder 来构建，构建时即得配置 token 的获取地址
     * 好处就是不用通过其他途径获取 access_token，直接在 swagger-ui 页面输入 password 模式的认证参数即可
     * 非常方便，仅限于 OAuth2 模式
     * @return SecurityScheme
     */
    private SecurityScheme securityScheme() {
//        GrantType grant = new ResourceOwnerPasswordCredentialsGrant("http://localhost:7489/oauth/token");
        GrantType grant = new ResourceOwnerPasswordCredentialsGrant("http://localhost:7489/login");
        return new OAuthBuilder().name("OAuth2")
                .grantTypes(Arrays.asList(grant))
                .scopes(Arrays.asList(scopes()))
                .build();
    }

    /**
     * 定义范围
     * @return AuthorizationScope[]
     */
    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[]{
                new AuthorizationScope("all", "all scope")
        };
    }


    /**
     * 配置有哪些请求需要携带 Token
     * @return List<SecurityContext>
     */
    private List<SecurityContext> securityContexts() {
        return new ArrayList(
                Collections.singleton(SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        // 过滤不需要token验证的接口（没实现好）
                        .forPaths(PathSelectors.regex("^(?!login).*$"))
//                        .forPaths(PathSelectors.regex("^(?!logout).*$"))
//                        .forPaths(PathSelectors.regex("^(?!register).*$"))
//                        .forPaths(PathSelectors.regex("^(?!SMS).*$"))
//                        .forPaths(PathSelectors.regex("^(?!SMSCallBack).*$"))
//                        .forPaths(PathSelectors.regex("^(?!verifyCode).*$"))
                        // 配置了所有请求都需要携带Token
//                        .forPaths(PathSelectors.any())
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
