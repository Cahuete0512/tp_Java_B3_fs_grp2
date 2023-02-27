package com.b2fsgr2.tp_java_contant_magalie.dao;

import com.b2fsgr2.tp_java_contant_magalie.entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class AddressDAO {
    private EntityManager entityManager;

    public AddressDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Address findById(Long id) {
        return entityManager.find(Address.class, id);
    }

    public List<Address> findAll() {
        TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a", Address.class);
        return query.getResultList();
    }
    public void saveOrUpdate(Address address) {
        if (address.getId() == null) {
            entityManager.persist(address);
        } else {
            entityManager.merge(address);
        }
    }
    public void delete(Address address) {
        entityManager.remove(address);
    }

    public Address create(Address address) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(address);
        transaction.commit();
        return address;
    }
}
