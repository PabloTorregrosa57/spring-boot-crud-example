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
public class PublishingHouseController {

    @RequestMapping(method = RequestMethod.GET, value = "/publishing-houses")
    public String list(Model model) {

        model.addAttribute("publishing-houses");

        return "/publishing-houses";
    }
}
