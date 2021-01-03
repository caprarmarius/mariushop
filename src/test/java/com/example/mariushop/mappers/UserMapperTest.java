package com.example.mariushop.mappers;

import com.example.mariushop.dtos.CartDTO;
import com.example.mariushop.dtos.RoleDTO;
import com.example.mariushop.dtos.UserDTO;
import com.example.mariushop.enteties.Cart;
import com.example.mariushop.enteties.Order;
import com.example.mariushop.enteties.Roles;
import com.example.mariushop.enteties.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {
    Roles testRole = new Roles(1, "testRole", null);
    RoleDTO testRoleDTO = new RoleDTO(1, "testRole");
    List<Cart> testCartList = new ArrayList<>();
    CartMapper testCartMapper = new CartMapper();
    List<CartDTO> testCartDTOList = testCartMapper.mapCartListToCartDTOList(testCartList);
    List<Order> testOrderList = new ArrayList<>();
    RoleMapper testRoleMapper = new RoleMapper();

    UserMapper userMapperTest = new UserMapper(testRoleMapper,testCartMapper);
    User userTest=new User(1001,"User","Test","testuser1","testpassword1","testpassword1@gmail.com",testRole, testOrderList, testCartList);
    UserDTO userTestDTO=new UserDTO(1001,"testuser1","testpassword1","UserTest","testpassword1@gmail.com",testRoleDTO,testCartDTOList);
    @Test
    void mapUserToUserDTO() {
        assertEquals(userTestDTO,userMapperTest.mapUserToUserDTO(userTest));
    }
}