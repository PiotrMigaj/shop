package pl.migibud.shop.basket.application.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.migibud.shop.basket.BasketIntegrationTestConfiguration;
import pl.migibud.shop.basket.application.port.primary.addproduct.AddProductToCartCommand;
import pl.migibud.shop.basket.application.port.primary.addproduct.AddProductToCartUseCase;
import pl.migibud.shop.basket.domain.vo.CartId;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = BasketIntegrationTestConfiguration.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AddProductToCartServiceIntegrationTest {
    
    @Autowired
    private AddProductToCartUseCase addProductToCartUseCase;
    
    @Test
    @Sql("/DATA/AddProductToCartServiceIntegrationTestSql.sql")
    void shouldAddProductToCart_whenThereAreNoProductsInCart(){
        //given
        AddProductToCartCommand addProductToCartCommand = AddProductToCartCommand
            .builder()
            .cardId(-1L)
            .productId(1L)
            .quantity(1)
            .build();

        //when
        CartId cartId = addProductToCartUseCase.addProductToCart(addProductToCartCommand);

        //then
        assertThat(cartId).isNotNull();
    }

}