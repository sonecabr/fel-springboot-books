package com.felipe.learn.springboot.crud.web;

import com.felipe.learn.springboot.crud.domain.repo.BookRepository;
import com.felipe.learn.springboot.crud.domain.vo.BookVO;
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
@RequestMapping(path = "/book")
@AllArgsConstructor
public class BookController {

    private final BookRepository bookRepository;


    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity<List<BookVO>> list() {
        List<BookVO> books = StreamSupport.stream(bookRepository.findAll().spliterator(), false)
                .map(bookEntity -> BookVO.builder().id(bookEntity.getId()).title(bookEntity.getTitle()).build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(books);

    }

    private Integer getId() {
        Random r = new Random();
        int randomNumber = r.ints(1, 0, 11).findFirst().getAsInt();
        return randomNumber;
    }
}

