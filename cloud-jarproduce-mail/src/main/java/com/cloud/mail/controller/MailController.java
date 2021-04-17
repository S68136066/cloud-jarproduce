package com.cloud.mail.controller;

import com.cloud.common.utils.CommonResult;
import com.cloud.mail.MailThreadPool.MailCommThread;
import com.cloud.mail.service.MailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author：xing1
 * @Date：2021/4/15
 * @Time：17:26
 * @Desc：
 **/
@RestController
@RequestMapping("/mail")
public class MailController {

    @Resource
    private MailService ms;

    @PostMapping("/sendemail")
    public CommonResult sendMail(@RequestParam(value = "mailaddrss", required = false)String mailaddrss) throws ExecutionException, InterruptedException {
        if(null!=mailaddrss && !" ".equals(mailaddrss)){
           return ms.sendEmail(mailaddrss);
        }else {
            return new CommonResult(201,"邮件地址不能为空！",null);
        }
    }
}
