package com.cloud.common.utils;

import com.cloud.common.autoexception.CustomException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author：xing1
 * @Date：2021/5/10
 * @Time：16:02
 * @Desc：
 **/
public class TimerUtil {
    /**
     * 获取昨天日期
     * 日期格式yyyy-MM-dd
     * 返回类型String
     * @return
     */
    public  String getYestoDay(String format) throws CustomException {
        if(format == "" || format ==null){
            throw new CustomException("日期格式不能为空!");
        }
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat(format);
        String yestoday=sp.format(d);
        return yestoday;
    }
}
