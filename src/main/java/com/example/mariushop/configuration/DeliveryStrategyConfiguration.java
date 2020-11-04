package com.example.mariushop.configuration;

import com.example.mariushop.strategies.DeliveryStrategyInterface;
import com.example.mariushop.strategies.MostAbundantStrategy;
import com.example.mariushop.strategies.SingleLocationStrategy;
import com.example.mariushop.strategies.StrategyEnum;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeliveryStrategyConfiguration {

    @Value("${strategy}")
    private String strategy;

    @Bean
    public DeliveryStrategyInterface getDeliveryStrategy() {

        if (this.testIfValueIsFromEnum()) {
            StrategyEnum strategyValue = StrategyEnum.valueOf(strategy.toUpperCase());
            if (strategyValue == StrategyEnum.SINGLE_LOCATION) {
                return new SingleLocationStrategy();
            }
        }
        return new MostAbundantStrategy();
    }

    public boolean testIfValueIsFromEnum() {
        for (StrategyEnum strategyEnum : StrategyEnum.values())
            if (strategyEnum.name().equals(strategy.toUpperCase())) {
                return true;
            }
        return false;
    }
}