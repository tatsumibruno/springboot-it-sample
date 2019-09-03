package tatsumibruno.springboot.it.sample.api.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
        "tatsumibruno.springboot.it.sample.domain.*",
        "tatsumibruno.springboot.it.sample.api.*",
        "tatsumibruno.springboot.it.sample.infra.*"
})
@EnableJpaRepositories(basePackages = "tatsumibruno.springboot.it.sample.infra.*")
@EntityScan(basePackages = "tatsumibruno.springboot.it.sample.domain.*")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
