package com.example.mariushop.mappers;

import com.example.mariushop.dtos.CartDTO;
import com.example.mariushop.enteties.Cart;
import com.example.mariushop.enteties.User;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class CartMapperTest {

    User testCartUser = new User(1001,"User","Test","testuser1","testpassword1","testpassword1@gmail.com",null, null, null);
    CartDTO testCartDTO = new CartDTO(1001,1002,10);
    CartDTO testCartDTO2 = new CartDTO(1002,1004,10);
    CartDTO testCartDTO3 = new CartDTO(1003,1005,10);
    Cart testCart = new Cart(1001,10,1002,testCartUser);
    Cart testCart2 = new Cart(1002,10,1004,testCartUser);
    Cart testCart3 = new Cart(1003,10,1005,testCartUser);
    CartMapper testCartMapper = new CartMapper();
    List<Cart> testCartList = new ArrayList<Cart>();
    List<CartDTO> testCartDTOList = new ArrayList<CartDTO>();


    @Test
    public   void mapCartToCartDTO() {
        assertEquals(testCartDTO,testCartMapper.mapCartToCartDTO(testCart));
    }

    @Test
public    void mapCartListToCartDTOList() {
        testCartList.add(testCart);
        testCartList.add(testCart2);
        testCartList.add(testCart3);
        testCartDTOList.add(testCartDTO);
        testCartDTOList.add(testCartDTO2);
        testCartDTOList.add(testCartDTO3);
        assertEquals(testCartDTOList,testCartMapper.mapCartListToCartDTOList(testCartList));
    }

    @Test
public    void mapCartDTOToCart() {
        Cart testCartToAssert = testCartMapper.mapCartDTOToCart(testCartDTO);
        testCartToAssert.setUser(testCartUser);
        assertEquals(testCart,testCartToAssert);
    }

    @Test
 public   void mapCartDTOListToCartList() {
        testCartList.add(testCart);
        testCartList.add(testCart2);
        testCartList.add(testCart3);
        testCartDTOList.add(testCartDTO);
        testCartDTOList.add(testCartDTO2);
        testCartDTOList.add(testCartDTO3);
        List<Cart> testCartListToAssert = testCartMapper.mapCartDTOListToCartList(testCartDTOList);
        for(int i=0; i<3; i++)
            testCartListToAssert.get(i).setUser(testCartUser);
        assertEquals(testCartList,testCartListToAssert);
    }
}