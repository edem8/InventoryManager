package com.example.inventory.data;

import com.example.inventory.repository.Goods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
   public Connection databaseLink;

   public Connection getConnection(){
       String databaseName = "store";
       String databaseUser = "root";
       String databasePassword = "@WarlordAfrica12";
       String url = "jdbc:mysql://localhost:3306/" + databaseName;

       try{
               Class.forName("com.mysql.cj.jdbc.Driver");
               databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

       } catch (Exception e){
           e.printStackTrace();
       }

       return databaseLink;
   }

    public static class GoodsDataSource {

        public static ObservableList<Goods> getGoods() {     // Retrieving goods from database
            ObservableList<Goods> newGoods = FXCollections.observableArrayList();

            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            String connectQuery = "SELECT id, name, category, quantity FROM goods";


            try {
                Statement statement = connectDB.createStatement();
                ResultSet queryOutput = statement.executeQuery(connectQuery);

                while (queryOutput.next()) {
                    Goods goods = new Goods(queryOutput.getInt("id"), queryOutput.getString("name"), queryOutput.getString("category"), queryOutput.getInt("quantity"));
                    newGoods.add(goods);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return newGoods;
        }

        public void addGoods(String name, String category, int quantity){   // Adding goods to database

            String connectionQuery = "INSERT INTO goods (name, category, quantity) VALUES ('"+ name + "','" + category + "', " + quantity + ")";

            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try{
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(connectionQuery);

            } catch (Exception e){
                e.printStackTrace();
            }
        }

        public void removeGoods(String name, String category, int quantity){    // Removing goods from database
            String connectionQuery = "DElETE FROM goods WHERE name='" + name + "'and category='" + category + "'and quantity=" + quantity;

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
}
