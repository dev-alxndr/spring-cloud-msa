package me.alxndr.userservice.domain.user;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author : Alexander Choi
 * @date : 2022/11/13
 */

@Getter
@Builder
public class UserInfo {

    private String email;

    private String userId;

    private String name;

    private LocalDateTime createdAt;

}
