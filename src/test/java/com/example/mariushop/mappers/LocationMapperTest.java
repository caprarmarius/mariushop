package com.example.mariushop.mappers;

import com.example.mariushop.dtos.AddressDTO;
import com.example.mariushop.dtos.LocationDTO;
import com.example.mariushop.enteties.Address;
import com.example.mariushop.enteties.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationMapperTest {

    AddressMapper addressMapperTest = new AddressMapper();
    Address testAddress = new Address(1001,"Romania","Arad","Test Street");
    AddressDTO testAdressDTO = new AddressDTO(1001,"Romania","Arad","Test Street");
    Location testLocation = new Location(1001,"Location1",null,null,testAddress);
    LocationDTO testLocationDTO = new LocationDTO(1001,"Location1",testAdressDTO);
    LocationMapper testLocationMapper = new LocationMapper(addressMapperTest);

    @Test
    void mapLocationToLocationDTO() {
        assertEquals(testLocationDTO,testLocationMapper.mapLocationToLocationDTO(testLocation));
    }
}