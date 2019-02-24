package org.codepenguin.spring.boot.crud.example.controllers;

import java.util.List;
import org.codepenguin.spring.boot.crud.example.model.entities.LiteraryGenre;
import org.codepenguin.spring.boot.crud.example.model.services.LiteraryGenreService;
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
public class LiteraryGenreController {

    @Value("${crud.example.controllers.literarygenres.title}")
    private String title;

    @Autowired
    private LiteraryGenreService service;

    @GetMapping("literary-genres")
    public String list(Model model) {
        List<LiteraryGenre> genres = service.findAll();
        
        model.addAttribute("title", title);
        model.addAttribute("genres", genres);

        return "literary-genres";
    }
}
