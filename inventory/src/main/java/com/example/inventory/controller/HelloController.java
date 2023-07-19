package com.example.inventory.controller;


import com.example.inventory.data.*;
import com.example.inventory.repository.Bill;
import com.example.inventory.repository.Goods;
import com.example.inventory.repository.IssueGoods;
import com.example.inventory.repository.Vendor;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
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
    private TextField atf;
    @FXML
    private TextField datf;
    @FXML
    private TextField vtf;
    @FXML
    private TextField gft;
    @FXML
    private Button vrbtn;
    @FXML
    private TextField tfcategory;
    @FXML
    private TextField tfquantity;
    @FXML
    private Label statuslb;
    @FXML
    private TextField ptf;
    @FXML
    private TableColumn<IssueGoods, Integer> colishId;
    @FXML
    private TableColumn<IssueGoods, Integer> colIshgoodsId;
    @FXML
    private TableColumn<IssueGoods, Integer> colIshqty;
    @FXML
    private TableColumn<IssueGoods, Double> colIShprice;
    @FXML
    private TableColumn<IssueGoods, String> colIshdate;
    @FXML
    private TextField dtf;
    @FXML
    private TextField qtf;
    @FXML
    private TextField idtf;
    @FXML
    private Button issuebtn;
    @FXML
    private Button bsbtn;
    @FXML
    private Button brbtn;
    @FXML
    private TableView<IssueGoods> tvIssued;
    @FXML
    private Button btnsave;
    @FXML
    private Button btnremove;
    @FXML
    private TableView<Bill> billtv;
    @FXML
    private TableColumn<Bill, Integer> colblld;
    @FXML
    private TableColumn<Bill, Integer> colbllbll;
    @FXML
    private TableColumn<Bill, Integer> colbillvid;
    @FXML
    private TableColumn<Bill, Integer> colbillgid;
    @FXML
    private TableColumn<Bill, String> colbilld;
    @FXML
    private TableColumn<Goods, String> goodscolcategory;
    @FXML
    private TableColumn<Goods, Integer> colgoodsid;
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

    @FXML
    private void handleIssueGoodsBtn(ActionEvent event){
    if (event.getSource() == issuebtn){
        issueGoods();
        showIssuedGoods();
        dtf.clear();
        qtf.clear();
        ptf.clear();
        idtf.clear();
    }
    }

    @FXML
    private void handleBillBtn(ActionEvent event){
        if(event.getSource() == bsbtn){
            insertBill();
            showBills();
            vtf.clear();
            datf.clear();
            atf.clear();
            gft.clear();
        } else if (event.getSource()  == brbtn) {
            removeBill();
            showBills();
            vtf.clear();
            datf.clear();
            atf.clear();
            gft.clear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showGoods();
        showVendors();
        showIssuedGoods();
        showBills();
    }




    public void showGoods(){
        DatabaseConnection.GoodsDataSource getGoodsList = new DatabaseConnection.GoodsDataSource();
        ObservableList<Goods> list = getGoodsList.getGoods();

        tvgoods.setItems(list);

        goodscolcategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colgoodsid.setCellValueFactory(new PropertyValueFactory<>("id"));
        goodscolname.setCellValueFactory(new PropertyValueFactory<>("name"));
        goodscolqty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }

    public void showVendors(){
        VendorsDataSource getVendorList = new VendorsDataSource();
        ObservableList<Vendor> list = getVendorList.getVendor();

        tvVendors.setItems(list);

        vendorcolname.setCellValueFactory(new PropertyValueFactory<>("name"));
        vendorcolnumber.setCellValueFactory(new PropertyValueFactory<>("number"));

    }


    public void showIssuedGoods(){
        IssuedGoodsDataSource getIssuedList = new IssuedGoodsDataSource();
        ObservableList<IssueGoods> list = getIssuedList.getIssuedGoods();

        tvIssued.setItems(list);

        colishId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colIshgoodsId.setCellValueFactory(new PropertyValueFactory<>("goods_id"));
        colIshqty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colIShprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colIshdate.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    public void showBills(){
        BillsDataSource getBillList = new BillsDataSource();
        ObservableList<Bill> list = getBillList.getBill();

        billtv.setItems(list);

        colblld.setCellValueFactory(new PropertyValueFactory<>("id"));
        colbllbll.setCellValueFactory(new PropertyValueFactory<>("bill"));
        colbillvid.setCellValueFactory(new PropertyValueFactory<>("vendor_id"));
        colbillgid.setCellValueFactory(new PropertyValueFactory<>("goods_id"));
        colbilld.setCellValueFactory(new PropertyValueFactory<>("date"));
    }


    public void insertGoods(){

        DatabaseConnection.GoodsDataSource addToDatabase = new DatabaseConnection.GoodsDataSource();
        addToDatabase.addGoods(tfname.getText(), tfcategory.getText(), Integer.parseInt(tfquantity.getText()) );
    }

    public void insertBill(){

        BillsDataSource addToDatabase = new BillsDataSource();
        addToDatabase.addBill(Integer.parseInt(vtf.getText()), Integer.parseInt(gft.getText()),  Double.parseDouble(atf.getText()), datf.getText());
    }

    public void insertVendors(){

        VendorsDataSource addToDatabase = new VendorsDataSource();
        addToDatabase.addVendors(vtfname.getText(), vtfnumber.getText() );
    }

    public  void issueGoods(){
        IssuedGoodsDataSource issueGood = new IssuedGoodsDataSource();
        issueGood.issueGoods(Double.parseDouble(ptf.getText()), idtf.getText(), Integer.parseInt(qtf.getText()), dtf.getText());
    }




    public void deleteVendors(){

        VendorsDataSource removeFromDB = new VendorsDataSource();
        removeFromDB.removeVendor(vtfname.getText(), vtfnumber.getText() );
    }


    public void deleteGoods(){
        DatabaseConnection.GoodsDataSource removeFromDB = new DatabaseConnection.GoodsDataSource();
        removeFromDB.removeGoods(tfname.getText(), tfcategory.getText(),Integer.parseInt(tfquantity.getText())  );
    }

    public void removeBill(){

        BillsDataSource addToDatabase = new BillsDataSource();
        addToDatabase.addBill(Integer.parseInt(vtf.getText()), Integer.parseInt(gft.getText()),  Double.parseDouble(atf.getText()), datf.getText());
    }


}