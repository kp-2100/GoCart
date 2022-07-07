package com.example.grocery;

public class Product {

    private String Product_Name;
    private String Product_Company;
    private String Price;
    private int Thumbnail;

    public Product() {

    }

    public Product(String product_Name, String product_Company, String price, int thumbnail)
    {
        Product_Name = product_Name;
        Product_Company = product_Company;
        Price = price;
        Thumbnail = thumbnail;
    }

    public Product(String product_Name, String price, int thumbnail) {
        Product_Name = product_Name;
        Price = price;
        Thumbnail = thumbnail;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public String getProduct_Company() {
        return Product_Company;
    }

    public String getDescription() {
        return Price;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public void setProduct_Company(String product_Company) {
        Product_Company = product_Company;
    }

    public void setDescription(String price) {
        price = price;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
