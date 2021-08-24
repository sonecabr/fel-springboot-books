package com.felipe.learn.springboot.crud.domain.repo;

import com.felipe.learn.springboot.crud.domain.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
