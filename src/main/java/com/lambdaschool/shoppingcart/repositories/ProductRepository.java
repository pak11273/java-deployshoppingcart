package com.lambdaschool.shoppingcart.repositories;

import org.springframework.data.repository.CrudRepository;
import com.lambdaschool.shoppingcart.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>
{
    Product save(Product product);
}
