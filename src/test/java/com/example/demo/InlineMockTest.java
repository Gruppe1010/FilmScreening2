package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InlineMockTest {

    @Test
    void testInlineMock() {
        Map mapMock = mock(Map.class);
        //mapMock.put("Hej", "Viggo");

        when(mapMock.get("Hej")).thenReturn("Viggo");
        assertEquals(0, mapMock.size());
        assertEquals("Viggo", mapMock.get("Hej"));

    }
}
