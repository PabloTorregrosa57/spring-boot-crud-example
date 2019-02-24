package org.codepenguin.spring.boot.crud.example.model.services;

import java.util.LinkedList;
import java.util.List;
import org.codepenguin.spring.boot.crud.example.model.entities.Author;
import org.codepenguin.spring.boot.crud.example.model.entities.Country;
import org.codepenguin.spring.boot.crud.example.model.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juandiegoespinosasantos@gmail.com
 * @version 02/24/2019
 */
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public List<Author> findAll() {
        return getMockList();
    }

    private List<Author> getMockList() {
        List<Author> authors = new LinkedList<>();
        authors.add(Author.builder().id(1L).firstName("Gabriel").lastName("García Márquez")
                .country(new Country("CO", "COL", "Colombia")).build());
        authors.add(Author.builder().id(2L).firstName("Carl").lastName("Sagan")
                .country(new Country("US", "USA", "Estados Unidos")).build());
        authors.add(Author.builder().id(3L).firstName("Arthur Conan").lastName("Dolye")
                .country(new Country("UK", "UKI", "Reino Unido")).build());

        return authors;
    }
}
