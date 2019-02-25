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

import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Jorge Alfonso García Espinosa
 * @param <T>
 * @param <ID>
 * @since 1.8
 * @version 02/24/2019
 */
public interface CrudController<T, ID> {

    String displayEntityList(Model model);

    String displayCreateForm(Model model);

    String displayUpdateForm(ID id, Model model, RedirectAttributes flash);

    String processCreate(@Valid T entity, BindingResult result, Model model, RedirectAttributes flash);

    String processUpdate(@Valid T entity, BindingResult result, Model model, RedirectAttributes flash);

    String processDelete(ID id, RedirectAttributes flash);
}
