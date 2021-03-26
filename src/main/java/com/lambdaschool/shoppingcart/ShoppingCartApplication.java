package com.lambdaschool.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@PropertySource(value = "file:C:/Users/pak11/web39shoppingcartconfig.properties", ignoreResourceNotFound = true)
public class ShoppingCartApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ShoppingCartApplication.class, args);
    }

}