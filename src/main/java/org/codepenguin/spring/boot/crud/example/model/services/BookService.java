package org.codepenguin.spring.boot.crud.example.model.services;

import java.util.List;
import java.util.Optional;
import org.codepenguin.spring.boot.crud.example.model.entities.Book;
import org.codepenguin.spring.boot.crud.example.model.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juandiegoespinosasantos@gmail.com
 * @author Jorge Alfonso Garcia Espinosa
 * @version 02/24/2019
 */
@Service
public class BookService implements CrudService<Book, Long> {

    @Autowired
    private BookRepository repository;

    @Override
    public Book create(Book entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public Optional<Book> find(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book update(Book entity) {
        return repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
