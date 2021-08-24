package com.felipe.learn.springboot.crud.domain.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HelloVO {
    private Integer id;
    private String name;
    
}
