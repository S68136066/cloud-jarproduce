package com.cloud.mail.service;

import com.cloud.common.utils.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

/**
 * @author：xing1
 * @Date：2021/4/15
 * @Time：17:24
 * @Desc：
 **/
public interface MailService {
    /**
     * 发送邮件
     * @param mailaddrss
     * @return
     */
    CommonResult sendEmail(@Param("mailaddrss") String mailaddrss) throws ExecutionException, InterruptedException;
}
