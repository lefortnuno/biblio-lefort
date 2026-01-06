package com.biblio.etudiant2023;

import com.biblio.etudiant2023.config.GlobalConfig; 
import com.biblio.etudiant2023.entities.Etudiant;
import com.biblio.etudiant2023.repositories.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Etudiant2023Application {

	public static void main(String[] args) {
		SpringApplication.run(Etudiant2023Application.class, args);
	}

    @Bean
    CommandLineRunner run(EtudiantRepository etudiantRepository) {
        return args -> {
            Etudiant std1 = Etudiant.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .email("Johndoe@gmail.com")
                    .age(25)
                    .build();
            etudiantRepository.save(std1);

            Etudiant std2 = Etudiant.builder()
                    .firstName("Saad")
                    .lastName("Mohamed")
                    .email("Saadmohammed@gmail.com")
                    .age(18)
                    .build();
            etudiantRepository.save(std2);

            Etudiant std3 = Etudiant.builder()
                    .firstName("Widad")
                    .lastName("Mohammed")
                    .email("widadmohamed@gmail.com")
                    .age(35)
                    .build();
            etudiantRepository.save(std3);
        };
    }

}
