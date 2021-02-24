package com.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author：xing1
 * @Date：2021/2/20
 * @Time：11:09
 * @Desc：
 **/
@SpringBootApplication
@EnableEurekaClient
public class ApplicationGateway {
     public static void main(String[] args){

         SpringApplication.run(ApplicationGateway.class,args);
     }

}
