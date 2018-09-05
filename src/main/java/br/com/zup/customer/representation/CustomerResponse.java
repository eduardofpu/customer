package br.com.zup.customer.representation;

import br.com.zup.customer.domain.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private Long id;
    private String name;
    private City city;
}
