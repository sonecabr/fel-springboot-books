package com.felipe.learn.springboot.crud.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;


class TestControllerTest {

    @BeforeEach
    void setUp() {
        System.out.println("preparing test context...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("closing test contexts...");
    }
}