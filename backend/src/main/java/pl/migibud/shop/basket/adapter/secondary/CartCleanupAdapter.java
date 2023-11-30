package pl.migibud.shop.basket.adapter.secondary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.migibud.shop.basket.application.port.secondary.CartCleanupPort;
import pl.migibud.shop.util.timeprovider.api.TimeProvider;

@Slf4j
@Repository
class CartCleanupAdapter implements CartCleanupPort {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    private final TimeProvider timeProvider;

    public CartCleanupAdapter(
        @Qualifier("basket.CartRepository") CartRepository cartRepository,
        @Qualifier("basket.CartItemRepository") CartItemRepository cartItemRepository, 
        TimeProvider timeProvider) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.timeProvider = timeProvider;
    }

    @Transactional
    @Override
    public void cleanUpOldCarts() {
        final var carts = cartRepository.findByCreatedLessThan(timeProvider
            .dateTimeNow()
            .minusDays(15));
        log.info("Stare koszyki: " + carts.size());
        final var ids = carts
            .stream()
            .map(CartEntity::getId)
            .toList();
        if (!ids.isEmpty()){
            cartItemRepository.deleteAllByCartIdIn(ids);
            cartRepository.deleteAllByIdIn(ids);
        }
    }

}
