package org.codepenguin.spring.boot.crud.example.model.services;

import java.util.List;
import java.util.Optional;
import org.codepenguin.spring.boot.crud.example.model.entities.Author;
import org.codepenguin.spring.boot.crud.example.model.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juandiegoespinosasantos@gmail.com
 * @author Jorge Alfonso Garcia Espinosa
 * @since 1.8
 * @version 02/24/2019
 */
@Service
public class AuthorService implements CrudService<Author, Long> {

    @Autowired
    private AuthorRepository repository;

    @Override
    public Author create(Author entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<Author> find(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return repository.findAll();
    }

    @Override
    public Author update(Author entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
