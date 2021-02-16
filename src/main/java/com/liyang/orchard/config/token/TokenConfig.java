package com.liyang.orchard.config.token;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class TokenConfig extends WebMvcConfigurerAdapter {
    @Bean
    public TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor();
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor())
//                .addPathPatterns("/**")
//                //不拦截的请求路径
//                .excludePathPatterns("/","/error","/static/**",
//                        "/swagger-ui.html","/swagger-resources/**","/v2/api-docs","/webjars/springfox-swagger-ui/**","/csrf",
//                        "/SMSCallback","/SMS","/login","/register");
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}