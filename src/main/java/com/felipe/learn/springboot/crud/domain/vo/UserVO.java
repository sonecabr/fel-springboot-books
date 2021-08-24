package com.felipe.learn.springboot.crud.domain.vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserVO {

    private Integer id;
    private String name;
}
