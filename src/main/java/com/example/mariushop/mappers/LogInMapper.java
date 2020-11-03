package com.example.mariushop.mappers;

import com.example.mariushop.dtos.LogInDTO;
import com.example.mariushop.enteties.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogInMapper {
    public LogInDTO mapUserToLogInDTO(User user){
        return LogInDTO.builder()
                .username(user.getUsername())
                .fullName(user.getFirstName() + " " + user.getLastName())
                .password(user.getPassword())
                .roles(user.getRole().getRoleName())
                .build();
    }
}
