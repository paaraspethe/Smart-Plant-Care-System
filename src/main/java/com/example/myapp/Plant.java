package com.example.myapp;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "plants")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private int waterFrequency; // Water frequency in days
    @Column(name = "last_watered")
    private LocalDate lastWatered; // Date last watered

    // Default constructor (needed for Hibernate)
    public Plant() {
        // Optional: Initialize default values if needed
        this.lastWatered = LocalDate.now(); // Set to today by default
    }

    // Parameterized constructor
    public Plant(String name, String type, int waterFrequency) {
        this.name = name;
        this.type = type;
        this.waterFrequency = waterFrequency;
        this.lastWatered = LocalDate.now(); // Set to today by default
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getWaterFrequency() {
        return waterFrequency;
    }

    public LocalDate getLastWatered() {
        return lastWatered;
    }

    // Method to update last watered date
    public void waterPlant() {
        this.lastWatered = LocalDate.now();
        System.out.println(name + " has been watered.");
    }

    // Check if the plant needs watering
    public boolean needsWatering() {
        LocalDate nextWateringDate = lastWatered.plusDays(waterFrequency);
        return LocalDate.now().isAfter(nextWateringDate);
    }

    // Display information
    public void displayInfo() {
        System.out.println("Plant Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Water Frequency: " + waterFrequency + " days");
        System.out.println("Last Watered: " + lastWatered);
        System.out.println("Needs Watering: " + (needsWatering() ? "Yes" : "No"));
    }
}
