package com.lambdaschool.shoppingcart.services;

import com.lambdaschool.shoppingcart.models.User;

public interface UserService
{
    User findByName(String name);

    User save(User user);
}