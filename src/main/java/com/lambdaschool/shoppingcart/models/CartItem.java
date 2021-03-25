package com.lambdaschool.shoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cartitems")
@IdClass(CartItemId.class)
public class CartItem extends Auditable implements Serializable
{
    private long quantity;

    private String comments;

    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "roles", allowSetters = true)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "productid")
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    private Product product;

    public CartItem() { }

    public CartItem(
        User user,
        Product product,
        long quantity,
        String comments)
    {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.comments = comments;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public long getQuantity()
    {
        return quantity;
    }

    public void setQuantity(long quantity)
    {
        this.quantity = quantity;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        CartItem that = (CartItem) o;
        return ((user == null) ? 0 : user.getUserid()) == ((that.user == null) ? 0 : that.user.getUserid()) &&
            ((product == null) ? 0 : product.getProductid()) == ((that.product == null) ? 0 : that.product.getProductid());
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}
