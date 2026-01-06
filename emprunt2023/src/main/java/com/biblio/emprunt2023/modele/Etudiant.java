package com.biblio.emprunt2023.modele;

import lombok.*;

@Setter @Getter @ToString @NoArgsConstructor @AllArgsConstructor
public class Etudiant {
    private Long idEtudiant;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}
