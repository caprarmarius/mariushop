package com.example.mariushop.mappers;

import com.example.mariushop.dtos.ProductDTO;
import com.example.mariushop.enteties.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDTO mapProductToProductDto(Product product){
        return ProductDTO.builder()
                .productName(product.getName())
                .id(product.getProductId())
                .description(product.getDescription())
                .price(product.getPrice())
                .categoryDescription(product.getProductCategory().getDescription())
                .categoryName(product.getProductCategory().getDescription())
                .weight(product.getWeight())
                .image(product.getImage())
                .build();
    }
}
