package pl.migibud.shop.basket.application.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.migibud.shop.basket.application.port.primary.AddProductToCartCommand;
import pl.migibud.shop.basket.application.port.primary.AddProductToCartUseCase;
import pl.migibud.shop.basket.application.port.secondary.ExistsProductByIdPort;
import pl.migibud.shop.basket.application.port.secondary.QueryCartByIdPort;
import pl.migibud.shop.basket.application.port.secondary.SaveCartPort;
import pl.migibud.shop.basket.domain.model.Cart;
import pl.migibud.shop.basket.domain.vo.CartId;
import pl.migibud.shop.basket.domain.vo.ProductId;

import javax.persistence.EntityNotFoundException;

@Service
class AddProductToCartService implements AddProductToCartUseCase {
    
    private final QueryCartByIdPort queryCartByIdPort;
    private final SaveCartPort saveCartPort;
    private final ExistsProductByIdPort existsProductByIdPort;

    public AddProductToCartService(
        QueryCartByIdPort queryCartByIdPort, 
        SaveCartPort saveCartPort,
        @Qualifier("basket.ExistsProductByIdAdapter") ExistsProductByIdPort existsProductByIdPort
    ) {
        this.queryCartByIdPort = queryCartByIdPort;
        this.saveCartPort = saveCartPort;
        this.existsProductByIdPort = existsProductByIdPort;
    }

    @Transactional
    @Override
    public CartId addProductToCart(AddProductToCartCommand command) {

        checkIfProductExists(command);
        Cart cart = getInitializedCart(command);
        addProductToCart(command, cart);
        return saveCartPort.save(cart);
    }

    private void addProductToCart(AddProductToCartCommand command, Cart cart) {
        ProductId productId = ProductId
            .builder()
            .id(command.productId())
            .build();
        cart.addProduct(productId, command.quantity());
    }

    private void checkIfProductExists(AddProductToCartCommand command) {
        ProductId productId = ProductId
            .builder()
            .id(command.productId())
            .build();
        if (!existsProductByIdPort.existsBy(productId)){
            throw new EntityNotFoundException("There is no product with ID: %s".formatted(productId.id()));
        }
    }
    
    private Cart getInitializedCart(AddProductToCartCommand command){
        Long cardId = command.cardId();
        if (cardId==null || cardId<0){
            return Cart.createEmpty();
        }
        return queryCartByIdPort.queryBy(CartId.builder().id(cardId).build());
    }

}
