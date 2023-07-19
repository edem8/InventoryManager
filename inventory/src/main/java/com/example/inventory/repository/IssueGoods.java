package com.example.inventory.repository;

import java.sql.Date;

public class IssueGoods {
    private int id;
    private double price;
    private int goods_id;
    private int quantity;
    private String date;

    public IssueGoods(int id, double price, int goods_id, int quantity, String date) {
        this.id = id;
        this.price = price;
        this.goods_id = goods_id;
        this.quantity = quantity;
        this.date = date;
    }

    public IssueGoods(double price, int goods_id, int quantity, String date) {
        this.price = price;
        this.goods_id = goods_id;
        this.quantity = quantity;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
