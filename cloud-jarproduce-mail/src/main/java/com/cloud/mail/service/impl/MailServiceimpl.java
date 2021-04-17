package com.cloud.mail.service.impl;


import com.cloud.common.utils.CommonResult;
import com.cloud.mail.MailThreadPool.MailCommThread;
import com.cloud.mail.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
@Service
@Slf4j
public class MailServiceimpl implements MailService {

    /**
     * 邮件发送
     * @param mailaddrss
     * @return
     */
    @Override
    public CommonResult sendEmail(String mailaddrss) throws ExecutionException, InterruptedException {
        MailCommThread mt = new MailCommThread();
        mt.setMailaddrss(mailaddrss);
        log.info("邮件地址："+mailaddrss);
        FutureTask<CommonResult> futureTask = new FutureTask<CommonResult>(mt);
        Thread tt = new Thread(futureTask);
        tt.start();
        return futureTask.get();
    }
}
