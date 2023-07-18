package com.example.inventory.data;

import com.example.inventory.repository.Goods;
import com.example.inventory.repository.Vendor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VendorsDataSource {
    public void addVendors (String name, String number) {
        String connectionQuery = "INSERT INTO vendors (name, number) VALUES ('" + name + "','" + number + "')";

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(connectionQuery);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void removeVendor(String name, String number){
        String connectionQuery = "DElETE FROM vendors WHERE name='" + name + "'and number='" + number + "'";

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(connectionQuery);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public ObservableList<Vendor> getVendor() {     // Retrieving goods from database
        ObservableList<Vendor> allVendors = FXCollections.observableArrayList();

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String connectQuery = "SELECT name, number FROM vendors";


        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                Vendor vendor = new Vendor(queryOutput.getString("name"), queryOutput.getString("number"));
                allVendors.add(vendor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return allVendors;
    }
}
