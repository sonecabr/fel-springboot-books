package com.felipe.learn.springboot.crud.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Column(name = "user_id", nullable = false)
    @Id
    private Integer id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "birthday", nullable = true)
    private Instant birthday;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "phone", nullable = true)
    private Integer phone;


}

