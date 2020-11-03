package com.example.mariushop.mappers;

import com.example.mariushop.dtos.OrderDTO;
import com.example.mariushop.enteties.Order;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper {
    private final OrderDetailMapper orderDetailMapper;
    private final AddressMapper addressMapper;
    public OrderDTO mapOrderToOrderDTO(Order order){
        return OrderDTO.builder()
                .deliveryLocation(addressMapper.mapAddressToAddressDTO(order.getDeliveryLocation().getAddress()))
                .orderTimestamp(order.getCreatedAt())
                .userId(order.getUser().getUsername())
                .productsList(orderDetailMapper.mapOrderDetailListToOrderDetailDtoList(order.getOrderDetail()))
                .build();
    }
}
