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
public class CartDTO implements Serializable {
    private Integer id;
    private Integer productId;
    private Integer quantity;
}
