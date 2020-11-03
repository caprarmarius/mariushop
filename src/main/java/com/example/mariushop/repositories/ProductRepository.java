package com.example.mariushop.repositories;

import com.example.mariushop.enteties.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findProductByProductID(Integer id);

}
