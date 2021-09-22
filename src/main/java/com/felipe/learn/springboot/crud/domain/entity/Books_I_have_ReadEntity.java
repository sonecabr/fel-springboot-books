package com.felipe.learn.springboot.crud.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;





@Entity
@Table(name = "books_i_have_read")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Books_I_have_ReadEntity {
@Id

@Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Column(name = "book_id", nullable = false)
    private Integer book_id;

   @Column(name = "whenIsatarted", nullable = false)
    private String WhenIstarted;

   @Column (name ="whenIfinished", nullable = false)
    private String whenIfinished;


}
