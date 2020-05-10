package es.jorgegueyer.app.web;

import es.jorgegueyer.app.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/main")
    public Mono<ResponseEntity<String>> main() {
        return this.mainService.mainService().map(ResponseEntity::ok);
    }
}
