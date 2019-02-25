package org.codepenguin.spring.boot.crud.example.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.codepenguin.spring.boot.crud.example.model.entities.LiteraryGenre;
import org.codepenguin.spring.boot.crud.example.model.services.LiteraryGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/literary-genres")
    public String list(Model model) {
        List<LiteraryGenre> genres = service.findAll();

        model.addAttribute("title", title);
        model.addAttribute("genres", genres);

        return "literary-genres";
    }

    @GetMapping("/literary-genres/create")
    public String create(Map<String, Object> model) {
        model.put("title", "Create Literary Genre");
        model.put("action", "create");
        model.put("literaryGenre", new LiteraryGenre());

        return "/literary-genres-form";
    }

    @PostMapping("/literary-genres/create")
    public String create(@Valid LiteraryGenre genre, BindingResult result, Map<String, Object> model, RedirectAttributes flash) {
        if (result.hasErrors()) {
            model.put("title", "Create Literary Genre");
            model.put("action", "create");

            return "/literary-genres-form";
        }

        service.create(genre);

        flash.addFlashAttribute("success", "Literary Genre [" + genre.getId() + "] " + genre.getName()
                + " has been created successfully!");

        return "redirect:/literary-genres";
    }

    @GetMapping("/literary-genres/update/{id}")
    public String edit(@PathVariable("id") Long id, Map<String, Object> model, RedirectAttributes flash) {
        Optional<LiteraryGenre> genreOpt = service.find(id);

        if (!genreOpt.isPresent()) {
            flash.addFlashAttribute("error", "Literary genre " + id + " not found!");

            return "redirect:/literary-genres";
        }

        model.put("title", "Create Literary Genre");
        model.put("action", "update");
        model.put("literaryGenre", genreOpt.get());

        return "/literary-genres-form";
    }

    @PostMapping("/literary-genres/update")
    public String edit(@Valid LiteraryGenre genre, BindingResult result, Map<String, Object> model, RedirectAttributes flash) {
        if (result.hasErrors()) {
            model.put("title", "Literary Genre Form");
            model.put("action", "update");

            return "/literary-genres-form";
        }

        service.update(genre);

        flash.addFlashAttribute("success", "Literary Genre [" + genre.getId() + "] " + genre.getName()
                + " has been updated successfully!");

        return "redirect:/literary-genres";
    }

    @GetMapping("literary-genres/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
        if (id > 0) {
            Optional<LiteraryGenre> genreOpt = service.find(id);

            if (genreOpt.isPresent()) {
                LiteraryGenre genre = genreOpt.get();

                service.delete(genre.getId());

                flash.addFlashAttribute("success", "Literary genre [" + id + "] " + genre.getName() + " has been deleted.");
            }
        }

        return "redirect:/literary-genres";
    }
}
