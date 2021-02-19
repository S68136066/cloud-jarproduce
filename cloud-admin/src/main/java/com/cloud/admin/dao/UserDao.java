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

}
