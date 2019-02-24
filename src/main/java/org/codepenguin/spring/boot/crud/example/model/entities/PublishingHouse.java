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
import lombok.Data;

/**
 *
 * @author Jorge Alfonso García Espinosa
 * @since 1.8
 * @version 02/24/2019
 */
@Entity
@Table(name = "publishing_house", catalog = "bookstore", schema = "public")
@Data
@SuppressWarnings("PersistenceUnitPresent")
public class PublishingHouse implements Serializable {

    private static final long serialVersionUID = -8525999130725621467L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "NAME")
    private String name;

    @Size(max = 128)
    @Column(name = "CONTACT_NAME")
    private String contactName;

    @Size(max = 32)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @JoinColumn(name = "COUNTRY", referencedColumnName = "CODE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Country country;

}
