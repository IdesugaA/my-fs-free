package com.free.my.fs.core.domain;

import java.io.Serial;
import java.io.Serializable;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;

import lombok.Data;


@Data
@Table("sys_permission")
public class Permission implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 权限标识
     */
    private String PermissionCode;

    /**
     * 权限名称
     */
    private String PermissionName;
}
