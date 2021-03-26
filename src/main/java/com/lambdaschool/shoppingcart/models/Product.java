package com.lambdaschool.shoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@JsonIgnoreProperties(value = "hasprice")
public class Product extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productid;

    private String comments;

    private String description;

    private String name;

    private double price;

    @Transient
    public boolean hasprice = false;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "product", allowSetters = true)
    private List<User> users = new ArrayList<>();

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

    public List<User> getUsers() { return users; }

    public void setPrice(double price) {
        hasprice = true;
        this.price = price;
    }
}
