package com.example.springbootwebfluc;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<String> monoString = Mono.just("any data type"); //publisher
        monoString.subscribe(System.out::println); //subscriber

    }

}
