package com.cloud.admin.service.impl;

import com.cloud.admin.dao.RoleDao;
import com.cloud.admin.service.RoleService;
import com.cloud.common.entities.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：xing1
 * @Date：2021/2/26
 * @Time：17:48
 * @Desc：
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    /**
     * 查询角色列表
     * @return
     */
    @Override
    public List<Role> SelectRoleAll() {
        return roleDao.SelectRoleAll();
    }
}
