package pl.migibud.shop.category.application.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pl.migibud.shop.category.application.port.primary.CategoryWithProductsQueryModel;
import pl.migibud.shop.category.application.port.primary.ProductsQueryModel;
import pl.migibud.shop.category.domain.model.Category;
import pl.migibud.shop.category.domain.model.Product;

import java.util.List;

@Mapper
interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    default CategoryWithProductsQueryModel map(Category category, Page<Product> products, Pageable pageable){
        return CategoryWithProductsQueryModel.builder()
            .categoryId(category.getCategoryId().id())
            .name(category.getName())
            .description(category.getDescription())
            .slug(category.getSlug())
            .products(new PageImpl<>(map(products.getContent()),pageable,products.getTotalElements()))
                                             .build();
    }
    
    private ProductsQueryModel map(Product product){
        return ProductsQueryModel.builder()
            .productId(product.getProductId().id())
            .name(product.getName())
            .description(product.getDescription())
            .fullDescription(product.getFullDescription())
            .price(product.getPrice())
            .currency(product.getCurrency())
            .image(product.getImage())
            .slug(product.getSlug())
                                 .build();
    }
    
    private List<ProductsQueryModel> map(List<Product> products){
        return products.stream()
            .map(this::map)
            .toList();
    }
    
    
    
}
