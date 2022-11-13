package me.alxndr.userservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @author : Alexander Choi
 * @date : 2022/11/13
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUser {

    private String email;

    private String name;

    private String userId;

    private List<ResponseOrder> orders;

}
