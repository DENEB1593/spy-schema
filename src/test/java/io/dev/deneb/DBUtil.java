package io.dev.deneb;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.List;

public class DBUtil {

    private static final List<String> TABLES = List.of(
            "post",
            "users"
    );

    public static void cleanDB(JdbcTemplate jdbcTemplate) {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, TABLES.toArray(String[]::new));
    }


}
