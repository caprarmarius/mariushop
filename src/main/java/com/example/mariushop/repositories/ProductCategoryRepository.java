package com.example.mariushop.repositories;

import com.example.mariushop.enteties.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    Optional<ProductCategory> findByName(String name);

}