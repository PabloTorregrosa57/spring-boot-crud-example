package org.codepenguin.spring.boot.crud.example.model.services;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jorge Alfonso García Espinosa
 * @param <T>
 * @param <ID>
 * @since 1.8
 * @version 02/24/2019
 */
public interface CrudService<T, ID> {

    T create(T entity);

    Optional<T> find(ID id);

    List<T> findAll();

    T update(T entity);

    void delete(ID id);
}
