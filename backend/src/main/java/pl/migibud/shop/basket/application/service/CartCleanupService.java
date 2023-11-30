package pl.migibud.shop.basket.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.migibud.shop.basket.application.port.primary.cartcleanup.CartCleanupUseCase;
import pl.migibud.shop.basket.application.port.secondary.CartCleanupPort;

@Service
@RequiredArgsConstructor
class CartCleanupService implements CartCleanupUseCase {
    
    private final CartCleanupPort cartCleanupPort;
    @Override
    public void cleanUpOldCarts() {
        cartCleanupPort.cleanUpOldCarts();
    }
}
