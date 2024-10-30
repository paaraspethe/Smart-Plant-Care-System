package com.example.myapp;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class AddPlantUI extends VBox {

    public AddPlantUI() {
        setPadding(new Insets(15));
        setSpacing(10);

        Label nameLabel = new Label("Plant Name:");
        TextField nameField = new TextField();

        Label typeLabel = new Label("Plant Type (Indoor/Outdoor):");
        ComboBox<String> typeField = new ComboBox<>();
        typeField.getItems().addAll("Indoor", "Outdoor");

        Label frequencyLabel = new Label("Watering Frequency (days):");
        Spinner<Integer> frequencySpinner = new Spinner<>(1, 30, 7);

        Button addButton = new Button("Add Plant");

        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String type = typeField.getValue();
            int waterFrequency = frequencySpinner.getValue();
            // Add plant to database logic here
            PlantCareManager manager = new PlantCareManager();
            manager.addPlant(new Plant(name, type, waterFrequency));
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Plant added successfully!");
            alert.show();
        });

        getChildren().addAll(nameLabel, nameField, typeLabel, typeField, frequencyLabel, frequencySpinner, addButton);
    }
}
