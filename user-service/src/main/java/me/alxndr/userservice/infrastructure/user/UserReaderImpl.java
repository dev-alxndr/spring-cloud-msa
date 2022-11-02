package me.alxndr.userservice.infrastructure.user;

import lombok.RequiredArgsConstructor;
import me.alxndr.userservice.domain.user.UserReader;
import org.springframework.stereotype.Component;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
@Component
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {

    private final UserRepository userRepository;

}
