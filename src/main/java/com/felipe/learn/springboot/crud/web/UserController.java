package com.felipe.learn.springboot.crud.web;

import com.felipe.learn.springboot.crud.domain.entity.UserEntity;
import com.felipe.learn.springboot.crud.domain.vo.HelloVO;

import com.felipe.learn.springboot.crud.domain.vo.UserVO;
import com.felipe.learn.springboot.crud.domain.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.text.MessageFormat;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity<List<UserVO>> listAllUsers() {
        List<UserVO> users = StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(userEntity -> UserVO.builder().id(userEntity.getId()).name(userEntity.getName()).birthday(userEntity.getBirthday()).build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(users);

    }

    @PostMapping(path = "/{userId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserVO> addOrUpdate(
            @PathVariable("userId") Integer userId,
            @RequestBody UserVO userVO
    ) {
        UserEntity user = UserEntity.builder()
                .id(userId)
                .name(userVO.getName())
                .address(userVO.getAddress())
                .birthday(userVO.getBirthday())
                .phone(userVO.getPhone())
                .build();
        userRepository.save(user);
        return ResponseEntity.created(URI.create("/user/" + userId)).body(userVO);

    }

    private Integer getId() {
        Random r = new Random();
        int randomNumber = r.ints(1, 0, 11).findFirst().getAsInt();
        return randomNumber;}}