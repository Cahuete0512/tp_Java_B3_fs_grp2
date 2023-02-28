package com.b2fsgr2.tp_java_contant_magalie.service;

import com.b2fsgr2.tp_java_contant_magalie.dao.AnimalDAO;
import com.b2fsgr2.tp_java_contant_magalie.entities.Animal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AnimalService {
    private final EntityManager entityManager;
    private final AnimalDAO animalDAO;

    public AnimalService() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("petstorePU");
        this.entityManager = entityManagerFactory.createEntityManager();
        animalDAO = new AnimalDAO(this.entityManager);
    }
    public List<Animal> findAllByAnimalerieId(Long animalerieId) {
        return animalDAO.findAllByAnimalerieId(animalerieId);
    }

    public Animal findById(Long id) {
        entityManager.getTransaction().begin();
        Animal animal = animalDAO.findById(id);
        entityManager.getTransaction().commit();
        return animal;
    }

    public List<Animal> findAll() {
        entityManager.getTransaction().begin();
        List<Animal> animals = animalDAO.findAll();
        entityManager.getTransaction().commit();
        return animals;
    }

    public Animal saveOrUpdate(Animal animal) {
        return animalDAO.saveOrUpdate(animal);
    }

    public void delete(Animal animal) {
        entityManager.getTransaction().begin();
        animalDAO.delete(animal);
        entityManager.getTransaction().commit();
    }

    public void closeEntityManager() {
        entityManager.close();
    }
}
