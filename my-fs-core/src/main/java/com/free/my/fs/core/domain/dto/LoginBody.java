package com.free.my.fs.core.domain.dto;

import java.io.Serial;
import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class LoginBody implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "账号不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    private boolean rememberMe;
}
