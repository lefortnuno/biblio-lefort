package com.biblio.etudiant2023.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Builder
public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idEtudiant;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}
