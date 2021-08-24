package com.felipe.learn.springboot.crud.web;

import com.felipe.learn.springboot.crud.domain.vo.HelloVO;

import com.felipe.learn.springboot.crud.domain.vo.UserVO;
import com.felipe.learn.springboot.crud.domain.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/test")
@AllArgsConstructor
public class TestController {

    private final UserRepository userRepository;

    @GetMapping(path = "/hello/{name}", produces = "application/json")
    public ResponseEntity<HelloVO> hello(@PathVariable("name") String name) {
        return ResponseEntity.ok(HelloVO.builder()
                .id(getId())
                .name(name)
                .build());
    }

    @GetMapping(path = "/hello/users", produces = "application/json")
    public ResponseEntity<List<UserVO>> listAllUsers() {
        List<UserVO> users = StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(userEntity -> UserVO.builder().id(userEntity.getId()).name(userEntity.getName()).build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(users);

    }

    private Integer getId() {
        Random r = new Random();
        int randomNumber = r.ints(1, 0, 11).findFirst().getAsInt();
        return randomNumber;
    }
}
