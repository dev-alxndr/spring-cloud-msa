package me.alxndr.userservice.domain.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.alxndr.userservice.interfaces.mapper.UserMapper;
import me.alxndr.userservice.vo.ResponseOrder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserStore userStore;

    private final UserReader userReader;
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserInfo createUser(final UserCommand.Signup command) {

        User newUser = userMapper.toEntity(command);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userStore.save(newUser);

        return userMapper.toInfo(newUser);
    }

    @Override
    public UserInfo.includeOrders findByUserId(final String userId) {
        final User user = userReader.findByUserId(userId);
        if (Objects.isNull(user)) {
            throw new RuntimeException("User Not Found");
        }

        final UserInfo.includeOrders userInfo = userMapper.toIncludeOrders(user);

        final List<ResponseOrder> orders = new ArrayList<>();
        userInfo.setOrders(orders);

        return userInfo;
    }

    @Override
    public Iterable<UserInfo> getUsers() {

        final List<User> users = userReader.findByUsers();

        return users.stream().map(userMapper::toInfo).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User findUser = userReader.findByEmail(username);

        if (Objects.isNull(findUser)) {
            throw new UsernameNotFoundException("Username Not Found");
        }

        return new org.springframework.security.core.userdetails.User(findUser.getEmail(), findUser.getPassword(), new ArrayList<>());
    }
}
