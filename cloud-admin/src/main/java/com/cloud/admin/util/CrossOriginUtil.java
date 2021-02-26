package com.cloud.admin.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author：xing1
 * @Date：2021/2/24
 * @Time：10:38
 * @Desc：
 **/
public class CrossOriginUtil {
    public static void setCrossOrigin(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","GET,PUT,DELETE,OPTIONS,POST");
        response.setHeader("Access-Control-Allow-Headers","Access-Control");
        response.setHeader("Allow","POST");
        //添加的
//		response.setHeader("Content-Type","application/json");
//		response.setHeader("charset","utf-8");
    }

    public static boolean  setNewCrossOrigin(HttpServletRequest request, HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin", "*");

        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");

        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");

        response.setHeader("X-Powered-By","Jetty");


        String method= request.getMethod();

        if (method.equals("OPTIONS")){
            response.setStatus(200);
            return true;
        }

        //System.out.println(method);

        return true;
		/*response.setHeader("access-control-allow-origin","*");
		response.setHeader("access-control-allow-methods","GET,PUT,DELETE,OPTIONS,POST");
		response.setHeader("access-control-allow-headers","Access-Control");
		response.setHeader("Allow","POST");
		   if ("OPTIONS".equals(request.getMethod()))
	        {
	            response.setStatus(200);
	            return;
	        }*/
    }
}
