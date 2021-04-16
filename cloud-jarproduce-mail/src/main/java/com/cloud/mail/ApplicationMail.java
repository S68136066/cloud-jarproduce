package com.cloud.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author：xing1
 * @Date：2021/4/15
 * @Time：17:21
 * @Desc：
 **/
@SpringBootApplication
@EnableEurekaClient
public class ApplicationMail {

     public static void main(String[] args){
            SpringApplication.run(ApplicationMail.class,args);
     }
}
