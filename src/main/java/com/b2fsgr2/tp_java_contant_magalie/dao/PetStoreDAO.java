package com.b2fsgr2.tp_java_contant_magalie.dao;

import com.b2fsgr2.tp_java_contant_magalie.entities.PetStore;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class PetStoreDAO {
    private EntityManager entityManager;

    public PetStoreDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public PetStore create(PetStore petStore) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(petStore);
        transaction.commit();
        return petStore;
    }

    public PetStore getById(Long id) {
        return entityManager.find(PetStore.class, id);
    }

    public List<PetStore> getAll() {
        TypedQuery<PetStore> query = entityManager.createQuery("SELECT p FROM PetStore p", PetStore.class);
        return query.getResultList();
    }

    public void update(PetStore petStore) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(petStore);
        transaction.commit();
    }

    public void delete(PetStore petStore) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entityManager.contains(petStore) ? petStore : entityManager.merge(petStore));
        transaction.commit();
    }
}

