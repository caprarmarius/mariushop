package com.example.mariushop.mappers;

import com.example.mariushop.dtos.LogInDTO;
import com.example.mariushop.enteties.Roles;
import com.example.mariushop.enteties.User;
import org.junit.jupiter.api.Test;

import javax.management.relation.Role;

import static org.junit.jupiter.api.Assertions.*;

class LogInMapperTest {

    Roles testRole = new Roles(1, "testRole", null);
    LogInDTO testLoginDTO = new LogInDTO("testuser1","testpassword1","User Test",testRole.getRoleName(),null);
    User userTest=new User(1001,"User","Test","testuser1","testpassword1","testpassword1@gmail.com", testRole, null, null);
    LogInMapper testLoginMapper = new LogInMapper();

    @Test
    void mapUserToLogInDTO() {

        LogInDTO testLoginDTOtoAssert = testLoginMapper.mapUserToLogInDTO(userTest);
        assertEquals(testLoginDTO, testLoginDTOtoAssert);
    }
}