package me.alxndr.userservice.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.alxndr.userservice.domain.user.UserCommand;
import me.alxndr.userservice.domain.user.UserService;
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


    public void signUp(UserCommand.Signup command) {
        userService.createUser(command);
    }


}
