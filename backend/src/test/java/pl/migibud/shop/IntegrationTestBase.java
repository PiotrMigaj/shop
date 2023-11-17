package pl.migibud.shop;

import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;


public abstract class IntegrationTestBase {

    @AfterEach
    void cleanUpDB(@Autowired JdbcTemplate jdbcTemplate) {
        JdbcTestUtils.deleteFromTables(
            jdbcTemplate,
            "CART",
            "CART_ITEM",
            "CATEGORY",
            "PRODUCT",
            "REVIEW"
        );
    }

}
