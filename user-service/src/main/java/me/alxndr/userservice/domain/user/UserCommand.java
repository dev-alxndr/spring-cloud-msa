package me.alxndr.userservice.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
public class UserCommand {

    @Getter
    @Builder
    @ToString
    public static class Signup {

        private String email;

        private String name;

        private String password;

        private String userId;

        private LocalDateTime createdAt;
    }

}
