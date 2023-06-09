package com.hitema.jee.repositories;

import com.hitema.jee.entities.City;
import com.hitema.jee.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByCityContainingIgnoreCase(String str);
   List<City> readCitiesByCityContainingIgnoreCase(String str);

   List<City> readCitiesByCapitalIsTrue();


}
