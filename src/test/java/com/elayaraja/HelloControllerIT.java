package com.elayaraja;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setUp() throws Exception{
        this.base = new URL("http://localhost:" + port + "/doctors/hello");
    }

    @Test
    public void getHello() throws Exception{
        ResponseEntity<String> response = restTemplate.getForEntity(base.toString(),String.class);
        Assertions.assertThat(response.getBody()).isEqualTo("Greeting from Spring Boot!");
    }
}
