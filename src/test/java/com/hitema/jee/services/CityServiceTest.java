package com.hitema.jee.services;

import com.hitema.jee.entities.City;
import com.hitema.jee.entities.Country;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CityServiceTest {

    private static final Logger log = LoggerFactory.getLogger(CityServiceTest.class);
    @Autowired
    CityService service;

    @Test
    void create() {
        log.trace("<<<<<<<Create City START>>>>>>>");
        City city = new City();
        city.setCity("Viennes");
        city.setLastUpdate(LocalDateTime.now());
        Country country = new Country();
        country.setId(9l);
        city.setCountry(country);
        service.create(city);
        assertNotNull(city.getId(),"ERROR Insert City ");
        log.info("City CREATED : {}", city);
        log.trace("<<<<<<<Create City END  >>>>>>>");
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void readAll() {
    }

    @Test
    void readAllByName() {
        log.trace("<<<<<<<Read City By Name START>>>>>>>");
        String str = "az";
        var cities = service.readByName(str);
        var cities2 = service.findByName(str);
        assertTrue(cities.size()==cities2.size(),"ERROR les 2 methodes ne sont aps égales !");
        log.trace("Nbre villes trouvées : {}",cities.size());
        cities.forEach(c->log.trace("{}",c));
        log.trace("<<<<<<<Read City By Name END  >>>>>>>");
    }

    @Test
    void readAllCapitals() {
        log.trace("<<<<<<<Read City Capitals START>>>>>>>");
        var capitals = service.readAllCapitals();
        log.trace("Nombre de capitales :{}",capitals.size());
        capitals.forEach(c->log.trace("{}",c));
        log.trace("<<<<<<<Read City Capitals END>>>>>>>");
    }
}