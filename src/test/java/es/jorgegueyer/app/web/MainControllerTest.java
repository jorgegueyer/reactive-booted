package es.jorgegueyer.app.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
public class MainControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void mainTest() {
        this.webTestClient.get()
                .uri("/main")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(String.class).isEqualTo("The main service has been called!");

    }

}
