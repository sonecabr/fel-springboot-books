package com.felipe.learn.springboot.crud.domain.repo;

import com.felipe.learn.springboot.crud.domain.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Integer> {
}
