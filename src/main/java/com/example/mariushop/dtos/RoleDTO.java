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
public class RoleDTO implements Serializable {
    private Integer id;
    private String roleName;
}
