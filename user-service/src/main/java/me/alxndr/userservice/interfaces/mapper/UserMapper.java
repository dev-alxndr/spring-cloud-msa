package me.alxndr.userservice.interfaces.mapper;

import me.alxndr.userservice.domain.user.User;
import me.alxndr.userservice.domain.user.UserCommand;
import me.alxndr.userservice.domain.user.UserInfo;
import me.alxndr.userservice.interfaces.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {

    @Mapping(target = "userId", expression = "java(generateUserId())")
    UserCommand.Signup toCommand(UserDto.Signup request);

    User toEntity(UserCommand.Signup command);

    UserInfo toInfo(User user);

    default String generateUserId() {
        return UUID.randomUUID().toString();
    }

}


