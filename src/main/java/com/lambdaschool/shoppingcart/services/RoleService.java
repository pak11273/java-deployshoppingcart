package com.lambdaschool.shoppingcart.services;

import com.lambdaschool.shoppingcart.models.Role;

public interface RoleService
{
    Role findByName(String name);

    Role save(Role role);
}