package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//SpringBootTest
public class SecuredControllerIntegrationTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        ResponseEntity<String> result = template.withBasicAuth("spring", "guru")
                .getForEntity("/api/filmsxx", String.class);

        System.out.println("xxxxxxxxxxx" + result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith201() throws Exception {
        ResponseEntity<String> result = template.withBasicAuth("springx", "gurux")
                .getForEntity("/api/filmsyy", String.class);

        System.out.println("yyyyyyyyyyyy" + result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

}