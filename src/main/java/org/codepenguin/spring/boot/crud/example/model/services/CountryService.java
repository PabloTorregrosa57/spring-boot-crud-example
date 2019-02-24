package org.codepenguin.spring.boot.crud.example.model.services;

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
        return repository.findAll();
    }

}
