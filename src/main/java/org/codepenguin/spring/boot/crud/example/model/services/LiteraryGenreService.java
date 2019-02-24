package org.codepenguin.spring.boot.crud.example.model.services;

import java.util.List;
import java.util.Optional;
import org.codepenguin.spring.boot.crud.example.model.entities.LiteraryGenre;
import org.codepenguin.spring.boot.crud.example.model.repositories.LiteraryGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juandiegoespinosasantos@gmail.com
 * @version 02/24/2019
 */
@Service
public class LiteraryGenreService implements CrudService<LiteraryGenre, Long> {

    @Autowired
    private LiteraryGenreRepository repository;

    @Override
    public LiteraryGenre create(LiteraryGenre entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public Optional<LiteraryGenre> find(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<LiteraryGenre> findAll() {
        return repository.findAll();
    }

    @Override
    public LiteraryGenre update(LiteraryGenre entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
