package com.cloud.admin.service.impl;

import com.cloud.admin.dao.UserDao;
import com.cloud.admin.entities.User;
import com.cloud.admin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author：lixx
 * @Date：2021/2/5
 * @Time：15:15
 * @Desc：
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 用户查询
     * @return
     */
    @Override
    public User selectUser(String username) {
        return userDao.selectUser(username);
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public Boolean userRegister(User user,Integer role_id) {
        Integer UserReg = userDao.userRegister(user);
        //用户添加成功 需要向role_user关联表添加
        if(UserReg>0){
            userDao.RoleOrUser(role_id,user.getUser_id());
            return true;
        }
        return false;
    }


}
