package com.b2fsgr2.tp_java_contant_magalie.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "BIRTH")
    private Date birth;
    @Column(name = "COULEUR")
    private String couleur;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PETSTORE")
    private PetStore petStore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", birth=" + birth +
                ", couleur='" + couleur + '\'' +
                ", petStore=" + petStore +
                '}';
    }
}
