package com.example.mariushop.repositories;

import com.example.mariushop.enteties.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Roles findByRoleName(String name);
}
