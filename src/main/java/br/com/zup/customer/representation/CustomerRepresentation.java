package br.com.zup.customer.representation;

import br.com.zup.customer.domain.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRepresentation {

    private String name;
    private City city;
}
