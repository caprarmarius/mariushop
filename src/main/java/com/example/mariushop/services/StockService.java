package com.example.mariushop.services;

import com.example.mariushop.dtos.StockDTO;
import com.example.mariushop.enteties.Stock;
import com.example.mariushop.exceptions.ProductNotFoundException;
import com.example.mariushop.exceptions.StockNotFoundException;
import com.example.mariushop.mappers.StockMapper;
import com.example.mariushop.repositories.LocationRepository;
import com.example.mariushop.repositories.ProductRepository;
import com.example.mariushop.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;
    private final LocationRepository locationRepository;
    private final ProductRepository productRepository;
    private final StockMapper stockMapper;

    public StockDTO createStock(StockDTO stockDTO) {

        if (stockRepository.findStockByProductProductIdAndLocation_Id(stockDTO.getProductID(), stockDTO.getLocationID()).isPresent()) {
            Optional<Stock> optionalStock = stockRepository.findStockByProductProductIdAndLocation_Id(stockDTO.getProductID(), stockDTO.getLocationID());
            if (optionalStock.isPresent()) {
                Stock stock = optionalStock.get();
                stock.setQuantity(stockDTO.getQuantity() + stock.getQuantity());
                stockRepository.save(stock);
                return stockMapper.mapStockToStockDTO(stock);
            }
        } else {
            if (productRepository.findProductByProductId(stockDTO.getProductID()) != null) {
                Stock stock = Stock.builder()
                        .location(locationRepository.findLocationById(stockDTO.getLocationID()))
                        .quantity(stockDTO.getQuantity())
                        .product(productRepository.findProductByProductId(stockDTO.getProductID()))
                        .build();
                stockRepository.save(stock);
                return stockMapper.mapStockToStockDTO(stock);
            }
        }
        throw new ProductNotFoundException("Product: " + stockDTO.getProductID() + " does't exist");
    }

    public StockDTO updateStock(StockDTO stockDTO) {
        if (stockRepository.findStockByProductProductIdAndLocation_Id(stockDTO.getProductID(), stockDTO.getLocationID()).isPresent()) {
            Stock existingStock = stockRepository.findStockByProductProductIdAndLocation_Id(stockDTO.getProductID(), stockDTO.getLocationID()).get();
            existingStock.setQuantity(existingStock.getQuantity() - stockDTO.getQuantity());
            stockRepository.save(existingStock);
            return stockMapper.mapStockToStockDTO(existingStock);
        } else {
            throw new StockNotFoundException("Stock not found");
        }
    }

    public List<StockDTO> getAllStocks() {
        return stockMapper.mapStockListToStockDTOList(stockRepository.findAll());
    }
}
