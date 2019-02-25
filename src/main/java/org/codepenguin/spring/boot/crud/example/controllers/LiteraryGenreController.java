/*
 * MIT License
 * 
 * Copyright (c) 2019 Codepenguin.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.codepenguin.spring.boot.crud.example.controllers;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author juandiegoespinosasantos@gmail.com
 * @version 02/24/2019
 */
@Controller
@RequestMapping("/literary-genres")
public class LiteraryGenreController implements CrudController<LiteraryGenre, Long> {

    @Value("${crud.example.controllers.literarygenres.title}")
    private String title;

    @Autowired
    private LiteraryGenreService service;

    @Override
    @GetMapping
    public String displayEntityList(Model model) {
        final List<LiteraryGenre> genres = service.findAll();

        model.addAttribute("title", title);
        model.addAttribute("genres", genres);

        return "literary-genres/literary-genres";
    }

    @Override
    @GetMapping("/create")
    public String displayCreateForm(Model model) {
        model.addAttribute("title", "Create Literary Genre");
        model.addAttribute("action", "create");
        model.addAttribute("literaryGenre", new LiteraryGenre());

        return "literary-genres/literary-genres-form";
    }

    @Override
    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") Long id, Model model, RedirectAttributes flash) {
        final Optional<LiteraryGenre> genreOpt = service.find(id);

        if (!genreOpt.isPresent()) {
            flash.addFlashAttribute("error", "Literary genre " + id + " not found!");

            return "redirect:/literary-genres";
        }

        model.addAttribute("title", "Create Literary Genre");
        model.addAttribute("action", "update");
        model.addAttribute("literaryGenre", genreOpt.get());

        return "literary-genres/literary-genres-form";
    }

    @Override
    @PostMapping("/create")
    public String processCreate(@Valid LiteraryGenre entity, BindingResult result, Model model, RedirectAttributes flash) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Create Literary Genre");
            model.addAttribute("action", "create");

            return "literary-genres/literary-genres-form";
        }

        service.create(entity);

        flash.addFlashAttribute("success", "Literary Genre [" + entity.getId() + "] " + entity.getName()
                + " has been created successfully!");

        return "redirect:/literary-genres";
    }

    @Override
    @PostMapping("/update")
    public String processUpdate(@Valid LiteraryGenre entity, BindingResult result, Model model, RedirectAttributes flash) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Literary Genre Form");
            model.addAttribute("action", "update");

            return "literary-genres/literary-genres-form";
        }

        service.update(entity);

        flash.addFlashAttribute("success", "Literary Genre [" + entity.getId() + "] " + entity.getName()
                + " has been updated successfully!");

        return "redirect:/literary-genres";
    }

    @Override
    @GetMapping("/delete/{id}")
    public String processDelete(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
        final Optional<LiteraryGenre> genreOpt = service.find(id);

        if (!genreOpt.isPresent()) {
            flash.addFlashAttribute("error", "Literary genre " + id + " not found!");

            return "redirect:/literary-genres";
        }

        final LiteraryGenre genre = genreOpt.get();

        service.delete(genre.getId());

        flash.addFlashAttribute("success", "Literary genre [" + genre.getId() + "] " + genre.getName() + " has been deleted.");

        return "redirect:/literary-genres";
    }
}
