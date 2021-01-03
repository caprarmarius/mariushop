package com.example.mariushop.mappers;

import com.example.mariushop.dtos.AddressDTO;
import com.example.mariushop.enteties.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressMapperTest {

    Address testAddress = new Address(1001,"Romania","Arad","Test Street");
    AddressDTO testAdressDTO = new AddressDTO(1001,"Romania","Arad","Test Street");

    AddressMapper addressMapperTest = new AddressMapper();

    @Test
    void mapAddressToAddressDTO() {
        assertEquals(testAdressDTO,addressMapperTest.mapAddressToAddressDTO(testAddress));
    }
}