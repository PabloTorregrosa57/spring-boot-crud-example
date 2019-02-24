package org.codepenguin.spring.boot.crud.example.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "country", catalog = "bookstore", schema = "public")
@Data
@SuppressWarnings("PersistenceUnitPresent")
public class Country implements Serializable {

    private static final long serialVersionUID = 1923572507151040775L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "code")
    private String code;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "alpha_3")
    private String alpha3;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;

}
