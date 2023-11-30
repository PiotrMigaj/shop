package pl.migibud.shop.basket.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import pl.migibud.shop.basket.domain.vo.CartItemId;

import java.math.BigDecimal;

@Getter
@Builder
@ToString
public class CartItem {

    private final CartItemId cartItemId;

    private int quantity;

    private final Product product;

    public static CartItem createNew(int quantity, Product product) {
        return CartItem
            .builder()
            .quantity(quantity)
            .product(product)
            .build();
    }
    
    public void increaseQuantityOfProduct(int quantity){
        this.quantity+=quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public BigDecimal calculateTotalValueOfProducts(){
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}
