package com.example.myapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.List;

public class PlantsNeedingWaterUI extends VBox {

    private TableView<Plant> table;

    public PlantsNeedingWaterUI() {
        table = new TableView<>();
        TableColumn<Plant, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));

        TableColumn<Plant, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));

        TableColumn<Plant, Integer> frequencyColumn = new TableColumn<>("Water Frequency");
        frequencyColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getWaterFrequency()).asObject());

        TableColumn<Plant, String> lastWateredColumn = new TableColumn<>("Last Watered");
        lastWateredColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLastWatered().toString()));

        table.getColumns().addAll(nameColumn, typeColumn, frequencyColumn, lastWateredColumn);

        refreshTableData();

        getChildren().add(table);
    }

    public void refreshData() {
        refreshTableData();
    }

    private void refreshTableData() {
        PlantCareManager manager = new PlantCareManager();
        List<Plant> plants = manager.getPlantsNeedingWater();
        ObservableList<Plant> plantList = FXCollections.observableArrayList(plants);
        table.setItems(plantList);
    }
}
