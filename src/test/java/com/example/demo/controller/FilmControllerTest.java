package com.example.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FilmControllerTest {

    @Autowired
    FilmController controller;
    Model model;

    @BeforeEach
    void setUp() {
        //controller = new FilmController();
        model = new BindingAwareModelMap();
    }

    @Test
    void getIndex() {
        assertEquals("index", controller.getIndex(model));
    }
}