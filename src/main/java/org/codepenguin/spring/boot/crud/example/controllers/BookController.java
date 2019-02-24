package org.codepenguin.spring.boot.crud.example.controllers;

import java.util.List;
import org.codepenguin.spring.boot.crud.example.model.entities.Book;
import org.codepenguin.spring.boot.crud.example.model.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author juandiegoespinosasantos@gmail.com
 * @version 02/24/2019
 */
@Controller
public class BookController {

    @Value("${application.controllers.books.title}")
    private String title;

    @Autowired
    private BookService service;

    @GetMapping("/books")
    public String list(Model model) {
        final List<Book> books = service.findAll();

        model.addAttribute("title", title);
        model.addAttribute("books", books);

        return "/books";
    }
}
