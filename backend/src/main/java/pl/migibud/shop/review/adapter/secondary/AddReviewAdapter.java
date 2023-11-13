package pl.migibud.shop.review.adapter.secondary;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.migibud.shop.review.application.port.secondary.AddReviewPort;
import pl.migibud.shop.review.domain.model.Review;

@Repository
class AddReviewAdapter implements AddReviewPort {

    private static final ReviewEntityMapper REVIEW_MAPPER = ReviewEntityMapper.INSTANCE;

    private final ReviewRepository reviewRepository;

    public AddReviewAdapter(@Qualifier("review.ReviewRepository") ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review save(Review review) {
        ReviewEntity reviewEntity = reviewRepository.save(REVIEW_MAPPER.map(review));
        return REVIEW_MAPPER.map(reviewEntity);
    }
}
