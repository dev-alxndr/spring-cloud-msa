package me.alxndr.userservice.interfaces.dto;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
public class UserDto {

    @Data
    public static class Signup {
        @NotNull(message = "Email cannot be null")
        @Email
        private String email;

        @NotNull(message = "Name cannot be null")
        private String name;

        @NotNull(message = "password cannot be null")
        @Size(min = 8)
        private String password;
    }

}
