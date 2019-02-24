package org.codepenguin.spring.boot.crud.example.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author Jorge Alfonso García Espinosa
 * @since 1.8
 * @version 02/24/2019
 */
@Entity
@Table(name = "author", catalog = "bookstore", schema = "public")
@Data
@Builder
@SuppressWarnings("PersistenceUnitPresent")
public class Author implements Serializable {

    private static final long serialVersionUID = -2251674459281564521L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "first_name")
    private String firstName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "last_name")
    private String lastName;

    @JoinColumn(name = "country", referencedColumnName = "code")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Country country;

    public String getFullName() {
        return firstName + " " + lastName;
    }

}
