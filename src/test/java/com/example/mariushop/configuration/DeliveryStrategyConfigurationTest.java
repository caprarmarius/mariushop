package com.example.mariushop.configuration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryStrategyConfigurationTest {

    DeliveryStrategyConfiguration deliveryStrategyConfiguration = new DeliveryStrategyConfiguration();

    @Test
    void testIfValueIsFromEnum() {
        deliveryStrategyConfiguration.setStrategy("SINGLE_LOCATION");
        assertTrue(deliveryStrategyConfiguration.testIfValueIsFromEnum());
    }
}