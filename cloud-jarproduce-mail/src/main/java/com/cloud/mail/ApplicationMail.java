package com.cloud.mail;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @author：xing1
 * @Date：2021/4/15
 * @Time：17:21
 * @Desc：
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@ComponentScan(basePackages = {"com.cloud.mail.MailThreadPool"})
@Slf4j
public class ApplicationMail {

     public static void main(String[] args){
            SpringApplication.run(ApplicationMail.class,args);
            log.info("*****************cloud-jarproduce-mail邮件模块启动成功！*****************");
     }


}
