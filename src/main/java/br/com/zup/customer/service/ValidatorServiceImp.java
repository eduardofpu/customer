package br.com.zup.customer.service;

import br.com.zup.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ValidatorServiceImp implements ValidatorService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void verifyIfUserExists(Long id) {

        if (customerRepository.findOne(id) == null) {
            Assert.notNull("User not found for ID: " + id);
        }

    }
}
