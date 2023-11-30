package pl.migibud.shop.basket.domain.model;

import org.junit.jupiter.api.Test;
import pl.migibud.shop.basket.domain.vo.CartItemId;
import pl.migibud.shop.basket.domain.vo.ProductId;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CartTest {
    
    @Test
    void shouldCreateEmptyCart(){
        //given
        
        //when
        Cart cart = Cart.createEmpty();
        //then
        assertAll(
            ()->assertThat(cart).isNotNull()
                                .extracting("created")
                                .satisfies(),
            ()->assertThat(cart)
                .extracting("items")
                .asList()
                .isEmpty()
        );
    }
    
    @Test
    void shouldAddProductToEmptyCartItemList(){
        //given
        Cart cart = Cart.createEmpty();
        Product product = Product.builder().productId(ProductId.builder().id(1L).build()).build();
        int quantity = 1;
        
        //when
        cart.addProduct(product,quantity);
        
        //then
        assertAll(
            ()->assertThat(cart)
                .extracting("items")
                .asList()
                .isNotEmpty()
                .hasSize(1)
                .extracting("quantity")
                .containsExactly(1),
            ()->assertThat(cart)
                .extracting("items")
                .asList()
                .extracting("product")
                .asList()
                .extracting("productId")
                .containsExactly(ProductId.builder().id(1L).build())
        );
    }

    @Test
    void shouldAddProductToCartItemList_whenCartHasAnotherProduct(){
        //given
        Cart cart = Cart.createEmpty();
        Product product1 = Product.builder().productId(ProductId.builder().id(1L).build()).build();
        Product product2 = Product.builder().productId(ProductId.builder().id(2L).build()).build();
        int quantity1 = 1;
        int quantity2 = 2;
        cart.addProduct(product1,quantity1);

        //when
        cart.addProduct(product2,quantity2);

        //then
        assertAll(
            ()->assertThat(cart)
                .extracting("items")
                .asList()
                .isNotEmpty()
                .hasSize(2)
                .extracting("quantity")
                .containsExactly(1,2),
            ()->assertThat(cart)
                .extracting("items")
                .asList()
                .extracting("product")
                .asList()
                .extracting("productId")
                .containsExactly(ProductId.builder().id(1L).build(),ProductId.builder().id(2L).build())
        );
    }
    
    @Test
    void shouldIncreaseQuantityOfProduct(){
        //given
        Cart cart = Cart.createEmpty();
        Product product1 = Product.builder().productId(ProductId.builder().id(1L).build()).build();
        int quantity1 = 1;
        int quantity2 = 2;
        cart.addProduct(product1,quantity1);

        //when
        cart.addProduct(product1,quantity2);

        //then
        assertAll(
            ()->assertThat(cart)
                .extracting("items")
                .asList()
                .isNotEmpty()
                .hasSize(1)
                .extracting("quantity")
                .containsExactly(3),
            ()->assertThat(cart)
                .extracting("items")
                .asList()
                .extracting("product")
                .asList()
                .extracting("productId")
                .containsExactly(ProductId.builder().id(1L).build())
        );
    }
    
    @Test
    void shouldCalculateTotalValueOfCart_andThereAreNoProductsInCart(){
        //given
        Cart cart = Cart.createEmpty();

        //when
        BigDecimal result = cart.calculateTotalValueOfCart();

        //then
        assertThat(result).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    void shouldCalculateTotalValueOfCart(){
        //given
        Cart cart = Cart.createEmpty();
        Product product1 = Product.builder().productId(ProductId.builder().id(1L).build()).price(new BigDecimal("20.00")).build();
        Product product2 = Product.builder().productId(ProductId.builder().id(2L).build()).price(new BigDecimal("15.00")).build();
        int quantity1 = 1;
        int quantity2 = 2;
        cart.addProduct(product1,quantity1);
        cart.addProduct(product2,quantity2);
        
        //when
        BigDecimal result = cart.calculateTotalValueOfCart();

        //then
        assertThat(result).isEqualTo(new BigDecimal("50.00"));
    }
    
    @Test
    void shouldUpdateCart(){
        //given
        Product product1 = Product.builder().productId(ProductId.builder().id(1L).build()).price(new BigDecimal("20.00")).build();
        Product product2 = Product.builder().productId(ProductId.builder().id(2L).build()).price(new BigDecimal("15.00")).build();
        int quantity1 = 1;
        int quantity2 = 2;
        CartItem cartItem1 = CartItem
            .builder()
            .cartItemId(CartItemId
                .builder()
                .id(1L)
                .build())
            .quantity(quantity1)
            .product(product1)
            .build();

        CartItem cartItem2 = CartItem
            .builder()
            .cartItemId(CartItemId
                .builder()
                .id(2L)
                .build())
            .quantity(quantity2)
            .product(product2)
            .build();

        Cart cart = Cart.createEmpty();
        cart.addCartItems(List.of(cartItem1,cartItem2));

        CartItem cartItem1Update = CartItem
            .builder()
            .cartItemId(CartItemId
                .builder()
                .id(1L)
                .build())
            .quantity(10)
            .build();

        //when
        cart.updateCart(List.of(cartItem1Update));
        
        //then
        assertThat(cartItem1.getQuantity()).isEqualTo(10);

    }
    
    

}