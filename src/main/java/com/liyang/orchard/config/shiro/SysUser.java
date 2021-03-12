package com.liyang.orchard.config.shiro;

import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "用户权限")
public class SysUser implements Serializable {
    private static final long serialVersionUID = 4522943071576672084L;
    private Integer userId;
    private String username;
    private String password;
    private String userRole;
    private String userPermission;
}