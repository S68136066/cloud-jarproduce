package com.cloud.admin.dao;

import com.cloud.common.entities.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author：xing1
 * @Date：2021/2/26
 * @Time：17:49
 * @Desc：
 **/
@Mapper
public interface RoleDao {
    /**
     * 查询角色列表
     */
    List<Role> SelectRoleAll();
}
