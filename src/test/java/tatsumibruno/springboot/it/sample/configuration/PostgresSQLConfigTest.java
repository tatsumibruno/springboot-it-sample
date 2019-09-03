package tatsumibruno.springboot.it.sample.configuration;

import org.junit.ClassRule;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.AbstractTransactionManagementConfiguration;
import org.testcontainers.containers.GenericContainer;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "tatsumibruno.springboot.it.sample.infra.*")
@EntityScan(basePackages = "tatsumibruno.springboot.it.sample.domain.*")
public class PostgresSQLConfigTest extends AbstractTransactionManagementConfiguration {

    @ClassRule
    public static GenericContainer POSTGRES_CONTAINER = new GenericContainer("postgres:9.4");

    static {
        POSTGRES_CONTAINER.start();
    }

}
