package com.cloud.common.autoexception;

/**
 * @author：xing1
 * @Date：2021/5/10
 * @Time：16:25
 * @Desc：自定义异常类
 **/
public class CustomException extends Exception {

    private String message;

    public  CustomException(String message){
        super(message);
        this.message=message;
    }

}
