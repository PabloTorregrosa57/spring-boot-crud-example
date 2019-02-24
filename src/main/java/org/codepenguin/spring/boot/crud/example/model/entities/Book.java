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
@Table(name = "book", catalog = "bookstore", schema = "public")
@Data
@Builder
@SuppressWarnings("PersistenceUnitPresent")
public class Book implements Serializable {

    private static final long serialVersionUID = 4404824974483752415L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "isbn")
    private String isbn;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "title")
    private String title;

    @Size(max = 1024)
    @Column(name = "description")
    private String description;

    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;

    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;

    @JoinColumn(name = "author", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Author author;

    @JoinColumn(name = "literary_genre", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LiteraryGenre literaryGenre;

    @JoinColumn(name = "publishing_house", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PublishingHouse publishingHouse;

}
