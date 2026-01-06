package com.biblio.emprunt2023.modele;


import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Livre {
    private Long idLivre;
    private String libelle;
    private String description; 
}
