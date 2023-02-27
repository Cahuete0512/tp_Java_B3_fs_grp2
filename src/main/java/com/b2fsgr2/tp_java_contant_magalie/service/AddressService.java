package com.b2fsgr2.tp_java_contant_magalie.service;

import com.b2fsgr2.tp_java_contant_magalie.dao.AddressDAO;
import com.b2fsgr2.tp_java_contant_magalie.entities.Address;
import com.b2fsgr2.tp_java_contant_magalie.entities.PetStore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AddressService {
    private EntityManager entityManager;
    private AddressDAO addressDAO;

    public AddressService() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("petstorePU");
        entityManager = entityManagerFactory.createEntityManager();
        addressDAO = new AddressDAO(entityManager);
    }
    public Address createAddress(Address address) {
        return addressDAO.create(address);
    }
    public void saveOrUpdate(Address address) {
        entityManager.getTransaction().begin();
        addressDAO.saveOrUpdate(address);
        entityManager.getTransaction().commit();
    }

    public void delete(Address address) {
        entityManager.getTransaction().begin();
        addressDAO.delete(address);
        entityManager.getTransaction().commit();
    }

    public Address getAddressById(Long id) {
        return addressDAO.findById(id);
    }

    public List<Address> findAll() {
        return addressDAO.findAll();
    }

    public void closeEntityManager() {
        entityManager.close();
    }
    public void closeEntityManagerFactory() {
        entityManager.close();
    }
}
