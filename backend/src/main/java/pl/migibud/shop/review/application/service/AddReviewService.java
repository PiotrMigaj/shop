package pl.migibud.shop.review.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.migibud.shop.review.application.port.primary.AddReviewCommand;
import pl.migibud.shop.review.application.port.primary.AddReviewUseCase;
import pl.migibud.shop.review.application.port.secondary.AddReviewPort;
import pl.migibud.shop.review.application.port.secondary.ExistsProductByIdPort;
import pl.migibud.shop.review.domain.model.Review;

@Service
@RequiredArgsConstructor
class AddReviewService implements AddReviewUseCase {

    private final AddReviewPort addReviewPort;

    private final ExistsProductByIdPort existsProductByIdPort;

    @Transactional
    @Override
    public Long addReview(AddReviewCommand addReviewCommand) {
        Review review = ReviewMapper.INSTANCE.map(addReviewCommand);
        if (!existsProductByIdPort.existsBy(review.getProductId())) {
            throw new IllegalArgumentException("There is no product with ID: %s".formatted(review.getProductId().id()));                         
        }
        return addReviewPort
            .save(review)
            .getReviewId()
            .id();
    }
}
