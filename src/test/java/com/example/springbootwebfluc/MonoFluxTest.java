package com.example.springbootwebfluc;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

class MonoFluxTest {

    @Test
    void testMono() {
        Mono<String> monoString = Mono.just("any data type").log(); //publisher
        monoString.subscribe(System.out::println); //subscriber

    }

}
