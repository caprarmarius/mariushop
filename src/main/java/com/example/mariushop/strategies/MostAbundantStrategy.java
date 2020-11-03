package com.example.mariushop.strategies;

import com.example.mariushop.dtos.OrderDetailDTO;
import com.example.mariushop.dtos.StockDTO;
import com.example.mariushop.enteties.Stock;
import com.example.mariushop.exceptions.ProductNotAvailableException;
import com.example.mariushop.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MostAbundantStrategy implements DeliveryStrategyInterface {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<StockDTO> doAlgorithm(List<OrderDetailDTO> requested) {
        List<StockDTO> existingProducts = new ArrayList<>();
        for (OrderDetailDTO requestedProducts : requested) {
            List<Stock> stocksWhichContainsTheProduct = stockRepository.findStockByProductId(requestedProducts.getProductId());
            Stock mostAbundant = stocksWhichContainsTheProduct.stream().max(Comparator.comparing(Stock::getQuantity)).get();
            if (requestedProducts.getQuantity() < mostAbundant.getQuantity())
                existingProducts.add(StockDTO.builder()
                        .quantity(requestedProducts.getQuantity())
                        .locationID(mostAbundant.getLocation().getId())
                        .productID(requestedProducts.getProductId())
                        .build()
                );
            if (existingProducts.size() == requested.size())
                return existingProducts;
        }
        throw new ProductNotAvailableException("Products: " + requested.toString() + " not available");
    }
}
