package me.alxndr.userservice.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : Alexander Choi
 * @date : 2022/10/23
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Greeting {

    @Value("${greeting.message}")
    private String message;

}
