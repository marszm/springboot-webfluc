package com.example.springbootwebfluc.handler;

import com.example.springbootwebfluc.dao.CustomerDao;
import com.example.springbootwebfluc.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

    @Autowired
    private CustomerDao customerDao;

    public Mono<ServerResponse> loadCustomers(ServerRequest serverRequest) {
        Flux<Customer> customerList = customerDao.getCustomerList();
        return ServerResponse.ok().body(customerList, Customer.class);
    }

    public Mono<ServerResponse> findCustomer(ServerRequest serverRequest) {
        int customerId = Integer.parseInt(serverRequest.pathVariable("input"));
        Mono<Customer> customerMono = customerDao.getCustomerList().filter(customer -> customer.getId() == customerId).next();
        return ServerResponse.ok().body(customerMono, Customer.class);
    }

    public Mono<ServerResponse> saveCustomer(ServerRequest serverRequest) {
        Mono<Customer> customerMono = serverRequest.bodyToMono(Customer.class);
        customerMono.map(customer -> customer.getId() + ":" + customer.getName());
        return ServerResponse.ok().body(customerMono, Customer.class);
    }

}
