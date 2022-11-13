package me.alxndr.userservice.infrastructure.user;

import lombok.RequiredArgsConstructor;
import me.alxndr.userservice.domain.user.User;
import me.alxndr.userservice.domain.user.UserReader;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
@Component
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {

    private final UserRepository userRepository;

    @Override
    public User findByUserId(final String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public List<User> findByUsers() {
        return (List<User>) userRepository.findAll();
    }
}
