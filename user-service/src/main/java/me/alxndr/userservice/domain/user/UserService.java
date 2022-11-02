package me.alxndr.userservice.domain.user;

import me.alxndr.userservice.interfaces.UserDto;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
public interface UserService {

    void createUser(UserCommand.Signup request);

}
