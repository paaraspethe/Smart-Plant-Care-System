package com.example.myapp;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainAppUIController {

    @FXML private TextField plantNameField;
    @FXML private ComboBox<String> plantTypeComboBox;
    @FXML private TextField wateringFrequencyField;

    private PlantCareManager plantManager = new PlantCareManager();

    @FXML
    private void handleAddPlant() {
        String name = plantNameField.getText();
        String type = plantTypeComboBox.getValue();
        int waterFrequency;

        try {
            waterFrequency = Integer.parseInt(wateringFrequencyField.getText());

            if (name.isEmpty() || type == null) {
                showAlert("Error", "Please fill in all fields to add a plant.", AlertType.ERROR);
            } else {
                Plant newPlant = new Plant(name, type, waterFrequency);
                plantManager.addPlant(newPlant);
                showAlert("Success", "Plant added successfully!", AlertType.INFORMATION);

                // Clear fields after addition
                plantNameField.clear();
                plantTypeComboBox.getSelectionModel().clearSelection();
                wateringFrequencyField.clear();
            }
        } catch (NumberFormatException ex) {
            showAlert("Error", "Please enter a valid number for watering frequency.", AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
