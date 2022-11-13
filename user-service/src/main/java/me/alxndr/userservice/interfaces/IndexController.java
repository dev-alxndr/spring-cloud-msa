package me.alxndr.userservice.interfaces;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
@RestController
@Slf4j
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class IndexController {


    @GetMapping("/")
    public String hello() {
        return "hello User service";
    }

}
