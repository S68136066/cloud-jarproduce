package com.cloud.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：xing1
 * @Date：2021/3/2
 * @Time：17:36
 * @Desc：
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleOrUser {
    private Integer role_id;
    private Integer user_id;
}
