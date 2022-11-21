package me.alxndr.userservice.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author : Alexander Choi
 * @date : 2022/11/21
 */
@Data
public class RequestLogin {

    @NotNull(message = "Email can not be null")
    @Size(min = 2, message = "Email not be less then 2 characters")
    @Email
    private String email;

    @NotNull(message = "Password can not be null")
    @Size(min = 8, message = "Password must be equals or grater then 8 characters")
    private String password;

}
