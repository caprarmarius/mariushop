package com.example.mariushop.services;

import com.example.mariushop.mappers.CartMapper;
import com.example.mariushop.mappers.LogInMapper;
import com.example.mariushop.mappers.UserMapper;
import com.example.mariushop.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
class UserServiceTest {

    private final UserService userServiceTest;
    private final UserRepository userRepositoryTest;
    private final UserMapper userMapperTest;
    private final RolesService rolesServiceTest;
    private final LogInMapper logInMapperTest;
    private final CartMapper cartMapperTest;

    @Test
    void findAll() {

    }

    @Test
    void splitNames() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void update() {
    }

    @Test
    void findUser() {
    }

    @Test
    void findUserByUsername() {
    }

    @Test
    void validateCredentials() {
    }

    @Test
    void findByUsername() {
    }

    @Test
    void postCart() {
    }
}