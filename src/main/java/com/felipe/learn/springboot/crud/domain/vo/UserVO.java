package com.felipe.learn.springboot.crud.domain.vo;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class UserVO {

    private Integer id;
    private String name;
    private Instant birthday;
    private String address;
    private Integer phone;
}
