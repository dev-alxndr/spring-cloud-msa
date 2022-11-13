package me.alxndr.userservice.interfaces;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.alxndr.userservice.application.UserFacade;
import me.alxndr.userservice.domain.user.UserInfo;
import me.alxndr.userservice.interfaces.dto.UserDto;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user-service")
public class UserController {

    private final Environment environment;
    private final UserFacade userFacade;


    @PostMapping("/users")
    public ResponseEntity signUp(@RequestBody UserDto.Signup request) {

        UserInfo userInfo = userFacade.signUp(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userInfo);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserInfo>> getUsers() {
        final List<UserInfo> userInfos = userFacade.findAll();

        return ResponseEntity.ok(userInfos);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserInfo.includeOrders> getUser(@PathVariable final String userId) {
        final UserInfo.includeOrders userInfo = userFacade.findByUserId(userId);

        return ResponseEntity.ok(userInfo);
    }


    @GetMapping("/check")
    public String check(HttpServletRequest request) {
        log.info("Server port = {}", request.getServerPort());

        return String.format("Hi My Port is %s", request.getServerPort());
    }

    @GetMapping("/health-check")
    public String status() {
        return String.format("User Service is UP! on PORT %s", environment.getProperty("local.server.port"));
    }

}
