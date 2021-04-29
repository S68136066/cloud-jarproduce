package com.cloud.admin.controller;

import com.cloud.admin.outservice.outmailService;
import com.cloud.admin.service.UserService;
import com.cloud.admin.entities.User;
import com.cloud.admin.util.CommonResult;
import com.cloud.admin.util.CrossOriginUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author：
 * @Date：2021/2/5
 * @Time：15:42
 * @Desc：
 **/
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private outmailService outmailService;
    /**
     * 用户登录功能
     * 结合Shiro权限
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/login")
    public CommonResult login(@RequestParam(value = "username", required = false)String username,@RequestParam(value = "password", required = false)String password, HttpServletRequest request, HttpServletResponse response){
        log.info("********用户登录********");
        if("".equals(username)||null == username||"".equals(username)||null == username){
            return new CommonResult(400,"用户名和密码不能为空！");
        }else{
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            Subject currentUser = SecurityUtils.getSubject();
            try{
                //主体提交登录请求到SecurityManger管理器
                currentUser.login(token);
            }catch (IncorrectCredentialsException ice){
                return new CommonResult(300,"密码不正确",null);
            }catch(UnknownAccountException uae){
                return new CommonResult(301,"账号不存在",null);
            }catch(AuthenticationException ae){
                return new CommonResult(302,"账户被禁用",null);
            }
            if(currentUser.isAuthenticated()){
                User user = userService.selectUser(username);
                log.info("用户："+token.getUsername()+"认证成功！");
                return new CommonResult(200,"用户认证成功,serverPort: "+serverPort,user);
            }else {
                token.clear();
                return new CommonResult(303,"用户认证失败",username);
            }
        }

    }
    /**
     * 用户查询
     * @param username
     * @return
     */
    @GetMapping(value = "/selectUser/{username}")
    public CommonResult getUserByUserName(@PathVariable("username")String username){
        log.info("**********用户查询**********");
        if("".equals(username)|| username == null){
            return new CommonResult(400,"查询用户名不能为空！");
        }else {
            User user = userService.selectUser(username);
            if(user != null){
                return new CommonResult(200,"查询成功,serverPort: "+serverPort,user);
            }else {
                return new CommonResult(400,"查询失败",null);
            }
        }

    }

    /**
     * 用户注册功能
     * @param user
     * @return
     */
    @PostMapping(value = "/userRegister")
    public CommonResult userRegister(@RequestBody User user,@RequestParam("role_id")Integer role_id){
     if(user != null && !"".equals(user)){
          Boolean istrue = userService.userRegister(user,role_id);
          if(istrue){
              return new CommonResult(200,"用户注册成功！",user);
          }else {
              return new CommonResult(400,"用户注册失败！",user);
          }
     }else {
         log.info("用户输入值为空！");
         return new CommonResult(400,"用户注册信息不能为空！",null);
     }
    }
}
