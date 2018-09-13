package br.com.zup.customer.repository;

import br.com.zup.customer.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cities", path = "cities")
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByNameIgnoreCaseContaining(@Param("name") String name);
    List<City> findAllByOrderByNameAsc();
}