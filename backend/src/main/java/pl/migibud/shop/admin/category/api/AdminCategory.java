package pl.migibud.shop.admin.category.api;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.migibud.shop.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AdminCategory extends BaseEntity {

    private String name;
    private String description;
    private String slug;

    @Builder
    public AdminCategory(Long id, String name, String description, String slug) {
        super(id);
        this.name = name;
        this.description = description;
        this.slug = slug;
    }
}
