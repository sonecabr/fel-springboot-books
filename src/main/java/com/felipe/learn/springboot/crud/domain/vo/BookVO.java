package com.felipe.learn.springboot.crud.domain.vo;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class BookVO {

    private Integer id;
    private String title;
    private String subtitle;
    private String series;
    private String price;
    private Integer pages;
    private String author;
    private String description;
}
