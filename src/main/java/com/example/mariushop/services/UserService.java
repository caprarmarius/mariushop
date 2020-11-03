package com.example.mariushop.services;

import com.example.mariushop.dtos.LogInDTO;
import com.example.mariushop.dtos.UserDTO;
import com.example.mariushop.enteties.Roles;
import com.example.mariushop.enteties.User;
import com.example.mariushop.exceptions.UserNotFoundException;
import com.example.mariushop.exceptions.UsernameAlreadyUsedException;
import com.example.mariushop.mappers.CartMapper;
import com.example.mariushop.mappers.LogInMapper;
import com.example.mariushop.mappers.UserMapper;
import com.example.mariushop.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RolesService rolesService;
    private final LogInMapper logInMapper;
    private final CartMapper cartMapper;

    public List<UserDTO> findAll() {
        List<UserDTO> userList = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            userList.add(userMapper.mapUserToUserDTO(user));
        }
        return userList;
    }

    public String[] splitNames(String name) {
        return name.split(" ", 2);
    }

    public UserDTO save(UserDTO newUser) {
        if (!userRepository.findUserByUsername(newUser.getUsername()).isPresent()) {
            String[] splitName = splitNames(newUser.getFullName());
            Roles role = rolesService.getRoleByName(newUser.getRole().getRoleName());
            User user = User.builder()
                    .emailAddress(newUser.getEmailAddress())
                    .username(newUser.getUsername())
                    .firstName(splitName[0])
                    .lastName(splitName[1])
                    .password(newUser.getPassword())
                    .role(role)
                    .selectedProducts(cartMapper.mapCartDTOListToCartList(newUser.getCart()))
                    .build();
            userRepository.save(user);
            return userMapper.mapUserToUserDTO(user);
        }
        throw new UsernameAlreadyUsedException("Username " + newUser.getUsername() + " is already used");
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public UserDTO update(Integer id, UserDTO userToUpdate) {
        String[] splitName = splitNames(userToUpdate.getFullName());
        Roles role = Roles.builder()
                .roleName(userToUpdate.getRole().getRoleName())
                .roleId(userToUpdate.getRole().getId())
                .build();

        if (userRepository.findById(id).isPresent()) {
            User existingUser = userRepository.findById(id).get();
            existingUser.setEmailAddress(userToUpdate.getEmailAddress());
            existingUser.setFirstName(splitName[0]);
            existingUser.setLastName(splitName[1]);
            existingUser.setPassword(userToUpdate.getPassword());
            existingUser.setRole(role);
            userRepository.save(existingUser);
            return userMapper.mapUserToUserDTO(existingUser);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    public User findUser(Integer userId) {
        if (userRepository.findById(userId).isPresent()) {
            return userRepository.findById(userId).get();
        } else {
            throw new UserNotFoundException(userId);
        }
    }

    public User findUserByUsername(String username) {
        if (userRepository.findUserByUsername(username).isPresent())
            return userRepository.findUserByUsername(username).get();
        else
            throw new UserNotFoundException(username);
    }

    public LogInDTO validateCredentials(LogInDTO logInDTO) {
        Optional<User> optionalUser = userRepository.findUserByUsername(logInDTO.getUsername());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(logInDTO.getPassword())) {
                LogInDTO.builder()
                        .username(logInDTO.getUsername())
                        .password(logInDTO.getPassword())
                        .fullName(logInDTO.getFullName())
                        .roles(logInDTO.getRoles())
                        .build();
                return logInMapper.mapUserToLogInDTO(user);
            }
        }
        throw new UserNotFoundException(logInDTO.getUsername());
    }

    public UserDTO findByUsername(String username) {
        Optional<User> userOptional = userRepository.findUserByUsername(username);
        if (userOptional.isPresent()) {
            return userMapper.mapUserToUserDTO(userOptional.get());
        } else {
            throw new UserNotFoundException(username);
        }
    }

    public UserDTO postCart(String username, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findUserByUsername(username);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setSelectedProducts(cartMapper.mapCartDTOListToCartList(userDTO.getCart()));
            existingUser.getSelectedProducts().forEach(selectedProduct -> selectedProduct.setUser(existingUser));
            userRepository.save(existingUser);
            return userMapper.mapUserToUserDTO(existingUser);
        }
        throw new UserNotFoundException(username);
    }
}
