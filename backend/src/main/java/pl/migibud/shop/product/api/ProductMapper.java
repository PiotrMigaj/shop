package pl.migibud.shop.product.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.migibud.shop.review.api.Review;
import pl.migibud.shop.review.api.ReviewMapper;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final ReviewMapper reviewMapper;
    public List<ProductDto> map(List<Product> products){
        return products.stream()
                       .map(this::map)
                       .toList();
    }
    public ProductDto map(Product product){
        return ProductDto.builder()
                         .id(product.getId())
                         .name(product.getName())
                         .description(product.getDescription())
                         .price(product.getPrice())
                         .currency(product.getCurrency())
                         .image(product.getImage())
                         .slug(product.getSlug())
                         .build();
    }
    
    public ProductWithReviewDto map(Product product,List<Review> reviews){
        return ProductWithReviewDto.builder()
            .id(product.getId())
            .name(product.getName())
            .categoryId(product.getCategoryId())
            .description(product.getDescription())
            .fullDescription(product.getFullDescription())
            .price(product.getPrice())
            .currency(product.getCurrency())
            .image(product.getImage())
            .slug(product.getSlug())
            .reviews(reviewMapper.map(reviews))
            .build();
    }
}
