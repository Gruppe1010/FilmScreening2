package com.example.demo.service;

import com.example.demo.model.Film;
import com.example.demo.repository.FilmRepository;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FilmJpaServiceTest {

    @Mock
    FilmRepository filmRepository;

    @Mock
    Film film;

    @InjectMocks
    FilmJpaService filmJpaService;



    @Test
    void findById() {

        when(filmRepository.findById(1)).
                thenReturn(Optional.of(film));
        Film foundFilm = filmJpaService.findById(1);
        assertNotEquals(null, foundFilm);
        verify(filmRepository).findById(1);

    }

    @Test
    void delete() {

        filmJpaService.delete(film);
        verify(filmRepository).delete(any(Film.class));

    }

    @Test
    void deleteById() {
        filmJpaService.deleteById(2);
        filmJpaService.deleteById(2);

        verify(filmRepository, times(2)).deleteById(2);
    }

    @Test
    void deleteByIdAtLeast() {
        filmJpaService.deleteById(2);
        filmJpaService.deleteById(2);
        filmJpaService.deleteById(2);
        filmJpaService.deleteById(2);
        filmJpaService.deleteById(2);

        verify(filmRepository, atLeast(2)).deleteById(2);
        verify(filmRepository, atMost(6)).deleteById(2);
        verify(filmRepository, never()).deleteById(7);


    }
}
