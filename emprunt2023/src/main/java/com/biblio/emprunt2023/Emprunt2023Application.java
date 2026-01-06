package com.biblio.emprunt2023;

import com.biblio.emprunt2023.entities.Emprunt;
import com.biblio.emprunt2023.repositories.EmpruntRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Emprunt2023Application {

	public static void main(String[] args) {
		SpringApplication.run(Emprunt2023Application.class, args);
	}

    @Bean
    CommandLineRunner run(EmpruntRepository empruntRepository) {
        return args -> {
            Emprunt emprunt11 = Emprunt
                    .builder()
                    .idEtudiant(1L)
                    .idLivre(1L) 
                    .dateEmprunt(LocalDate.of(2025,01,02))
                    .dateRetour(LocalDate.of(2025,01,02))
                    .build();
            empruntRepository.save(emprunt11);
            Emprunt emprunt12 = Emprunt
                    .builder()
                    .idEtudiant(1L)
                    .idLivre(2L)
                    .dateEmprunt(LocalDate.of(2026,02,07))
                    .dateRetour(LocalDate.of(2026,02,07))
                    .build();
            empruntRepository.save(emprunt12);
            Emprunt emprunt13 = Emprunt
                    .builder()
                    .idEtudiant(1L)
                    .idLivre(3L)
                    .dateEmprunt(LocalDate.of(2026,03,10))
                    .dateRetour(LocalDate.of(2026,03,10))
                    .build();
            empruntRepository.save(emprunt13);
 
        };
    }
}
