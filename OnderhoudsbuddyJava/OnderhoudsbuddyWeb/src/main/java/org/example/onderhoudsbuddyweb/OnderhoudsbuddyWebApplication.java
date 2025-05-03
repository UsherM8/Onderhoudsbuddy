package org.example.onderhoudsbuddyweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
        "org.example.onderhoudsbuddybusiness",
        "org.example.onderhoudsbuddydal",
        "org.example.onderhoudsbuddydomain",
        "org.example.onderhoudsbuddyweb"
})
@EnableJpaRepositories(basePackages = "org.example.onderhoudsbuddydal.Repositories")
@EntityScan(basePackages = "org.example.onderhoudsbuddydal.Entities")
public class OnderhoudsbuddyWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnderhoudsbuddyWebApplication.class, args);
    }

}
