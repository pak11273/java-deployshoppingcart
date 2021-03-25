package com.lambdaschool.shoppingcart.services;

import com.lambdaschool.shoppingcart.exceptions.ResourceNotFoundException;
import com.lambdaschool.shoppingcart.models.Role;
import com.lambdaschool.shoppingcart.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "roleService")
public class RoleServiceImpl implements RoleService
{
    @Autowired
    RoleRepository rolerepos;

    @Override
    public Role findByName(String name)
    {
        Role rr = rolerepos.findByName(name);

        if (rr != null)  return rr;
        throw new ResourceNotFoundException(name);
    }

    @Transactional
    @Override
    public Role save(Role role)
    {
        if (role.getUsers() .size() > 0)
        {
            throw new ResourceNotFoundException("User Roles are not updated through Role.");
        }

        return rolerepos.save(role);
    }
}
