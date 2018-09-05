package br.com.zup.customer.domain;

import br.com.zup.customer.repository.CustomerRepository;
import br.com.zup.customer.service.ValidatorService;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@JsonSerialize
@JsonDeserialize
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name="city")
    private City city;

    public Customer(Long id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Customer(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public static Customer save(String name, City city, CustomerRepository customerRepository){

       Customer customer = new Customer(name, city);
        Customer save = customerRepository.save(customer);
        return save;
    }

    public static Customer update(Long id, String name, City city, CustomerRepository customerRepository, ValidatorService validator){

       validator.verifyIfUserExists(id);

        Customer customer = new Customer(id, name, city);
        Customer save = customerRepository.save(customer);
        return save;
    }
}
