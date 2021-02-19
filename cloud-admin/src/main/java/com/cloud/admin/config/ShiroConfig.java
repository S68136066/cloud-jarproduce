package com.cloud.admin.config;

import com.cloud.admin.realm.CustomRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author：lixx
 * @Date：2021/2/5
 * @Time：14:01
 * @Desc：
 **/
@Configuration
public class ShiroConfig {

    /**
     * 配置Shiro核心 安全管理器 SecurityManager
     * SecurityManager安全管理器：所有与安全有关的操作都会与SecurityManager交互；且它管理着所有Subject；负责与后边介绍的其他组件进行交互。（类似于SpringMVC中的DispatcherServlet控制器）
     */
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //将自定义的realm交给SecurityManager管理
        securityManager.setRealm(new CustomRealm());
        return securityManager;
    }


    /**
     * 配置Shiro的web过滤器，拦截浏览器请求并交给拦截器处理
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean webFilter(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        // 配置拦截链
        Map<String,String> filterChainMap = new LinkedHashMap<String,String>(16);

        // authc:所有url都必须认证通过才可以访问; anon:所有url都可以匿名访问,先配置anon再配置authc
//        filterChainMap.put("/**","anon");
//        //filterChainMap.put("/selectUser","anon");
//        filterChainMap.put("/**","authc");
//
//        //拦截请求后跳转的URL
//        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;
    }

}
