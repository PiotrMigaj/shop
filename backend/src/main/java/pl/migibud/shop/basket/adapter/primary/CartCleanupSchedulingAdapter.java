package pl.migibud.shop.basket.adapter.primary;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.migibud.shop.basket.application.port.primary.cartcleanup.CartCleanupUseCase;

@Slf4j
@Service
@RequiredArgsConstructor
class CartCleanupSchedulingAdapter {
    
    private final CartCleanupUseCase cartCleanupUseCase;

    @Scheduled(cron = "${app.cartCleanup.scheduling.cron}", zone = "Europe/Warsaw")
    void cleanUpOldCarts() {
        log.info("Start cleaning up the basket...");
        cartCleanupUseCase.cleanUpOldCarts();
        log.info("Finish cleaning up the basket...");
    }
}
