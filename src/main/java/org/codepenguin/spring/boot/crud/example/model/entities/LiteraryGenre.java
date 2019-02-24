package org.codepenguin.spring.boot.crud.example.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Jorge Alfonso García Espinosa
 * @since 1.8
 * @version 02/24/2019
 */
@Entity
@Table(name = "literary_genre", catalog = "bookstore", schema = "public")
@Data
@SuppressWarnings("PersistenceUnitPresent")
public class LiteraryGenre implements Serializable {

    private static final long serialVersionUID = 8557050006908931483L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;

    @Size(max = 128)
    @Column(name = "description")
    private String description;

}
