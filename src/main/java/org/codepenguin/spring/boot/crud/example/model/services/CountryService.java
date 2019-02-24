package org.codepenguin.spring.boot.crud.example.model.services;

import java.util.LinkedList;
import java.util.List;
import org.codepenguin.spring.boot.crud.example.model.repositories.CountryRepository;
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
    private CountryRepository repository;

    public List<Country> findAll() {
//        return countryRepo.findAll();

        return getMockList();
    }

    private List<Country> getMockList() {
        List<Country> countries = new LinkedList<>();
        countries.add(new Country("CO", "COL", "Colombia"));
        countries.add(new Country("EU", "EUA", "Estados Unidos"));
        countries.add(new Country("MX", "MEX", "México"));
        countries.add(new Country("AR", "ARG", "Argentina"));
        countries.add(new Country("VE", "VEN", "Venezuela"));
        return countries;
    }

}
