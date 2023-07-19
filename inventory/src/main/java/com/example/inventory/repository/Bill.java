package com.example.inventory.repository;

public class Bill {
private int id;
private int goods_id;
private int vendor_id;
private String date;
private double bill;

    public Bill(int id, int goods_id, int vendor_id, String date, double bill) {
        this.id = id;
        this.goods_id = goods_id;
        this.vendor_id = vendor_id;
        this.date = date;
        this.bill = bill;
    }

    public Bill(int goods_id, int vendor_id, String date, double bill) {
        this.goods_id = goods_id;
        this.vendor_id = vendor_id;
        this.date = date;
        this.bill = bill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double amount) {
        this.bill = amount;
    }
}
