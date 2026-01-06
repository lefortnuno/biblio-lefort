package com.biblio.emprunt2023.entities;

import java.time.LocalDate;
import com.biblio.emprunt2023.modele.Etudiant;
import com.biblio.emprunt2023.modele.Livre;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Builder
public class Emprunt {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprunt;
    private Long idLivre;
    @Transient
    private Livre livre;

    private LocalDate dateRetour;
    private LocalDate dateEmprunt;
    private Long idEtudiant;
    @Transient
    private Etudiant etudiant;
}
