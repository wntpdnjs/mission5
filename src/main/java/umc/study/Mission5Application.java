package umc.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing

@EntityScan("umc.study.domain")
@SpringBootApplication
public class Mission5Application {

    public static void main(String[] args) {
        SpringApplication.run(Mission5Application.class, args);
    }

}
