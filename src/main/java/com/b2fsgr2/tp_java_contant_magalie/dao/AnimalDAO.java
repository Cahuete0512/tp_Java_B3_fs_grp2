package com.b2fsgr2.tp_java_contant_magalie.dao;

import com.b2fsgr2.tp_java_contant_magalie.entities.Animal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class AnimalDAO {
    private final EntityManager entityManager;

    public AnimalDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Animal saveOrUpdate(Animal animal) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(animal);
        transaction.commit();
        return animal;
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

    public List<Animal> findAllByAnimalerieId(Long petstoreId) {
        List<Animal> animaux = entityManager.createQuery("SELECT a FROM Animal a WHERE a.petStore.id = :petstoreId", Animal.class)
                .setParameter("petstoreId", petstoreId)
                .getResultList();
        entityManager.close();
        return animaux;
    }
}
