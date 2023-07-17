package com.example.inventory.data;

import com.example.inventory.repository.Goods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GoodsDataSource {
    public static void getGoods(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String connectQuery = "SELECT name, category, quantity FROM goods";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while(queryOutput.next()){
                System.out.println(queryOutput.getString("category"));
                System.out.println(queryOutput.getString("name"));
                System.out.println(queryOutput.getString("quantity"));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
