package com.cloud.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author：lixx
 * @Date：2021/2/5
 * @Time：11:07
 * @Desc：
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ApplicationServer7001 {
     public static void main(String[] args){
         SpringApplication.run(ApplicationServer7001.class,args);
         System.out.println("*********登录认证模块加载完毕☺*********");
     }
}
