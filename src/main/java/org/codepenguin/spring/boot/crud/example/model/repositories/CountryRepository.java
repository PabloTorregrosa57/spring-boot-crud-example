package org.codepenguin.spring.boot.crud.example.model.repositories;

import org.codepenguin.spring.boot.crud.example.model.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author juandiegoespinosasantos@gmail.com
 * @version 02/24/2019
 */
public interface CountryRepository extends JpaRepository<Country, String>{
    
}
