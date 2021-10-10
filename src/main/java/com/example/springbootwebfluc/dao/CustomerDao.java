package com.example.springbootwebfluc.dao;

import com.example.springbootwebfluc.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void sleepExecution(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getCustomers() {
        return IntStream.range(1, 10)
                .peek(CustomerDao::sleepExecution)
                .peek(value -> System.out.println("processing count: " + value))
                .mapToObj(value -> new Customer(value, "customer" + value))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersStream() {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("procerssing count: " + i))
                .map(i -> new Customer(i, "Customer"+ i));
    }

}
