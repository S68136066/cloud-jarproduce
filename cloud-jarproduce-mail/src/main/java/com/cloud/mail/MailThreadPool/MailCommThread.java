package com.cloud.mail.MailThreadPool;

import com.cloud.common.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Callable;

/**
 * @author：xing1
 * @Date：2021/4/15
 * @Time：17:39
 * @Desc：邮件发送线程
 **/
@Component
public class MailCommThread implements Callable {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    public static MailCommThread mailCommThread;

    /**
     * 初始化
     */
    @PostConstruct
    public void initOvid(){
        mailCommThread = this;
        mailCommThread.javaMailSender = this.javaMailSender;
    }

    private String name;

    private String username;

    private String mailaddrss;

    public MailCommThread() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMailaddrss(String mailaddrss) {
        this.mailaddrss = mailaddrss;
    }

    /**
     * 邮件发送线程
     * @return
     * @throws Exception
     */
    @Override
    public synchronized Object call() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        // 发件人
        message.setFrom("xing18332916523@163.com");
        // 收件人
        message.setTo(mailaddrss);
        // 邮件标题
        message.setSubject("验证码");
        // 邮件内容
        int num = (int) ((Math.random() * 9 + 1) * 100000);
        message.setText("你好，您的验证码是 " + num + " 请尽快使用，有效期只有三分钟");
        // 抄送人
        mailCommThread.javaMailSender.send(message);
        return new CommonResult(200,"邮件发送成功！",null);
    }
}
