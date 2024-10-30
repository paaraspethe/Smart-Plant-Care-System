package com.example.myapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PlantCareManager {
    private static SessionFactory factory;

    // Constructor initializes Hibernate SessionFactory
    public PlantCareManager() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Plant.class)
                .buildSessionFactory();
    }

    // Add a new plant
    public void addPlant(Plant plant) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(plant);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        System.out.println(plant.getName() + " has been added to the system.");
    }

    // Retrieve all plants from the database
    public List<Plant> getAllPlants() {
        Session session = factory.getCurrentSession();
        List<Plant> dbPlants = null;
        try {
            session.beginTransaction();
            dbPlants = session.createQuery("from Plant", Plant.class).getResultList();
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return dbPlants;
    }

    // Retrieve only those plants that need watering
    public List<Plant> getPlantsNeedingWater() {
        Session session = factory.getCurrentSession();
        List<Plant> plantsNeedingWater = null;
        try {
            session.beginTransaction();
            plantsNeedingWater = session.createQuery("from Plant", Plant.class).getResultList();
            session.getTransaction().commit();

            // Filter the list to only include plants that need watering
            plantsNeedingWater.removeIf(plant -> !plant.needsWatering());
        } finally {
            session.close();
        }
        return plantsNeedingWater;
    }

    // Display all plants in the system
    public void displayAllPlants() {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            List<Plant> dbPlants = session.createQuery("from Plant", Plant.class).getResultList();
            session.getTransaction().commit();

            if (dbPlants.isEmpty()) {
                System.out.println("No plants available.");
            } else {
                System.out.println("Plants in the Care System:");
                for (Plant plant : dbPlants) {
                    plant.displayInfo();  // Display each plant's info
                    System.out.println("---------------");
                }
            }
        } finally {
            session.close();
        }
    }

    // Display only those plants that need watering
    public void displayPlantsNeedingWater() {
        System.out.println("Plants that need watering:");
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            List<Plant> dbPlants = session.createQuery("from Plant", Plant.class).getResultList();
            session.getTransaction().commit();

            boolean anyNeedsWater = false;
            for (Plant plant : dbPlants) {
                if (plant.needsWatering()) {
                    plant.displayInfo(); // Display info for plants needing water
                    System.out.println("---------------");
                    anyNeedsWater = true;
                }
            }
            if (!anyNeedsWater) {
                System.out.println("No plants currently need watering.");
            }
        } finally {
            session.close();
        }
    }

    // Water a plant by name
    public void waterPlant(String plantName) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Plant plant = session.createQuery("from Plant where name = :name", Plant.class)
                    .setParameter("name", plantName)
                    .uniqueResult();
            if (plant != null) {
                plant.waterPlant(); // Update last watered date
                session.update(plant); // Persist changes
                session.getTransaction().commit();
                System.out.println(plantName + " has been watered.");
            } else {
                System.out.println("Plant not found. Please check the name and try again.");
            }
        } finally {
            session.close();
        }
    }

    // Close the SessionFactory
    public void closeSessionFactory() {
        if (factory != null) {
            factory.close();
            System.out.println("SessionFactory closed.");
        }
    }
}
