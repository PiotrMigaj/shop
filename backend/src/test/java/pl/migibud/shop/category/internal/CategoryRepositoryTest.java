package pl.migibud.shop.category.internal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.migibud.shop.category.api.Category;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Test
    void shouldJoinFetch(){
        Category category = categoryRepository.findBySlug("inne");
        log.info("Got category: {}",category);
    }
  
}