package br.com.zup.customer.service;

import br.com.zup.customer.domain.Customer;
import br.com.zup.customer.representation.CustomerId;
import br.com.zup.customer.representation.CustomerRepresentation;
import br.com.zup.customer.repository.CustomerRepository;
import br.com.zup.customer.representation.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {


    private CustomerRepository customerRepository;
    private ValidatorService validator;

    @Autowired
    public CustomerServiceImp(CustomerRepository customerRepository, ValidatorService validator) {
        this.customerRepository = customerRepository;
        this.validator = validator;
    }

    @Override
    public CustomerId create(CustomerRepresentation req) {

        Customer c = Customer.save(
                req.getName(),
                req.getCity(),
                customerRepository);

        return new CustomerId(c.getId());
    }

    @Override
    public CustomerId update(CustomerResponse req) {
        Customer c = Customer.update(
                req.getId(),
                req.getName(),
                req.getCity(),
                customerRepository, validator);

        return new CustomerId(c.getId());
    }

}
