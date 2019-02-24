package org.codepenguin.spring.boot.crud.example.controllers;

import java.util.List;
import org.codepenguin.spring.boot.crud.example.model.entities.Author;
import org.codepenguin.spring.boot.crud.example.model.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author juandiegoespinosasantos@gmail.com
 * @version 02/24/2019
 */
@Controller
public class AuthorController {

    @Autowired
    private AuthorService service;

    @Value("${crud.example.controllers.authors.title}")
    private String title;

    @RequestMapping(method = RequestMethod.GET, value = "/authors")
    public String list(Model model) {
        final List<Author> authors = service.findAll();

        model.addAttribute("title", title);
        model.addAttribute("authors", authors);

        return "/authors";
    }
}
