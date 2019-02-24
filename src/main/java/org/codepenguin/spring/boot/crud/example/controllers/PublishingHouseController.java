package org.codepenguin.spring.boot.crud.example.controllers;

import java.util.List;
import org.codepenguin.spring.boot.crud.example.model.entities.PublishingHouse;
import org.codepenguin.spring.boot.crud.example.model.services.PublishingHouseService;
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
public class PublishingHouseController {

    @Value("${application.controllers.publishinghouses.title}")
    private String title;

    @Autowired
    private PublishingHouseService service;

    @GetMapping("/publishing-houses")
    public String list(Model model) {
        final List<PublishingHouse> list = service.findAll();

        model.addAttribute("title", title);
        model.addAttribute("list", list);

        return "publishing-houses";
    }
}
