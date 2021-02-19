package com.cloud.Euraker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author：lixx
 * @Date：2021/2/7
 * @Time：13:55
 * @Desc：
 **/
@SpringBootApplication
@EnableEurekaServer
public class ApplicationEurekaServer {
     public static void main(String[] args){
            SpringApplication.run(ApplicationEurekaServer.class,args);
            System.out.println("*********Eurake注册中心启动完毕*********");
     }
}
