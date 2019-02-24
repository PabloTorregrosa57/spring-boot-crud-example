package org.codepenguin.spring.boot.crud.example.controllers;

import java.util.List;
import org.codepenguin.spring.boot.crud.example.model.entities.Country;
import org.codepenguin.spring.boot.crud.example.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juandiegoespinosasantos@gmail.com
 * @version 02/24/2019
 */
@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    @ResponseBody
    public ResponseEntity<?> list() {
        List<Country> countries = countryService.findAll();
        
        return ResponseEntity.ok(countries);
    }
}
