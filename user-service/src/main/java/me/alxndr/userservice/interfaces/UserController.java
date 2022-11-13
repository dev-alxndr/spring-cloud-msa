package me.alxndr.userservice.interfaces;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.alxndr.userservice.application.UserFacade;
import me.alxndr.userservice.domain.user.UserCommand;
import me.alxndr.userservice.domain.user.UserInfo;
import me.alxndr.userservice.interfaces.dto.UserDto;
import me.alxndr.userservice.interfaces.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user-service")
public class UserController {

    private final UserFacade userFacade;


    @PostMapping("/users")
    public ResponseEntity signUp(@RequestBody UserDto.Signup request) {

        UserInfo userInfo = userFacade.signUp(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userInfo);
    }

}
