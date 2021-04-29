package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FilmJpaServiceTestNoMock {

    @Autowired
    FilmJpaService filmJpaService;

    @Test
    void findById() {

    }

    @Test
    void delete() {

    }

    @Test
    void deleteById() {
        filmJpaService.deleteById(2);
    }
}