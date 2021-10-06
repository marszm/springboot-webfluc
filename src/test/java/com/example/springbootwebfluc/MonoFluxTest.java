package com.example.springbootwebfluc;

import reactor.core.publisher.Mono;

public class MonoFluxTest {

    public void testMono() {
        Mono<String> monoString = Mono.just("any data type");

    }

}
