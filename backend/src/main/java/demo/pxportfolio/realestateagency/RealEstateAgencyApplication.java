package demo.pxportfolio.realestateagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableJpaAuditing
public class RealEstateAgencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(RealEstateAgencyApplication.class, args);
    }

}
