package br.com.zup.customer.controller;

import br.com.zup.customer.domain.Customer;
import br.com.zup.customer.representation.CustomerId;
import br.com.zup.customer.representation.CustomerRepresentation;
import br.com.zup.customer.representation.CustomerResponse;
import br.com.zup.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    /*{"name":"Jackson","city":{"id":5}}*/

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/customers/post")
    @ResponseStatus(HttpStatus.OK)
    CustomerId create(@RequestBody CustomerRepresentation req) {
        return customerService.create(req);
    }

    @PutMapping(path = "/customers/put")
    @ResponseStatus(HttpStatus.ACCEPTED)
    CustomerId update(@RequestBody CustomerResponse req) {
        return customerService.update(req);
    }
}
