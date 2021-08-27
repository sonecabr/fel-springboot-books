package com.felipe.learn.springboot.crud.domain.vo;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class HiVO {
    private Integer id;
    private String title;
    private String subtitle;
    private String series;
    private String price;
    private Integer pages;
    private String author;
    private String description;
}

