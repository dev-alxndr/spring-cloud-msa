package me.alxndr.userservice.domain.user;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import me.alxndr.userservice.vo.ResponseOrder;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : Alexander Choi
 * @date : 2022/11/13
 */

@Builder
@Data
public class UserInfo {

    private String email;

    private String userId;

    private String name;

    private LocalDateTime createdAt;

    @Data
    public static class includeOrders {
        private String email;

        private String userId;

        private String name;

        private LocalDateTime createdAt;

        private List<ResponseOrder> orders;
    }

}
