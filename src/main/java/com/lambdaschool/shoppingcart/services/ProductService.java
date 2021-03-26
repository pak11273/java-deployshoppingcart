package com.lambdaschool.shoppingcart.services;

import com.lambdaschool.shoppingcart.models.Product;
import java.util.List;

public interface ProductService
{
    List<Product> findAll();

    Product findProductById(long id);

    void delete(long id);

    Product save(Product product);

    Product update( long id, Product product);
}