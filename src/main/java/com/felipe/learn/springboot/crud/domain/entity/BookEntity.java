package com.felipe.learn.springboot.crud.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Builder
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @Column(name = "book_id", nullable = false)
    @Id
    private Integer id;

    @Column(name = "book_title", nullable = true)
    private String title;

    @Column(name = "subtitle", nullable = true)
    private String subtitle;

    @Column(name = "series_name", nullable = true)
    private String series;

    @Column(name = "price", nullable = true)
    private String price;

    @Column(name = "pages", nullable = true)
    private Integer pages;

    @Column(name = "author", nullable = true)
    private String author;

    @Column(name = "book_description", nullable = true)
    private String description;


}
