package pl.migibud.shop.review.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.migibud.shop.review.api.Review;

@Service
@RequiredArgsConstructor
class ReviewFacade {
    
    private final ReviewRepository reviewRepository;

    public Review addReview(Review review){
        return reviewRepository.save(review);
    }

}
