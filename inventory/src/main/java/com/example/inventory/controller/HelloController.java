package com.example.inventory.controller;


import com.example.inventory.data.DatabaseConnection;
import com.example.inventory.data.GoodsDataSource;
import com.example.inventory.repository.Goods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    @FXML
    private TextField tfname;
    @FXML
    private TextField tfcategory;
    @FXML
    private TextField tfquantity;
    @FXML
    private Button btnsave;
    @FXML
    private Button btnremove;
    @FXML
    private TableColumn<Goods, String> goodscolcategory;
    @FXML
    private TableColumn<Goods, String> goodscolname;
    @FXML
    private TableColumn<Goods, Integer> goodscolqty;
    @FXML
    private TableColumn<Goods, String> vendorcolname;
    @FXML
    private TableColumn<Goods, Integer> vendorcolnumber;
    @FXML
    private TableView<Goods> tvgoods;
    @FXML
    private void saveHandleButtonAction(ActionEvent event) {
        insertGoods();
        getGoods();
        showGoods();
    }
    @FXML
    private void removeHandleButtonAction(ActionEvent event){
        deleteGoods();
        getGoods();
        showGoods();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getGoods();
        showGoods();
    }

    public void getGoods() {     // Retrieving goods from database
        ObservableList<Goods> newGoods = FXCollections.observableArrayList();

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String connectQuery = "SELECT name, category, quantity FROM goods";


        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                Goods goods = new Goods(queryOutput.getString("name"), queryOutput.getString("category"), queryOutput.getInt("quantity"));
                newGoods.add(goods);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        tvgoods.setItems(newGoods);
    }


    public void showGoods(){
        goodscolcategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        goodscolname.setCellValueFactory(new PropertyValueFactory<>("name"));
        goodscolqty.setCellValueFactory(new PropertyValueFactory<Goods, Integer>("quantity"));
    }


    public void insertGoods(){

        GoodsDataSource addToDatabase = new GoodsDataSource();
        addToDatabase.addGoods(tfname.getText(), tfcategory.getText(), Integer.parseInt(tfquantity.getText()) );
    }

    public void deleteGoods(){
        GoodsDataSource removeFromDB = new GoodsDataSource();
        removeFromDB.removeGoods(tfname.getText(), tfcategory.getText(),Integer.parseInt(tfquantity.getText())  );
    }




}