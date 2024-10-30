package com.example.myapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainAppUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Smart Plant Care Management System");

        // Content area with tabs
        TabPane contentTabs = new TabPane();
        contentTabs.getTabs().addAll(
                createTab("Add Plant", new AddPlantUI()),
                createTab("View All Plants", createViewAllPlantsUI()),
                createTab("Plants Needing Water", createPlantsNeedingWaterUI())
        );

        // Main layout without sidebar
        BorderPane layout = new BorderPane();
        layout.setCenter(contentTabs);

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Tab createTab(String title, VBox content) {
        Tab tab = new Tab(title);
        tab.setContent(content);
        tab.setClosable(false);
        return tab;
    }

    // UI for View All Plants Tab with Refresh Button
    private VBox createViewAllPlantsUI() {
        VBox viewAllPlantsUI = new ViewAllPlantsUI(); // Assume this is your custom UI component
        Button refreshButton = new Button("Refresh Data");
        refreshButton.setPadding(new Insets(5));
        refreshButton.setOnAction(e -> {
            // Call the method to refresh data
            ((ViewAllPlantsUI) viewAllPlantsUI).refreshData();
        });

        viewAllPlantsUI.getChildren().add(refreshButton); // Add the button at the top
        return viewAllPlantsUI;
    }

    // UI for Plants Needing Water Tab with Refresh Button
    private VBox createPlantsNeedingWaterUI() {
        VBox plantsNeedingWaterUI = new PlantsNeedingWaterUI(); // Assume this is your custom UI component
        Button refreshButton = new Button("Refresh Data");
        refreshButton.setPadding(new Insets(5));
        refreshButton.setOnAction(e -> {
            // Call the method to refresh data
            ((PlantsNeedingWaterUI) plantsNeedingWaterUI).refreshData();
        });

        plantsNeedingWaterUI.getChildren().add(refreshButton); // Add the button at the top
        return plantsNeedingWaterUI;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
/*package com.example.myapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainAppUI extends Application {

    @Override

    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/MainAppUI.fxml"));
            Scene scene = new Scene(root, 900, 600);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            primaryStage.setTitle("Smart Plant Care Management System");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
*/