package pl.migibud.shop.product.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.migibud.shop.product.api.Product;
import pl.migibud.shop.product.api.ProductDto;
import pl.migibud.shop.product.api.ProductMapper;
import pl.migibud.shop.product.api.ProductWithReviewDto;
import pl.migibud.shop.review.api.Review;
import pl.migibud.shop.review.api.ReviewQueryRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
class ProductFacade {

    private final ProductOldRepository productOldRepository;
    private final ProductMapper productMapper;
    private final ReviewQueryRepository reviewQueryRepository;

    Page<ProductDto> getProducts(Pageable pageable){
        Page<Product> products = productOldRepository.findAll(pageable);
        return new PageImpl<>(
            productMapper.map(products.getContent()),
            pageable,
            products.getTotalElements()
        );
    }

    @Transactional(readOnly = true)
    public ProductWithReviewDto getProduct(String slug){
        Product product = productOldRepository
            .findBySlug(slug)
            .orElseThrow(() -> new NoSuchElementException("There is no product with slug: '%s'".formatted(slug)));
        List<Review> reviews = reviewQueryRepository.findAllByProductIdAndModerated(product.getId(),
            true);
        return productMapper.map(product,reviews);
    }
    
}
