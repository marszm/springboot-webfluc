package com.example.springbootwebfluc.dao;

import com.example.springbootwebfluc.dto.Customer;
import org.springframework.stereotype.Component;

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
        return IntStream.range(1, 50)
                .peek(CustomerDao::sleepExecution)
                .peek(value -> System.out.println("processing count: " + value))
                .mapToObj(value -> new Customer(value, "customer" + value))
                .collect(Collectors.toList());
    }

}
