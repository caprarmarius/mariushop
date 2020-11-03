package com.example.mariushop.strategies;

import com.example.mariushop.dtos.OrderDetailDTO;
import com.example.mariushop.dtos.StockDTO;
import com.example.mariushop.enteties.Location;
import com.example.mariushop.enteties.Stock;
import com.example.mariushop.exceptions.ProductNotAvailableException;
import com.example.mariushop.repositories.LocationRepository;
import com.example.mariushop.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SingleLocationStrategy implements DeliveryStrategyInterface{
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<StockDTO> doAlgorithm(List<OrderDetailDTO> requested) {

        List<Location> locationList = locationRepository.findAll();
        List<StockDTO> stockList = new ArrayList<>();

        for (Location location : locationList) {
            List<Stock> locationStock = stockRepository.findAllByLocation_Id(location.getId());

            stockList.clear();

            for (Stock currentStock : locationStock) {
                for (OrderDetailDTO requestedStock : requested) {
                    if (currentStock.getProduct().getProductId().equals(requestedStock.getProductId()) && requestedStock.getQuantity() < currentStock.getQuantity()) {
                        stockList.add(
                                StockDTO.builder()
                                        .productID(requestedStock.getProductId())
                                        .locationID(location.getId())
                                        .quantity(requestedStock.getQuantity())
                                        .build()
                        );
                        if (stockList.size() == requested.size())
                            return stockList;
                    }
                }
            }
        }
        throw new ProductNotAvailableException("Products: " + requested.toString() + " not available in a single location");
    }
}
