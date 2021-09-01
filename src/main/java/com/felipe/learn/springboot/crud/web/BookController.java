package com.felipe.learn.springboot.crud.web;

import com.felipe.learn.springboot.crud.domain.entity.BookEntity;
import com.felipe.learn.springboot.crud.domain.vo.HiVO;

import com.felipe.learn.springboot.crud.domain.vo.BookVO;
import com.felipe.learn.springboot.crud.domain.repo.BookRepository;
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
@RequestMapping(path = "/book")
@AllArgsConstructor
public class BookController {

    private final BookRepository bookRepository;


    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity<List<BookVO>> listAllBooks() {
        List<BookVO> books = StreamSupport.stream(bookRepository.findAll().spliterator(), false)
                .map(bookEntity -> BookVO.builder().id(bookEntity.getId()).title(bookEntity.getTitle()).subtitle(bookEntity.getSubtitle())
                        .series(bookEntity.getSeries()).price(bookEntity.getPrice()).pages(bookEntity.getPages())
                        .author(bookEntity.getAuthor()).description(bookEntity.getDescription()).build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(books);
    }
    @PostMapping(path = "/{bookId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BookVO> addOrUpdate(
            @PathVariable("bookId") Integer bookId,
            @RequestBody BookVO bookVO
    ) {
            BookEntity book = BookEntity.builder()
                    .id(bookId)
                    .title(bookVO.getTitle())
                    .subtitle(bookVO.getSubtitle())
                    .series(bookVO.getSeries())
                    .price(bookVO.getPrice())
                    .pages(bookVO.getPages())
                    .author(bookVO.getAuthor())
                    .description(bookVO.getDescription())
                    .build();
            bookRepository.save(book);

            return ResponseEntity.created(URI.create("/books/" + bookId)).body(bookVO);




    }

    private Integer getId() {
        Random r = new Random();
        int randomNumber = r.ints(1, 0, 11).findFirst().getAsInt();
        return randomNumber;
    }
}

