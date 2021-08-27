package com.felipe.learn.springboot.crud.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Cleanup;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    @Id
    private Integer id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "birthday", nullable = false)
    private Instant birthday;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private Integer phone;


}

