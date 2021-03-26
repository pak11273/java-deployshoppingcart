package com.lambdaschool.shoppingcart.services;

import com.lambdaschool.shoppingcart.ShoppingCartApplicationTests;
import com.lambdaschool.shoppingcart.models.*;
import com.lambdaschool.shoppingcart.repositories.CartItemRepository;
import com.lambdaschool.shoppingcart.repositories.ProductRepository;
import com.lambdaschool.shoppingcart.repositories.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingCartApplicationTests.class, properties = {"command.line.runner.enabled=false"})
public class CartItemServiceImplUnitTestNoDB
{

    @Autowired
    CartItemService cartItemService;

    @MockBean
    private UserRepository userrepos;

    @MockBean
    private ProductRepository prodrepos;

    @MockBean
    private CartItemRepository cartitemrepos;

    List<User> userList = new ArrayList<>();
    List<Product> prodList = new ArrayList<>();

    @Before
    public void setUp() throws Exception
    {

        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        r1.setRoleid(1);
        r2.setRoleid(2);

        User u1 = new User("barnbarn", "LambdaLlama", "barnbarn@host.local", "added via seed data");
        u1.getRoles().add(new UserRoles(u1, r1));
        u1.getRoles().add(new UserRoles(u1, r2));

        u1.setUserid(1);

        User u2 = new User("cinnamon", "LambdaLlama", "cinnamon@host.local", "added via seed data");
        u2.getRoles().add(new UserRoles(u2, r2));

        u2.setUserid(2);

        User u3 = new User("stumps", "LambdaLlama", "stumps@host.local", "added via seed data");
        u3.getRoles().add(new UserRoles(u3, r2));
        u3.setUserid(3);

        // Adding Products

        Product p1 = new Product();
        p1.setProductid(1);
        p1.setName("PEN");
        p1.setDescription("MAKES WORDS");
        p1.setPrice(2.50);
        p1.setComments("added via seed data");

        Product p2 = new Product();
        p1.setProductid(2);
        p2.setName("PENCIL");
        p2.setDescription("DOES MATH");
        p2.setPrice(1.50);
        p2.setComments("added via seed data");

        Product p3 = new Product();
        p1.setProductid(3);
        p3.setName("COFFEE");
        p3.setDescription("EVERYONE NEEDS COFFEE");
        p3.setPrice(4.00);
        p3.setComments("added via seed data");

        prodList.add(p1);
        prodList.add(p2);
        prodList.add(p3);

        // Creating Carts
        cartItemService.addToCart(u1.getUserid(), p1.getProductid(), "added via seed data");
        cartItemService.addToCart(u1.getUserid(), p2.getProductid(), "added via seed data");
        cartItemService.addToCart(u1.getUserid(), p3.getProductid(), "added via seed data");
        cartItemService.addToCart(u2.getUserid(), p3.getProductid(), "added via seed data");
        cartItemService.addToCart(u3.getUserid(), p3.getProductid(), "added via seed data");

    }

    @After
    public void tearDown() throws Exception
    {
    }

//    @Test
//    public void addToCart()
//    {
//        CartItemId cartItemId = new CartItemId(1, 1);
//        CartItem cart3 = new CartItem();
//        cart3.setUser(userList.get(0));
//        cart3.setProduct(prodList.get(0));
//        cart3.setComments("");
//        cart3.setQuantity(2);
//
//        Mockito.when(userrepos.findById(1L)).thenReturn(Optional.of(userList.get(0)));
//        Mockito.when(prodrepos.findById(1L)).thenReturn(Optional.of(prodList.get(0)));
//        Mockito.when(cartitemrepos.save(any(CartItem.class))).thenReturn(cart3);
//
//        assertEquals(3, cartItemService.addToCart(1L, 1L, "Hello").getQuantity());
//    }

//    @Test
//    public void removeFromCart()
//    {
//        CartItemId cartItemId = new CartItemId(1, 1);
//        CartItem cart3 = new CartItem();
//        cart3.setUser(userList.get(0));
//        cart3.setProduct(prodList.get(0));
//        cart3.setComments("");
//        cart3.setQuantity(3);
//
//        Mockito.when(userrepos.findById(1L)).thenReturn(Optional.of(userList.get(0)));
//        Mockito.when(prodrepos.findById(1L)).thenReturn(Optional.of(prodList.get(0)));
//        Mockito.when(cartitemrepos.findById(any(CartItemId.class))).thenReturn(Optional.of(cart3));
//        Mockito.when(cartitemrepos.save(any(CartItem.class))).thenReturn(cart3);
//
//        assertEquals(2, cartItemService.removeFromCart(1L, 1L, "Bye").getQuantity());
//    }

//    @Test
//    public void emptyFromCart()
//    {
//        CartItemId cartItemId = new CartItemId(1, 1);
//        CartItem cart3 = new CartItem();
//        cart3.setUser(userList.get(0));
//        cart3.setProduct(prodList.get(0));
//        cart3.setComments("");
//        cart3.setQuantity(1);
//
//        Mockito.when(userrepos.findById(1L)).thenReturn(Optional.of(userList.get(0)));
//        Mockito.when(prodrepos.findById(1L)).thenReturn(Optional.of(prodList.get(0)));
//        Mockito.when(cartitemrepos.findById(any(CartItemId.class))).thenReturn(Optional.of(cart3));
//        Mockito.when(cartitemrepos.save(any(CartItem.class))).thenReturn(null);
//
//        assertNull(cartItemService.removeFromCart(1L, 1L, "Bye"));
//
//    }
}