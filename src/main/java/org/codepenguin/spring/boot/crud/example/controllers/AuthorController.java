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
import org.codepenguin.spring.boot.crud.example.model.entities.Author;
import org.codepenguin.spring.boot.crud.example.model.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author juandiegoespinosasantos@gmail.com
 * @version 02/24/2019
 */
@Controller
public class AuthorController implements CrudController<Author, Long> {

    @Autowired
    private AuthorService service;

    @Value("${crud.example.controllers.authors.title}")
    private String title;

    @Override
    @GetMapping
    public String displayEntityList(Model model) {
        final List<Author> authors = service.findAll();

        model.addAttribute("title", title);
        model.addAttribute("authors", authors);

        return "authors/authors";
    }

    @Override
    public String displayCreateForm(Model model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String displayUpdateForm(Long id, Model model, RedirectAttributes flash) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String processCreate(Author entity, BindingResult result, Model model, RedirectAttributes flash) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String processUpdate(Author entity, BindingResult result, Model model, RedirectAttributes flash) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String processDelete(Long id, RedirectAttributes flash) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
