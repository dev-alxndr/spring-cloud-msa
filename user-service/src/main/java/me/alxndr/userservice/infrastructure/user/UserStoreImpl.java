package me.alxndr.userservice.infrastructure.user;

import lombok.RequiredArgsConstructor;
import me.alxndr.userservice.domain.user.User;
import me.alxndr.userservice.domain.user.UserStore;
import org.springframework.stereotype.Component;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
@Component
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {


    private final UserRepository userRepository;

    @Override
    public User save(User newUser) {
        return userRepository.save(newUser);
    }
}
