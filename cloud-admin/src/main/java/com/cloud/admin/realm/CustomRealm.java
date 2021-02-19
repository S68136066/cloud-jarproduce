package com.cloud.admin.realm;

import com.cloud.admin.service.UserService;
import com.cloud.admin.service.impl.UserServiceImpl;
import com.cloud.admin.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author：lixx
 * @Date：2021/2/5
 * @Time：14:30
 * @Desc：：域，Shiro从从Realm获取安全数据（如用户、角色、权限），就是说SecurityManager要验证用户身份，那么它需要从Realm获取相应的用户进行比较以确定用户身份是否合法；也需要从Realm得到用户相应的角色/权限进行验证用户是否能进行操作；可以把Realm看成DataSource，即安全数据源。
 **/
@Slf4j
@Component
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UserService userService = new UserServiceImpl();

    @Autowired
    public static CustomRealm customRealm;

    /**
     * 初始化userService接口中的方法 在非Controller中使用
     */
    @PostConstruct
    public void initOvid(){
        customRealm = this;
        customRealm.userService = this.userService;
    }
    /**
     * 重写认证方法
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户输入的账号
        String username = (String) token.getPrincipal();
        // 获取user
        User user =customRealm.userService.selectUser(username);
        if(user == null){
            return null;
        }
        // 通过Sim做身份处理
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        // 状态验证
        if(user.getAvailable() == 0){
            log.info("账号禁用");
            throw new AuthenticationException("该账号已被禁用");
        }
        return simpleAuthenticationInfo;
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
