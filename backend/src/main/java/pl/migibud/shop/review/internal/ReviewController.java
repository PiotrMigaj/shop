package pl.migibud.shop.review.internal;

import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.migibud.shop.review.api.Review;

import javax.validation.Valid;

@RestController
@RequestMapping("review")
@RequiredArgsConstructor
class ReviewController {
    
    private final ReviewFacade reviewFacade;
    
    @PostMapping
    ResponseEntity<Review> addReview(@RequestBody @Valid ReviewDto reviewDto){
        Review review = reviewFacade.addReview(Review
            .builder()
            .authorName(cleanContent(reviewDto.authorName()))
            .content(cleanContent(reviewDto.content()))
            .productId(reviewDto.productId())
            .build());
        return ResponseEntity.status(HttpStatus.CREATED).body(review);
    }
    
    record ReviewDto(
        @Length(min = 2,max = 60) String authorName, 
        @Length(min = 2,max = 600) String content, 
        Long productId){
    }
    
    private String cleanContent(String text){
        return Jsoup.clean(text, Safelist.none());
    }
}
