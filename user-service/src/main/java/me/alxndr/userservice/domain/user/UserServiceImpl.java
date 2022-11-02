package me.alxndr.userservice.domain.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.alxndr.userservice.interfaces.UserDto;
import org.springframework.stereotype.Service;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserStore userStore;

    @Override
    public void createUser(UserCommand.Signup request) {
        
    }
}
