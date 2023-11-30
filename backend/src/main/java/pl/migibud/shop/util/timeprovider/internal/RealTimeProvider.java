package pl.migibud.shop.util.timeprovider.internal;

import org.springframework.stereotype.Component;
import pl.migibud.shop.util.timeprovider.api.TimeProvider;

import java.time.Instant;
@Component
class RealTimeProvider implements TimeProvider {

    @Override
    public Instant now() {
        return Instant.now();
    }

}
