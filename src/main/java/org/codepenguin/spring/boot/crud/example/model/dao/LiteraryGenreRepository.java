package org.codepenguin.spring.boot.crud.example.model.dao;

import org.codepenguin.spring.boot.crud.example.model.entities.LiteraryGenre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author juandiegoespinosasantos@gmail.com
 * @version 02/24/2019
 */
public interface LiteraryGenreRepository extends JpaRepository<LiteraryGenre, Long>{
    
}
