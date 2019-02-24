package org.codepenguin.spring.boot.crud.example.model.services;

import java.util.LinkedList;
import java.util.List;
import org.codepenguin.spring.boot.crud.example.model.entities.Author;
import org.codepenguin.spring.boot.crud.example.model.entities.Book;
import org.codepenguin.spring.boot.crud.example.model.entities.Country;
import org.codepenguin.spring.boot.crud.example.model.entities.LiteraryGenre;
import org.codepenguin.spring.boot.crud.example.model.entities.PublishingHouse;
import org.codepenguin.spring.boot.crud.example.model.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juandiegoespinosasantos@gmail.com
 * @version 02/24/2019
 */
@Service
public class BookService {
    
    @Autowired
    private BookRepository repository;
    
    public List<Book> findAll() {
    return getMockList();    
    }

    private List<Book> getMockList() {
        LinkedList<Book> books = new LinkedList<>();
        PublishingHouse publishingHouse = PublishingHouse.builder().id(1L).name("Casa Editorial El Tiempo").contactName("Pedro Pérez")
                .phoneNumber("5715550001").country(new Country("CO", "COL", "Colombia")).build();
        LiteraryGenre literaryGenre = new LiteraryGenre(3L, "Ciencia", "Ciencia");
        Author author = Author.builder().id(2L).firstName("Carl").lastName("Sagan")
                .country(new Country("US", "USA", "Estados Unidos")).build();
        books.add(Book.builder().id(1L).isbn("0-345-40946-9").title("The Demon-Haunted World").description("The Demon-Haunted World")
        .stock(1000).price(40000).publishingHouse(publishingHouse).author(author).literaryGenre(literaryGenre).build());
        
        return books;
    }
    
    
}
