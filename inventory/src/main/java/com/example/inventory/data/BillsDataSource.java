package com.example.inventory.data;

import com.example.inventory.repository.Bill;
import com.example.inventory.repository.Goods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BillsDataSource {

    public static ObservableList<Bill> getBill() {
        ObservableList<Bill> allBills = FXCollections.observableArrayList();

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String connectQuery = "SELECT * FROM bills";


        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                Bill bill = new Bill(queryOutput.getInt("id"), queryOutput.getInt("goods_id"), queryOutput.getInt("vendor_id"), queryOutput.getString("date"), queryOutput.getInt("bill"));
                allBills.add(bill);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return allBills;
    }

    public void addBill(int vendor_id, int goods_id, double bill, String date){

        String connectionQuery = "INSERT INTO bills (vendor_id, goods_id, bill, date) VALUES ("+ vendor_id + "," + goods_id + ", " + bill + ",'" + date + "')";

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(connectionQuery);

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void removeBill(int vendor_id, int goods_id, double bill, String date){
        String connectionQuery = "DElETE FROM bills WHERE date='" + date + "'and goods_id=" + goods_id + "and bill=" + bill + "and vendor_id=" + vendor_id;

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
}
