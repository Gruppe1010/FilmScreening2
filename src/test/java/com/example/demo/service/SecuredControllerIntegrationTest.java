package com.example.demo.service;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*
* Det som vi tester med denne klasse er vores Spring security - om de forskellige brugerroller kun får tilbudt de
* sider som vi har sagt de skal få
* TODO hent hans projekt som har hele den færdige klasse! 
* */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecuredControllerIntegrationTest {
    
    @Autowired
    // denne her TestRestTemplate er noget vi får foræret
    private TestRestTemplate template;
}
