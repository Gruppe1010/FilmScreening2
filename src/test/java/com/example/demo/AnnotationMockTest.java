package com.example.demo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AnnotationMockTest {

    @Mock
    Map<String, Object> mapMock;

    @Test
    void testMock() {
        mapMock.put("Hej", "Viggo");

    }



}
