package com.cloud.admin.outservice;

import com.cloud.common.utils.CommonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author：xing1
 * @Date：2021/4/19
 * @Time：16:57
 * @Desc：
 **/
@FeignClient("cloud-mail-service")
@RequestMapping("/mail")
public interface outmailService {
    /**
     * 发送邮件
     * @param mailaddrss
     * @return
     */
    @PostMapping("/sendemail")
    CommonResult sendEmail(@Param("mailaddrss") String mailaddrss);

}
