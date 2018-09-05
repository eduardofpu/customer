package br.com.zup.customer.service;

import br.com.zup.customer.representation.CustomerId;
import br.com.zup.customer.representation.CustomerRepresentation;
import br.com.zup.customer.representation.CustomerResponse;

public interface CustomerService {
    CustomerId create(CustomerRepresentation req);
    CustomerId update(CustomerResponse req);
}
