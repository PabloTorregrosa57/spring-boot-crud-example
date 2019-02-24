package org.codepenguin.spring.boot.crud.example.model.services;

import java.util.LinkedList;
import java.util.List;
import org.codepenguin.spring.boot.crud.example.model.entities.Country;
import org.codepenguin.spring.boot.crud.example.model.entities.PublishingHouse;
import org.codepenguin.spring.boot.crud.example.model.repositories.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juandiegoespinosasantos@gmail.com
 * @version 02/24/2019
 */
@Service
public class PublishingHouseService {

    @Autowired
    private PublishingHouseRepository repository;

    public List<PublishingHouse> findAll() {
        return getMockList();
    }

    private List<PublishingHouse> getMockList() {
        List<PublishingHouse> list = new LinkedList<>();
        list.add(PublishingHouse.builder().id(1L).name("Casa Editorial El Tiempo").contactName("Pedro Pérez")
                .phoneNumber("5715550001").country(new Country("CO", "COL", "Colombia")).build());
        list.add(PublishingHouse.builder().id(2L).name("McGraw-Hill").contactName("James Hill")
                .phoneNumber("115550002").country(new Country("US", "USA", "Estados Unidos")).build());
        list.add(PublishingHouse.builder().id(3L).name("Penguin Books").contactName("John Lane")
                .phoneNumber("215550003").country(new Country("UK", "UKI", "Reino Unido")).build());

        return list;
    }
}
