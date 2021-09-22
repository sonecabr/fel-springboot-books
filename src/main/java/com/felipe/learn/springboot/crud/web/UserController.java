package com.felipe.learn.springboot.crud.web;

import com.felipe.learn.springboot.crud.domain.entity.UserEntity;
import com.felipe.learn.springboot.crud.domain.repo.UserRepository;
import com.felipe.learn.springboot.crud.domain.vo.UserVO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
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

    @GetMapping(path = "/{userId}", produces = "application/json")
    public ResponseEntity<UserVO> getUser(@PathVariable("userId") Integer userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if(userEntity.isPresent()){
            UserVO userVO = UserVO.builder()
                    .id(userEntity.get().getId())
                    .name(userEntity .get().getName())
                    .phone(userEntity.get().getPhone())
                    .build();
            return ResponseEntity.ok(userVO);
        } else {
            return ResponseEntity.notFound().build();
        }
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


   @DeleteMapping (path= "/{userId}", consumes= "application/json", produces = "application/json")
    public ResponseEntity delete(@PathVariable("userId") Integer userId){

        userRepository.deleteById(userId);
        return ResponseEntity.noContent().build();
    }



    private Integer getId() {
        Random r = new Random();
        int randomNumber = r.ints(1, 0, 11).findFirst().getAsInt();
        return randomNumber;}}