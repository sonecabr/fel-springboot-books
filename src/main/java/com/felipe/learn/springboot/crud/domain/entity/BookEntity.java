package com.felipe.learn.springboot.crud.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Cleanup;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "book")
@Data
public class BookEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id", nullable = false)
    @Id
    private Integer id;

    @Column(name = "book_title", nullable = false)
    private String title;

    @Column(name = "subtitle", nullable = false)
    private String subtitle;

    @Column(name = "series_name", nullable = false)
    private String series;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "pages", nullable = false)
    private Integer pages;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "book_description", nullable = false)
    private String description;


}
