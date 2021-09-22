package com.felipe.learn.springboot.crud.web;

import com.felipe.learn.springboot.crud.domain.entity.Books_I_have_ReadEntity;
import com.felipe.learn.springboot.crud.domain.repo.Books_I_have_readRepository;
import com.felipe.learn.springboot.crud.domain.vo.Books_I_have_readVO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
