package com.cloud.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：xing1
 * @Date：2021/2/26
 * @Time：14:45
 * @Desc：
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer role_id;
    private String role_name;
    private String role_key;
    private String role_status;
}
