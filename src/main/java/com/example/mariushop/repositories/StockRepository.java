package com.example.mariushop.repositories;

import com.example.mariushop.enteties.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findAllByLocation_Id(Integer id);

    Optional<Stock> findStockByProductProductIdAndLocation_Id(Integer productID, Integer locationID);

    List<Stock> findStockByProductId(Integer productID);
}