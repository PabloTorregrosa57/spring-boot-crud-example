package org.codepenguin.spring.boot.crud.example.model.services;

import java.util.LinkedList;
import java.util.List;
import org.codepenguin.spring.boot.crud.example.model.entities.LiteraryGenre;
import org.codepenguin.spring.boot.crud.example.model.repositories.LiteraryGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juandiegoespinosasantos@gmail.com
 * @version 02/24/2019
 */
@Service
public class LiteraryGenreService {
    
    @Autowired
    private LiteraryGenreRepository repository;
    
    public List<LiteraryGenre> findAll() {
        return getMockList();
    }

    private List<LiteraryGenre> getMockList() {
      List<LiteraryGenre> genres = new LinkedList<>();
      genres.add(new LiteraryGenre(1L, "Misterio", "Misterio"));
      genres.add(new LiteraryGenre(2L, "Novela", "Novela"));
      genres.add(new LiteraryGenre(3L, "Ciencia", "Ciencia"));
      
      return genres;
    }
}
