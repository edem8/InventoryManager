package com.example.inventory.repository;

public class Goods {
    private  int id;
    private String name;
    public String category;
    private int quantity;

    public Goods(String name, String category, int quantity){
        this.name = name;
        this.category= category;
        this.quantity = quantity;
    }

    public Goods(int id, String name, String category, int quantity){
        this.id = id;
        this.name = name;
        this.category= category;
        this.quantity = quantity;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
