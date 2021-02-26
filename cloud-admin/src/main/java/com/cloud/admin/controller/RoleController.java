package com.cloud.admin.controller;

import com.cloud.admin.service.RoleService;
import com.cloud.admin.util.CommonResult;
import com.cloud.common.entities.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：xing1
 * @Date：2021/2/26
 * @Time：17:52
 * @Desc：
 **/
@RestController
@RequestMapping("/Role")
@Slf4j
public class RoleController {
    @Resource
    private RoleService roleService;
    /**
     * 查询角色列表
     * @return
     */
    @GetMapping(value = "/getRoleList")
    public CommonResult getRoleList(){
        List<Role> RoleList = roleService.SelectRoleAll();
        return new CommonResult(200,"角色列表查询成功",RoleList);
    }
}
