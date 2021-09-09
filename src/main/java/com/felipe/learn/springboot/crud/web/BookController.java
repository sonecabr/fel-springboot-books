package com.felipe.learn.springboot.crud.web;

import com.felipe.learn.springboot.crud.domain.entity.BookEntity;
import com.felipe.learn.springboot.crud.domain.entity.UserEntity;
import com.felipe.learn.springboot.crud.domain.repo.BookRepository;
import com.felipe.learn.springboot.crud.domain.vo.BookVO;
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
        return ResponseEntity.created(URI.create("/book/" + bookId)).body(bookVO);
    }

    @DeleteMapping(path = "/{bookId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity delete(@PathVariable("bookId") Integer bookId) {

        bookRepository.deleteById(bookId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{bookId}", produces = "application/json")
    public ResponseEntity<BookVO> getBook(@PathVariable("bookId") Integer bookId) {
        Optional<BookEntity> bookEntity = bookRepository.findById(bookId);
        if (bookEntity.isPresent()) {
            BookVO bookVO = BookVO.builder()
                    .id(bookEntity.get().getId())
                    .title(bookEntity.get().getTitle())
                    .subtitle(bookEntity.get().getSubtitle())
                    .series(bookEntity.get().getSeries())
                    .price(bookEntity.get().getPrice())
                    .pages(bookEntity.get().getPages())
                    .author(bookEntity.get().getAuthor())
                    .description(bookEntity.get().getDescription())
                    .build();

            return ResponseEntity.ok(bookVO);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private Integer getId() {
        Random r = new Random();
        int randomNumber = r.ints(1, 0, 11).findFirst().getAsInt();
        return randomNumber;
    }
}

