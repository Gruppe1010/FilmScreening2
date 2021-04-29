package com.example.demo.service;

import com.example.demo.repository.FilmRepository;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FilmJpaServiceTest {

    @Mock
    FilmRepository filmRepository;

    @InjectMocks
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