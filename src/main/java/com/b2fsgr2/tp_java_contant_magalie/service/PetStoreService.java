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

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tp_java_contant_magalie");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private PetStoreDAO petStoreDAO = new PetStoreDAO(entityManager);

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
        entityManagerFactory.close();
    }
}
