package com.example.demo.service;


import com.example.demo.model.Film;
import com.example.demo.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FilmJpaService implements FilmService {

    @Autowired
    FilmRepository filmRepository;


    @Override
    public Set<Film> findAll() {
        return null;
    }

    @Override
    public Film findById(Integer id) {
        return filmRepository.findById(id).orElse(null);
    }

    @Override
    public Film save(Film object) {
        return null;
    }

    @Override
    public void delete(Film object) {
        filmRepository.delete(object);

    }

    @Override
    public void deleteById(Integer id) {
        filmRepository.deleteById(id);
    }
}
