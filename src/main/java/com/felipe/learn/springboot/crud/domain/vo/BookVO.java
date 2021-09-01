package com.felipe.learn.springboot.crud.domain.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookVO {
    @JsonAlias("id")
    private Integer id;
    @JsonAlias("title")
    private String title;
    @JsonAlias("subtitle")
    private String subtitle;
    @JsonAlias("series")
    private String series;
    @JsonAlias("price")
    private String price;
    @JsonAlias("pages")
    private Integer pages;
    @JsonAlias("author")
    private String author;
    @JsonAlias("description")
    private String description;
}
