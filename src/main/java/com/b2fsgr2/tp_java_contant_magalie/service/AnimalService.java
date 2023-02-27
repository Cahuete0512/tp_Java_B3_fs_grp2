package com.b2fsgr2.tp_java_contant_magalie.service;

import com.b2fsgr2.tp_java_contant_magalie.dao.AnimalDAO;
import com.b2fsgr2.tp_java_contant_magalie.entities.Animal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AnimalService {
    private EntityManager entityManager;
    private AnimalDAO animalDAO;

    public AnimalService() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("petstorePU");
        entityManager = entityManagerFactory.createEntityManager();
        animalDAO = new AnimalDAO(entityManager);
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

    public void saveOrUpdate(Animal animal) {
        entityManager.getTransaction().begin();
        animalDAO.saveOrUpdate(animal);
        entityManager.getTransaction().commit();
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
