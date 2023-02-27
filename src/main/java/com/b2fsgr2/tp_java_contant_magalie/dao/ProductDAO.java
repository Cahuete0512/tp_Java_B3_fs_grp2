package com.b2fsgr2.tp_java_contant_magalie.dao;

import com.b2fsgr2.tp_java_contant_magalie.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductDAO {
    private EntityManager em;

    public ProductDAO(EntityManager em) {
        this.em = em;
    }

    public List<Product> findAll() {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM PRODUCT p", Product.class);
        return query.getResultList();
    }

    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    public void create(Product product) {
        em.persist(product);
    }

    public void update(Product product) {
        em.merge(product);
    }

    public void delete(Product product) {
        em.remove(em.merge(product));
    }
}
