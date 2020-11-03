package com.example.mariushop.mappers;

import com.example.mariushop.dtos.RoleDTO;
import com.example.mariushop.enteties.Roles;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public RoleDTO mapRoleToRoleDTO(Roles role){
        return RoleDTO.builder()
                .id(role.getRoleId())
                .roleName(role.getRoleName())
                .build();
    }
}
