package com.cloud.admin.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：lixx
 * @Date：2021/2/5
 * @Time：11:24
 * @Desc：
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer user_id;
    private String username;
    private String password;
    private String phone;
    private Integer available;
    private String chinaname;
    private String mail;


}
