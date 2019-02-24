package org.codepenguin.spring.boot.crud.example.controllers;

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
public class LiteraryGenreController {

    @RequestMapping(method = RequestMethod.GET, value = "/literary-genres")
    public String list(Model model) {

        model.addAttribute("literary-genres");

        return "/literary-genres";
    }
}
