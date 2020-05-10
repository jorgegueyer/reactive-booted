package es.jorgegueyer.app.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@ContextConfiguration(classes = MainService.class)
@ExtendWith(SpringExtension.class)
public class MainServiceTest {

    @Autowired
    private MainService mainService;

    @Test
    public void mainServiceTest() {
        StepVerifier.create(mainService.mainService())
                    .expectNext("The main service has been called!")
                    .verifyComplete();
    }
}
