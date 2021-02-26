package com.cloud.admin.service;

import com.cloud.common.entities.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：xing1
 * @Date：2021/2/26
 * @Time：17:47
 * @Desc：
 **/
public interface RoleService {
    /**
     * 查询角色列表
     * @return
     */
    List<Role> SelectRoleAll();
}
