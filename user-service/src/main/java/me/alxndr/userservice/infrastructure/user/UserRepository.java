package me.alxndr.userservice.infrastructure.user;

import me.alxndr.userservice.domain.user.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserId(String userId);

    User findByEmail(String username);
}
