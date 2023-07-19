package com.example.inventory.data;

import com.example.inventory.repository.IssueGoods;
import com.example.inventory.repository.Vendor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class IssuedGoodsDataSource {

    public void issueGoods(Double price, String goods_id, int quantity, String date) {
        String connectionQuery = "INSERT INTO issue_goods (goods_id, price, quantity, date) VALUES ('" + goods_id + "'," + price + "," + quantity + ",'" + date + "')";

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(connectionQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public ObservableList<IssueGoods> getIssuedGoods() {
        ObservableList<IssueGoods> allIssuedGoods = FXCollections.observableArrayList();

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String connectQuery = "SELECT * FROM issue_goods";


        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                IssueGoods issued = new IssueGoods(queryOutput.getInt("id"), queryOutput.getDouble("price"), queryOutput.getInt("goods_id"), queryOutput.getInt("quantity"), queryOutput.getString("date"));
                allIssuedGoods.add(issued);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return allIssuedGoods;
    }
}
