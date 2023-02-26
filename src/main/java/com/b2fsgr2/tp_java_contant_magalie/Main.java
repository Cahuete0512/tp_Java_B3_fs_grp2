package com.b2fsgr2.tp_java_contant_magalie;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("petstorePU");
        entityManagerFactory.close();
    }

}
