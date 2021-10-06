package com.example.springbootwebfluc;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

class MonoFluxTest {

    @Test
    void testMono() {
        Mono<?> monoString = Mono.just("any data type")
                .then(Mono.error(new RuntimeException("exception occured")))
                .log(); //publisher
        monoString.subscribe(System.out::println, throwable -> System.out.println(throwable.getMessage())); //subscriber

    }

}
