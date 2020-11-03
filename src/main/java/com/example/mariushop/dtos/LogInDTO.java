package com.example.mariushop.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class LogInDTO implements Serializable {
    private String username;
    private String password;
    private String fullName;
    private String roles;
    private OrderDetailDTO cart;
}
