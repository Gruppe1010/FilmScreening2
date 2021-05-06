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
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

// Lavet: 17.2. Programmering (d. 29/4/21)
@ExtendWith(MockitoExtension.class)
class FilmJpaServiceTest {

    @Mock
    FilmRepository filmRepository;

    @Mock
    Film film;

    @InjectMocks
    FilmJpaService filmJpaService;
    
    @Test
    void findByDbID(){
        Film film = new Film();
        given(filmRepository.findById(1)).willReturn(Optional.of(film));
    }

    @Test
    void findByIdBDD() {

        given(filmRepository.findById(1)).
                willReturn(Optional.of(film));

        Film foundFilm = filmJpaService.findById(1);
        assertNotEquals(null, foundFilm);
        verify(filmRepository).findById(1);
    }

    @Test
    void findById() {
        
        Film mockFilm = mock(Film.class);
        // Vi siger til mock-objektet at hvis nogen kommer og spørger dig: findById(1), så returnerer film-obj
        // ? hvad gør of.(film)??
        when(filmRepository.findById(1)).thenReturn(Optional.of(mockFilm));
        Film foundFilm = filmJpaService.findById(1);
        assertNotEquals(null, foundFilm);
        // her tester vi at filmRepository er blevet kaldt med findById(1)
        verify(filmRepository).findById(1);
        

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
        // servicen her er et mockObj - derfor bliver det ikke rigtigt slettet
        filmJpaService.deleteById(4);
        // verify(ting) == vi verifier om 'ting' skete -
        // times(2) == hvor mange gange verify-testen skal køre
        // eller man kan skrive: atLeast(2) - hvis man ikke ved hvor mange gang den skal kaldes, men MINDST 2
        verify(filmRepository, times(2)).deleteById(4);
        filmJpaService.deleteById(3);

        verify(filmRepository, times(2)).deleteById(anyInt());
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
