package com.free.my.fs.core.domain.dto;

import java.io.Serial;
import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class UpdateFileNameDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id不能为空")
    private Long id;

    @NotBlank(message = "文件名不能为空")
    private String name;

    @NotBlank(message = "文件重命名不能为空")
    private String rename;

}
