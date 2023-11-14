package pl.migibud.shop.category.adapter.secondary;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import pl.migibud.shop.category.domain.model.Category;
import pl.migibud.shop.category.domain.vo.CategoryId;

@Mapper
interface CategoryEntityMapper {

    CategoryEntityMapper INSTANCE = Mappers.getMapper(CategoryEntityMapper.class);

    @Mapping(target = "products", ignore = true)
    @Mapping(target = "categoryId", source = "id", qualifiedByName = "mapToCategoryId")
    Category mapWithoutProducts(CategoryEntity categoryEntity);

    @Named("mapToCategoryId")
    default CategoryId mapToCategoryId(Long id) {
        return CategoryId
            .builder()
            .id(id)
            .build();
    }
}
