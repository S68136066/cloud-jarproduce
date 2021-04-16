package com.cloud.mail.controller;

import com.cloud.common.utils.CommonResult;
import com.cloud.mail.MailThreadPool.MailCommThread;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/sendemail")
    public CommonResult sendMail(@RequestParam(value = "mailaddrss", required = false)String mailaddrss) throws ExecutionException, InterruptedException {
        MailCommThread mt = new MailCommThread();
        mt.setUsername(mailaddrss);
        FutureTask<CommonResult> futureTask = new FutureTask<CommonResult>(mt);
        Thread tt = new Thread(futureTask);
        tt.start();
        return futureTask.get();
    }
}
