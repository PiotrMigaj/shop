package pl.migibud.shop.basket;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "pl.migibud.shop.basket.adapter.secondary")
@EnableJpaRepositories(basePackages = "pl.migibud.shop.basket.adapter.secondary")
@ComponentScan(basePackages = "pl.migibud.shop.basket")
public class BasketIntegrationTestConfiguration {
}
