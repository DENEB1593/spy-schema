package io.dev.deneb;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.assertj.core.api.Assertions.*;

class DBContainerTest extends DBContainer {

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
