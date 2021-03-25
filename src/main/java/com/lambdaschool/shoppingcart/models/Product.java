package com.lambdaschool.shoppingcart.models;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productid;

    private String comments;

    private String description;

    private String name;

    private double price;

    public Product() { }

    public Product(String comments, String description, String name, double price)
    {
        this.comments = comments;
        this.description = description;
        this.name = name;
        this.price = price;
    }

    public long getProductid() { return productid; }

    public void setProductid(long productid) { this.productid = productid; }

    public String getComments() { return comments; }

    public void setComments(String comments) { this.comments = comments; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }
}
