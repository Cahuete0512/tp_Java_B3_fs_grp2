package com.b2fsgr2.tp_java_contant_magalie.entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="PETSTORE")
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name="MANAGER_NAME")
    private String managerName;
    @OneToMany(mappedBy = "petStore", cascade = CascadeType.MERGE)
    private List<Animal> animals = new ArrayList<>();
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_ADDRESS")
    private Address address;
    @ManyToMany
    @JoinTable(
            name = "PETSTORE_PRODUCT",
            joinColumns = @JoinColumn(name = "ID_PETSTORE"),
            inverseJoinColumns = @JoinColumn(name = "ID_PRODUCT")
    )

    private Set<Product> products = new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", animals=" + animals +
                ", address=" + address +
                ", products=" + products +
                '}';
    }
}
