package com.example.mariushop.services;

import com.example.mariushop.enteties.Roles;
import com.example.mariushop.repositories.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolesService {
    private final RolesRepository rolesRepository;

    public Roles getRoleByName(String roleName) {
        return rolesRepository.findByRoleName(roleName);
    }
}
