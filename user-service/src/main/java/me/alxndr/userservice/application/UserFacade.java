package me.alxndr.userservice.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.alxndr.userservice.domain.user.UserCommand;
import me.alxndr.userservice.domain.user.UserInfo;
import me.alxndr.userservice.domain.user.UserService;
import me.alxndr.userservice.interfaces.dto.UserDto;
import me.alxndr.userservice.interfaces.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserInfo signUp(UserDto.Signup request) {
        UserCommand.Signup command = userMapper.toCommand(request);

        return userService.createUser(command);
    }


}
