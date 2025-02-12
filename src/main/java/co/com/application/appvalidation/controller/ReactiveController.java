package co.com.application.appvalidation.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/reactive")
public class ReactiveController {

    @GetMapping("/mono")
    public Mono<String> getMono() {
        return Mono.just("Hello, Mono!")
                .map(String::toUpperCase);
    }

    @GetMapping("/flux")
    public Flux<String> getFlux() {
        return Flux.just("Java", "Spring", "Reactor")
                .delayElements(Duration.ofSeconds(1)); // Simula flujo en tiempo real
    }
}