package me.alxndr.userservice.domain.user;

import java.util.List;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
public interface UserReader {
    User findByUserId(String userId);

    List<User> findByUsers();

    User findByEmail(String username);
}
