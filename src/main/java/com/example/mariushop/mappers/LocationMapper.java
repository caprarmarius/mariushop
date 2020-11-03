package com.example.mariushop.mappers;

import com.example.mariushop.dtos.LocationDTO;
import com.example.mariushop.enteties.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationMapper {
    private final AddressMapper addressMapper;

    public LocationDTO mapLocationToLocationDTO(Location location)
    {
        return LocationDTO.builder()
                .id(location.getId())
                .locationName(location.getName())
                .addressDTO(addressMapper.mapAddressToAddressDTO(location.getAddress()))
                .build();
    }
}
