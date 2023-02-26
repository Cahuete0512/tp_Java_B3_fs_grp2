package com.b2fsgr2.tp_java_contant_magalie.entities;


import com.b2fsgr2.tp_java_contant_magalie.enumeration.ProdType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="CODE")
    private String code;
    @Column(name="LABEL")
    private String label;
    @Enumerated(EnumType.ORDINAL)
    @Column(name="TYPE")
    private ProdType type;
    @Column(name="PRICE")
    private double price;

    @ManyToMany(mappedBy = "products")
    private Set<PetStore> petStores = new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<PetStore> getPetStores() {
        return petStores;
    }

    public void setPetStores(Set<PetStore> petStores) {
        this.petStores = petStores;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", label='" + label + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", petStores=" + petStores +
                '}';
    }
}
