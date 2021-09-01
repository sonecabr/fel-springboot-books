package com.felipe.learn.springboot.crud.domain.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    @JsonAlias("id")
    private Integer id;
    @JsonAlias("name")
    private String name;
    @JsonAlias("birthday")
    private Instant birthday;
    @JsonAlias("address")
    private String address;
    @JsonAlias("phone")
    private Integer phone;
}
