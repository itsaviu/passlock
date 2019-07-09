package com.uas.passlock.models.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @Email
    private String emailId;

    private String mobileNumber;

}
