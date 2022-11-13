package me.alxndr.userservice.domain.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.alxndr.userservice.interfaces.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserInfo createUser(UserCommand.Signup command) {

        User newUser = userMapper.toEntity(command);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userStore.save(newUser);

        return userMapper.toInfo(newUser);
    }
}
