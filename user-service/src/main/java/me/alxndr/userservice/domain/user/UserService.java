package me.alxndr.userservice.domain.user;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
public interface UserService extends UserDetailsService {

    UserInfo createUser(UserCommand.Signup request);

    UserInfo.includeOrders findByUserId(String userId);

    Iterable<UserInfo> getUsers();

    UserInfo findByEmail(String email);

}
