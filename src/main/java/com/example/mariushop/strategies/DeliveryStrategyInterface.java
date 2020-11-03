package com.example.mariushop.strategies;

import com.example.mariushop.dtos.OrderDetailDTO;
import com.example.mariushop.dtos.StockDTO;

import java.util.List;

public interface DeliveryStrategyInterface {
    List<StockDTO> doAlgorithm(List<OrderDetailDTO> orderDetailDTOList);
}
