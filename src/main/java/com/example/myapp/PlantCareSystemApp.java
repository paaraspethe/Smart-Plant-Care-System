package com.example.myapp;

import java.util.List;
import java.util.Scanner;

public class PlantCareSystemApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Plant Care System!");

        PlantCareManager plantManager = new PlantCareManager();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add a new plant");
            System.out.println("2. Display all plants");
            System.out.println("3. Display plants needing water");
            System.out.println("4. Water a plant");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addPlant(scanner, plantManager);
                case 2 -> displayAllPlants(plantManager);
                case 3 -> displayPlantsNeedingWater(plantManager);
                case 4 -> waterPlant(scanner, plantManager);
                case 5 -> {
                    System.out.println("Exiting the Plant Care System. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
        plantManager.closeSessionFactory(); // Close Hibernate SessionFactory on exit
    }

    private static void addPlant(Scanner scanner, PlantCareManager plantManager) {
        System.out.print("Enter plant name: ");
        String name = scanner.nextLine();
        System.out.print("Enter plant type (Indoor/Outdoor): ");
        String type = scanner.nextLine();
        System.out.print("Enter watering frequency (in days): ");
        int waterFrequency = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Plant newPlant = new Plant(name, type, waterFrequency);
        plantManager.addPlant(newPlant);
    }

    private static void displayAllPlants(PlantCareManager plantManager) {
        List<Plant> plants = plantManager.getAllPlants(); // Use getAllPlants() to fetch plants
        if (plants.isEmpty()) {
            System.out.println("No plants available.");
        } else {
            System.out.println("Plants in the Care System:");
            for (Plant plant : plants) {
                plant.displayInfo();
                System.out.println("---------------");
            }
        }
    }

    private static void displayPlantsNeedingWater(PlantCareManager plantManager) {
        List<Plant> plantsNeedingWater = plantManager.getPlantsNeedingWater();
        if (plantsNeedingWater.isEmpty()) {
            System.out.println("No plants currently need watering.");
        } else {
            System.out.println("Plants that need watering:");
            for (Plant plant : plantsNeedingWater) {
                plant.displayInfo();
                System.out.println("---------------");
            }
        }
    }

    private static void waterPlant(Scanner scanner, PlantCareManager plantManager) {
        System.out.print("Enter the name of the plant to water: ");
        String plantName = scanner.nextLine();

        // Use PlantCareManager's waterPlant method to water the plant
        plantManager.waterPlant(plantName);
    }
}
