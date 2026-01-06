package com.biblio.livre2023.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Builder
public class Livre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivre;
    private String libelle;
    private String description; 
}
