package org.codepenguin.spring.boot.crud.example.controllers;

import java.util.List;
import org.codepenguin.spring.boot.crud.example.model.entities.Country;
import org.codepenguin.spring.boot.crud.example.model.services.CountryService;
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
public class CountryController {

    @Value("${application.controllers.countries.title}")
    private String title;

    @Autowired
    private CountryService service;

    @GetMapping("/countries")
    public String list(Model model) {
        final List<Country> countries = service.findAll();

        model.addAttribute("title", this.title);
        model.addAttribute("countries", countries);

        return "/countries";
    }
}
