package pl.migibud.shop.basket.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import pl.migibud.shop.basket.domain.vo.CartItemId;
import pl.migibud.shop.basket.domain.vo.ProductId;

import java.math.BigDecimal;

@Getter
@Builder
@ToString
public class CartItem {

    private CartItemId cartItemId;

    private int quantity;

    private ProductId productId;

    public static CartItem createNew(int quantity, ProductId productId) {
        return CartItem
            .builder()
            .quantity(quantity)
            .productId(productId)
            .build();
    }
    
    public void increaseQuantityOfProduct(int quantity){
        this.quantity+=quantity;
    }
    
    public BigDecimal calculateTotalValueOfProducts(){
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}
