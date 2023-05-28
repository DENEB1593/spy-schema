package io.dev.deneb;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ContextConfiguration;
import io.dev.deneb.DBContainer.Initializer;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.lifecycle.Startables;

import java.util.Map;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration(initializers = Initializer.class)
class DBContainer {

    public static final Network NETWORK = Network.newNetwork();

    private static final MariaDBContainer<?> MARIADB =
            new MariaDBContainer<>("mariadb:10.6.13")
                    .withNetworkAliases("mariadb")
                    .withNetwork(NETWORK);

    static class Initializer implements
            ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext context) {
            Startables.deepStart(MARIADB).join();

            context.getEnvironment()
                    .getPropertySources()
                    .addFirst(new MapPropertySource(
                            "testcontainers",
                            Map.of(
                                    "spring.datasource.url", MARIADB.getJdbcUrl(),
                                    "spring.datasource.username", MARIADB.getUsername(),
                                    "spring.datasource.password", MARIADB.getPassword()
                            )
                    ));
        }
    }
}
