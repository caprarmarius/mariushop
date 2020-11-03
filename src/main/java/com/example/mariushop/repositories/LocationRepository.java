package com.example.mariushop.repositories;

import com.example.mariushop.enteties.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    Optional<Location> findByAddress_CountryAndAddress_CityAndAddress_Street(String country, String city, String street);

    Location findLocationById(Integer id);
}
