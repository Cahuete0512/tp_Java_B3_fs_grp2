package com.b2fsgr2.tp_java_contant_magalie.service;

import com.b2fsgr2.tp_java_contant_magalie.dao.ProductDAO;
import com.b2fsgr2.tp_java_contant_magalie.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductService {
    private EntityManager entityManager;
    private ProductDAO productDAO;

    public ProductService() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("petstorePU");
        entityManager = entityManagerFactory.createEntityManager();
        productDAO = new ProductDAO(entityManager);
    }

    public List<Product> findAll() {
        entityManager.getTransaction().begin();
        List<Product> products = productDAO.findAll();
        entityManager.getTransaction().commit();
        return products;
    }

    public Product findById(Long id) {
        entityManager.getTransaction().begin();
        Product product = productDAO.findById(id);
        entityManager.getTransaction().commit();
        return product;
    }

    public void create(Product product) {
        entityManager.getTransaction().begin();
        productDAO.create(product);
        entityManager.getTransaction().commit();
    }

    public void update(Product product) {
        entityManager.getTransaction().begin();
        productDAO.update(product);
        entityManager.getTransaction().commit();
    }

    public void delete(Product product) {
        entityManager.getTransaction().begin();
        productDAO.delete(product);
        entityManager.getTransaction().commit();
    }

    public void closeEntityManager() {
        entityManager.close();
    }
}