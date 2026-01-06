package com.biblio.livre2023;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.biblio.livre2023.entities.Livre;
import com.biblio.livre2023.repositories.LivreRepository;
import com.biblio.livre2023.web.LivreController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Livre2023Application {

	public static void main(String[] args) {
		SpringApplication.run(Livre2023Application.class, args);
	}

    @Bean
    CommandLineRunner run(LivreRepository livreRepository) {
        return args -> {
            Livre c1 = Livre
                    .builder()
                    .libelle("La belle et La bete")
                    .description("Romance de contees de fee") 
                    .build();
            livreRepository.save(c1);

            Livre c2 = Livre
                    .builder()
                    .libelle("Math")
                    .description("Etude des calculs et theoreme") 
                    .build();
            livreRepository.save(c2);

            Livre c3 = Livre
                    .builder()
                    .libelle("Jean Jack est mechant")
                    .description("Avanture de Jack") 
                    .build();
            livreRepository.save(c3);
        };
    }
}
