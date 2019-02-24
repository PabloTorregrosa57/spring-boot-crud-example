package org.codepenguin.spring.boot.crud.example.model.services;

import java.util.List;
import java.util.Optional;
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
public class PublishingHouseService implements CrudService<PublishingHouse, Long> {

    @Autowired
    private PublishingHouseRepository repository;

    @Override
    public PublishingHouse create(PublishingHouse entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public Optional<PublishingHouse> find(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<PublishingHouse> findAll() {
        return repository.findAll();
    }

    @Override
    public PublishingHouse update(PublishingHouse entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
