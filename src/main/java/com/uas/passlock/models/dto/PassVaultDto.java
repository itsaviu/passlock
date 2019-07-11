package com.uas.passlock.models.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PassVaultDto {

    @NotNull
    private Long userId;

    @NotNull
    private String url;

    @NotNull
    private String name;

    @NotNull
    private String identity;

    @NotNull
    private String password;

}
