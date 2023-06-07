package io.dev.deneb;

import io.dev.deneb.repo.UserRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.assertj.core.api.Assertions.*;

class DBContainerTest extends DBContainer {

    @Autowired
    private TransactionTemplate transactionTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TestRestTemplate rest;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void beforeEach() {
        transactionTemplate.executeWithoutResult(
                status -> DBUtil.cleanDB(jdbcTemplate)
        );
    }



    @Autowired
    private Environment env;

    @Test
    @SneakyThrows
    void connectionTest() {
        Connection connection = DriverManager.getConnection(
                env.getProperty("spring.datasource.url"),
                env.getProperty("spring.datasource.username"),
                env.getProperty("spring.datasource.password")
        );

        assertThat(connection).isNotNull();
    }
}
