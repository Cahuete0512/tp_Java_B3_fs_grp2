package com.b2fsgr2.tp_java_contant_magalie;

import com.b2fsgr2.tp_java_contant_magalie.entities.*;
import com.b2fsgr2.tp_java_contant_magalie.enumeration.FishEnv;
import com.b2fsgr2.tp_java_contant_magalie.enumeration.ProdType;
import com.b2fsgr2.tp_java_contant_magalie.service.AddressService;
import com.b2fsgr2.tp_java_contant_magalie.service.AnimalService;
import com.b2fsgr2.tp_java_contant_magalie.service.PetStoreService;
import com.b2fsgr2.tp_java_contant_magalie.service.ProductService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("petstorePU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        AddressService addressService = new AddressService(entityManager);
        PetStoreService petStoreService = new PetStoreService(entityManager);
        AnimalService animalService = new AnimalService();
        ProductService productService = new ProductService(entityManager);

        // Création et enregistrement des trois adresses
        Address address1 = new Address();
        Address address2 = new Address();
        Address address3 = new Address();

        address1.setStreet("Rue de la Paix");
        address1.setCity("Paris");
        address1.setNumber("10");
        address1.setZipCode("75001");
        addressService.createAddress(address1);

        address2.setStreet("Rue du Faubourg Saint-Honoré");
        address2.setCity("Paris");
        address2.setNumber("5");
        address2.setZipCode("75008");
        addressService.createAddress(address2);

        address3.setStreet("Rue de la Pompe");
        address3.setCity("Neuilly-sur-Seine");
        address3.setNumber("145");
        address3.setZipCode("92200");
        addressService.createAddress(address3);

        // Création et enregistrement des trois PetStores
        PetStore petStore1 = new PetStore();
        PetStore petStore2 = new PetStore();
        PetStore petStore3 = new PetStore();

        petStore1.setManagerName("Charlie");
        petStore1.setName("Petstore1");
        petStore1.setAddress(address1);
        petStoreService.createPetStore(petStore1);

        petStore2.setManagerName("Tony");
        petStore2.setName("Petstore2");
        petStore2.setAddress(address2);
        petStoreService.createPetStore(petStore2);

        petStore3.setManagerName("Sylla");
        petStore3.setName("Petstore3");
        petStore3.setAddress(address3);
        petStoreService.createPetStore(petStore3);

        // Création et enregistrement des trois Animaux
        Cat animal1 = new Cat();
        Fish animal2 = new Fish();
        Cat animal3 = new Cat();

        animal1.setBirth(new Date());
        animal1.setCouleur("noir");
        animal1.setPetStore(petStore1);
        animal1.setChipId("cat2023");
        animalService.saveOrUpdate(animal1);

        animal2.setBirth(new Date());
        animal2.setCouleur("blanc");
        animal2.setPetStore(petStore2);
        animal2.setLivingEnv(FishEnv.SEA_WATER);
        animalService.saveOrUpdate(animal2);

        animal3.setBirth(new Date());
        animal3.setCouleur("roux");
        animal3.setPetStore(petStore3);
        animal3.setChipId("cat2022");
        animalService.saveOrUpdate(animal3);

        // Création et enregistrement des trois Produits
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();

        product1.setCode("PROD001");
        product1.setLabel("Croquettes pour chat");
        product1.setType(ProdType.FOOD);
        product1.setPrice(9.99);
        productService.create(product1);

        product2.setCode("PROD002");
        product2.setLabel("Jouet pour chien");
        product2.setType(ProdType.ACCESSORY);
        product2.setPrice(12.99);
        productService.create(product2);


        product3.setCode("PROD003");
        product3.setLabel("Litière pour chat");
        product3.setType(ProdType.CLEANING);
        product3.setPrice(6.99);
        productService.create(product3);

        // Récupérer toutes les adresses
        List<Address> addresses = addressService.findAll();
        // Afficher la liste des adresses
        System.out.println("Liste des adresses :");
        for (Address address : addresses) {
            System.out.println(address);
        }
        List<PetStore> petStores = petStoreService.getAllPetStores();
        System.out.println("Liste des PetStores : ");
        for (PetStore petStore : petStores) {
            System.out.println(petStore);
        }
        List<Animal> animals = animalService.findAll();
        System.out.println("Liste des Animaux : ");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
        List<Product> products = productService.findAll();
        System.out.println("Liste des Produits : ");
        for (Product product : products) {
            System.out.println(product);
        }

        Long petstoreId = 97L;// FIXME : Ligne à modifier suivant l'id du petstore en base
        List<Animal> animalsByPetstore = animalService.findAllByAnimalerieId(petstoreId);
        System.out.println("Liste des Animaux d'un Petstore : ");
        for (Animal animal : animalsByPetstore) {
            System.out.println(animal);
        }
        // Fermer l'EntityManager
        entityManager.close();
    }
}


