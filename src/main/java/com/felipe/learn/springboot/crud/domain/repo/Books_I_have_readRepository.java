package com.felipe.learn.springboot.crud.domain.repo;

import com.felipe.learn.springboot.crud.domain.entity.Books_I_have_ReadEntity;
import org.springframework.data.repository.CrudRepository;

public interface Books_I_have_readRepository extends CrudRepository<Books_I_have_ReadEntity, Integer> {
}