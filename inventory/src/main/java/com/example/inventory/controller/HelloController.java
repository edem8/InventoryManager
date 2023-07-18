package com.example.inventory.controller;


import com.example.inventory.data.DatabaseConnection;
import com.example.inventory.data.GoodsDataSource;
import com.example.inventory.data.VendorsDataSource;
import com.example.inventory.repository.Goods;
import com.example.inventory.repository.Vendor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    @FXML
    private TableView<Vendor> tvVendors;
    @FXML
    private TextField vtfname;
    @FXML
    private TextField vtfnumber;
    @FXML
    private TextField tfname;
    @FXML
    private Button vsbtn;
    @FXML
    private Button vrbtn;
    @FXML
    private TextField tfcategory;
    @FXML
    private TextField tfquantity;
    @FXML
    private Label statuslb;
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
    private TableColumn<Vendor, String> vendorcolname;
    @FXML
    private TableColumn<Vendor, String > vendorcolnumber;
    @FXML
    private TableView<Goods> tvgoods;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnsave) {
            insertGoods();
            showGoods();
            tfname.clear();
            tfcategory.clear();
            tfquantity.clear();
        }
        else if (event.getSource() == btnremove){
            deleteGoods();
            showGoods();
            tfname.clear();
            tfcategory.clear();
            tfquantity.clear();
        }

    }
    @FXML
    private void onHandleVendorAction(ActionEvent event){
        if (event.getSource() == vsbtn) {
            insertVendors();
            showVendors();
            vtfname.clear();
            vtfnumber.clear();

        }
        else if (event.getSource() == vrbtn){
            deleteVendors();
            showVendors();
            vtfname.clear();
            vtfnumber.clear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showGoods();
        showVendors();
    }




    public void showGoods(){
        GoodsDataSource getGoodsList = new GoodsDataSource();
        ObservableList<Goods> list = getGoodsList.getGoods();

        tvgoods.setItems(list);

        goodscolcategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        goodscolname.setCellValueFactory(new PropertyValueFactory<>("name"));
        goodscolqty.setCellValueFactory(new PropertyValueFactory<Goods, Integer>("quantity"));
    }

    public void showVendors(){
        VendorsDataSource getVendorList = new VendorsDataSource();
        ObservableList<Vendor> list = getVendorList.getVendor();

        tvVendors.setItems(list);

        vendorcolname.setCellValueFactory(new PropertyValueFactory<>("name"));
        vendorcolnumber.setCellValueFactory(new PropertyValueFactory<>("number"));

    }



    public void insertGoods(){

        GoodsDataSource addToDatabase = new GoodsDataSource();
        addToDatabase.addGoods(tfname.getText(), tfcategory.getText(), Integer.parseInt(tfquantity.getText()) );
    }

    public void insertVendors(){

        VendorsDataSource addToDatabase = new VendorsDataSource();
        addToDatabase.addVendors(vtfname.getText(), vtfnumber.getText() );
    }




    public void deleteVendors(){

        VendorsDataSource removeFromDB = new VendorsDataSource();
        removeFromDB.removeVendor(vtfname.getText(), vtfnumber.getText() );
    }


    public void deleteGoods(){
        GoodsDataSource removeFromDB = new GoodsDataSource();
        removeFromDB.removeGoods(tfname.getText(), tfcategory.getText(),Integer.parseInt(tfquantity.getText())  );
    }




}