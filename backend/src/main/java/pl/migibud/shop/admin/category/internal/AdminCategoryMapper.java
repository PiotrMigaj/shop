package pl.migibud.shop.admin.category.internal;

import com.github.slugify.Slugify;
import org.springframework.stereotype.Component;
import pl.migibud.shop.admin.category.api.AdminCategory;

@Component
class AdminCategoryMapper {

    AdminCategory toAdminCategory(Long id,AdminCategoryDto adminCategoryDto){
        return AdminCategory.builder()
                .id(id)
                .name(adminCategoryDto.name())
                .description(adminCategoryDto.description())
                .slug(slugifySlug(adminCategoryDto.slug()))
                .build();
    }

    AdminCategoryDto toAdminCategoryDto(AdminCategory adminCategory){
        return AdminCategoryDto.builder()
                .name(adminCategory.getName())
                .description(adminCategory.getDescription())
                .slug(adminCategory.getSlug())
                .build();
    }

    private String slugifySlug(String slug){
        Slugify slg = Slugify.builder().customReplacement("_","-").build();
        return slg.slugify(slug);
    }

}
