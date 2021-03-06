package com.example.mariushop.services;

import com.example.mariushop.dtos.AddressDTO;
import com.example.mariushop.dtos.OrderDTO;
import com.example.mariushop.dtos.StockDTO;
import com.example.mariushop.enteties.Address;
import com.example.mariushop.enteties.Location;
import com.example.mariushop.enteties.Order;
import com.example.mariushop.enteties.User;
import com.example.mariushop.exceptions.OrderNotFoundException;
import com.example.mariushop.mappers.OrderDetailMapper;
import com.example.mariushop.mappers.OrderMapper;
import com.example.mariushop.repositories.AddressRepository;
import com.example.mariushop.repositories.LocationRepository;
import com.example.mariushop.repositories.OrderRepository;
import com.example.mariushop.strategies.DeliveryStrategyInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderDetailMapper orderDetailMapper;
    private final AddressRepository addressRepository;
    private final LocationRepository locationRepository;
    private final DeliveryStrategyInterface deliveryStrategyInterface;
    private final StockService stockService;
    private final UserService userService;

    public OrderDTO getOrderById(Integer id) throws OrderNotFoundException {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            return orderMapper.mapOrderToOrderDTO(orderOptional.get());
        } else {
            throw new OrderNotFoundException("This order doesn't exist");
        }
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        List<StockDTO> orderedProducts = deliveryStrategyInterface.doAlgorithm(orderDTO.getProductsList());
        User user = userService.findUserByUsername(orderDTO.getUserId());
        Order order = Order.builder()
                .deliveryLocation(this.testLocationExistence(orderDTO.getDeliveryLocation().getAddressCity(), orderDTO.getDeliveryLocation()))
                .createdAt(LocalDateTime.now())
                .user(user)
                .orderDetail(orderDetailMapper.mapOrderDetailListDtoToOrderDetailList(orderDTO.getProductsList()))
                .shippedFrom(locationRepository.findLocationById(2))
                .build();

        order.getOrderDetail().forEach(orderDetail -> orderDetail.setOrder(order));
        orderRepository.save(order);
        orderedProducts.forEach(stockService::updateStock);
        return orderMapper.mapOrderToOrderDTO(order);
    }

    public Address testAddressExistence(String country, String city, String street) {
        Optional<Address> addressOptional = addressRepository.findByCountryAndAndCityAndStreet(country, city, street);
        Address address;
        if (addressOptional.isPresent()) {
            address = addressOptional.get();
        } else {
            address = new Address();
            address.setCountry(country);
            address.setCity(city);
            address.setStreet(street);
            addressRepository.save(address);
        }
        return address;
    }

    public Location testLocationExistence(String name, AddressDTO addressDTO) {
        Optional<Location> locationOptional = locationRepository.findByAddress_CountryAndAddress_CityAndAddress_Street
                (addressDTO.getAddressCountry(), addressDTO.getAddressCity(), addressDTO.getAddressStreet());
        Location location;

        if (locationOptional.isPresent()) {
            location = locationOptional.get();
        } else {
            location = new Location();
            location.setName(name);
            location.setAddress(
                    this.testAddressExistence(addressDTO.getAddressCountry(), addressDTO.getAddressCity(), addressDTO.getAddressStreet()));
            locationRepository.save(location);
        }
        return location;
    }

    public List<OrderDTO> getOrders() {
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (Order order : orderRepository.findAll())
            orderDTOS.add(orderMapper.mapOrderToOrderDTO(order));
        return orderDTOS;
    }
}
