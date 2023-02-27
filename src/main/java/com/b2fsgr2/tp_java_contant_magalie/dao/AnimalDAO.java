package com.b2fsgr2.tp_java_contant_magalie.dao;

import com.b2fsgr2.tp_java_contant_magalie.entities.Animal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AnimalDAO {
    private EntityManager entityManager;

    public AnimalDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveOrUpdate(Animal animal) {
        entityManager.getTransaction().begin();

        if (animal.getId() == null) {
            entityManager.persist(animal);
        } else {
            animal = entityManager.merge(animal);
        }

        entityManager.getTransaction().commit();
    }

    public void delete(Animal animal) {
        entityManager.getTransaction().begin();
        entityManager.remove(animal);
        entityManager.getTransaction().commit();
    }

    public Animal findById(Long id) {
        return entityManager.find(Animal.class, id);
    }

    public List<Animal> findAll() {
        TypedQuery<Animal> query = entityManager.createQuery("SELECT a FROM Animal a", Animal.class);
        return query.getResultList();
    }
}
