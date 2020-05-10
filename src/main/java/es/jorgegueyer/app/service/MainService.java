package es.jorgegueyer.app.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MainService {

    public Mono<String> mainService() {
        return Mono.just("The main service has been called!");
    }
}
