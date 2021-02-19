package com.cloud.admin.service.impl;

import com.cloud.admin.dao.UserDao;
import com.cloud.admin.entities.User;
import com.cloud.admin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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



}
