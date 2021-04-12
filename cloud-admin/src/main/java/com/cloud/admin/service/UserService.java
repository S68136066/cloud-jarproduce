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

    /**
     * 用户注册
     * @param user
     * @return
     */
    Boolean userRegister(@Param("user") User user,@Param("role_id")Integer role_id);

//    /**
//     * 用户-角色关联
//     * @param role_id
//     * @param user_id
//     * @return
//     */
//    Boolean RoleOrUser(@Param("role_id")Integer role_id,@Param("user_id")Integer user_id);
}
