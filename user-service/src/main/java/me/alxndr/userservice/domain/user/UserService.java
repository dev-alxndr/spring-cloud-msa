package me.alxndr.userservice.domain.user;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
public interface UserService {

    UserInfo createUser(UserCommand.Signup request);

    UserInfo.includeOrders findByUserId(String userId);

    Iterable<UserInfo> getUsers();

}
