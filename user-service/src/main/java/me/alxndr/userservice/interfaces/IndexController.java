package me.alxndr.userservice.interfaces;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.alxndr.userservice.common.vo.Greeting;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
@RestController
@Slf4j
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class IndexController {

    private final Greeting greeting;

    @GetMapping("/")
    public String hello() {
        return "hello User service";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request) {
        log.info("Server port = {}", request.getServerPort());

        return String.format("Hi My Port is %s", greeting.getMessage());
    }

    @GetMapping("/health-check")
    public String status() {
        return "User Service is UP!";
    }
}
