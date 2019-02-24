package org.codepenguin.spring.boot.crud.example.service;

import java.util.LinkedList;
import java.util.List;
import org.codepenguin.spring.boot.crud.example.model.dao.CountryRepository;
import org.codepenguin.spring.boot.crud.example.model.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juandiegoespinosasantos@gmail.com
 * @version 02/24/2019
 */
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepo;

    public List<Country> findAll() {
//        return countryRepo.findAll();

        return getMockList();
    }

    private List<Country> getMockList() {
        List<Country> countries = new LinkedList<>();
        countries.add(Country.builder().code("CO").alpha3("COL").name("Colombia").build());
        countries.add(Country.builder().code("EU").alpha3("EUA").name("Estados Unidos").build());
        countries.add(Country.builder().code("MX").alpha3("MEX").name("México").build());
        countries.add(Country.builder().code("AR").alpha3("ARG").name("Argentina").build());
        countries.add(Country.builder().code("VE").alpha3("VEN").name("Venezuela").build());

        return countries;
    }

}
