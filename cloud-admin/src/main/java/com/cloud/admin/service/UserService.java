package com.cloud.admin.service;

import com.cloud.admin.entities.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author：lixx
 * @Date：2021/2/5
 * @Time：15:04
 * @Desc：
 **/
public interface UserService {
    /**
     * 查询用户
     * @return
     */
    User selectUser(@Param("username")String username);
}
