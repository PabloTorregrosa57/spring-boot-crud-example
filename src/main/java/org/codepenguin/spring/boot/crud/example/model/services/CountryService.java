package org.codepenguin.spring.boot.crud.example.model.services;

import java.util.List;
import java.util.Optional;
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
public class CountryService implements CrudService<Country, String> {

    @Autowired
    private CountryRepository repository;

    @Override
    public Country create(Country entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public Optional<Country> find(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Country> findAll() {
        return repository.findAll();
    }

    @Override
    public Country update(Country entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

}
