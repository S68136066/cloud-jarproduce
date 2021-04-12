package com.cloud.admin.dao;

import com.cloud.admin.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author：
 * @Date：2021/2/5
 * @Time：15:02
 * @Desc：
 **/
@Mapper
public interface UserDao {
    /**
     * 用户查询
     * @param
     * @return
     */
    User selectUser(@Param("username")String username);

    /**
     * 用户注册
     * @param user
     * @return
     */
    int userRegister(@Param("user") User user);

    /**
     * 用户-角色关联
     * @param role_id
     * @param user_id
     * @return
     */
    int RoleOrUser(@Param("role_id")Integer role_id,@Param("user_id")Integer user_id);
}
