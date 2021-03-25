package com.lambdaschool.shoppingcart.services;

import com.lambdaschool.shoppingcart.models.Product;
import com.lambdaschool.shoppingcart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "productService")
public class ProductServiceImpl implements ProductService
{
    @Autowired
    ProductRepository productrepos;

    @Override
    public Product save(Product product)
    {
        return productrepos.save(product);
    }

}
