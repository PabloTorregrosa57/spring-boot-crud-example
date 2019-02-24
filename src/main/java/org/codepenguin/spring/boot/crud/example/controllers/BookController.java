package org.codepenguin.spring.boot.crud.example.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author juandiegoespinosasantos@gmail.com
 * @version 02/24/2019
 */
public class BookController {

    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public String list(Model model) {

        model.addAttribute("books");

        return "/books";
    }
}
