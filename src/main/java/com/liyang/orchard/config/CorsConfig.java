package com.liyang.orchard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        //允许所有域名跨域
        config.setAllowedOrigins(Arrays.asList("*"));
        //允许所有请求头
        config.setAllowedHeaders(Arrays.asList("*"));
        //允许所有方法
        config.setAllowedMethods(Arrays.asList("*"));
        config.setMaxAge(300L);
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);

    }
}