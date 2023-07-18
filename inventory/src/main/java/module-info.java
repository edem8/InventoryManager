module com.example.inventory {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.inventory to javafx.fxml;
    exports com.example.inventory;
    exports com.example.inventory.controller;
    exports com.example.inventory.repository;
    opens com.example.inventory.controller to javafx.fxml;
    opens com.example.inventory.repository to javafx.fxml;
}