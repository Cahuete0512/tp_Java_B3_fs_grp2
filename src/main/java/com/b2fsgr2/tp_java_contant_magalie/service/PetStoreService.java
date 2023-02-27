package com.b2fsgr2.tp_java_contant_magalie.service;

import com.b2fsgr2.tp_java_contant_magalie.dao.PetStoreDAO;
import com.b2fsgr2.tp_java_contant_magalie.entities.PetStore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class PetStoreService {
    private EntityManager entityManager;

    private PetStoreDAO petStoreDAO;

    public PetStoreService() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("petstorePU");
        entityManager = entityManagerFactory.createEntityManager();
        petStoreDAO = new PetStoreDAO(entityManager);
    }

    public PetStore createPetStore(PetStore petStore) {
        return petStoreDAO.create(petStore);
    }

    public PetStore getPetStoreById(Long id) {
        return petStoreDAO.getById(id);
    }

    public List<PetStore> getAllPetStores() {
        return petStoreDAO.getAll();
    }

    public void updatePetStore(PetStore petStore) {
        petStoreDAO.update(petStore);
    }

    public void deletePetStore(PetStore petStore) {
        petStoreDAO.delete(petStore);
    }

    public void closeEntityManager() {
        entityManager.close();
    }

    public void closeEntityManagerFactory() {
        entityManager.close();
    }
}
