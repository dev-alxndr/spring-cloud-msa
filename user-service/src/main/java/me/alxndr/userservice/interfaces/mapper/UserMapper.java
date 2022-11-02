package me.alxndr.userservice.interfaces.mapper;

import me.alxndr.userservice.domain.user.UserCommand;
import me.alxndr.userservice.interfaces.UserDto;
import org.mapstruct.*;

import java.util.UUID;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {

    @Mapping(target = "userId", expression = "java(generateUserId())")
    UserCommand.Signup toCommand(UserDto.Signup request);


    default String generateUserId() {
        return UUID.randomUUID().toString();
    }

}


