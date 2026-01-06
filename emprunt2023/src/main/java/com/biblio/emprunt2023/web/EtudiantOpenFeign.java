package com.biblio.emprunt2023.web;

import com.biblio.emprunt2023.modele.Etudiant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ETUDIANT2023")
public interface EtudiantOpenFeign {
    @GetMapping("/etudiants")
    public List<Etudiant> getAllEtudiants();
    @GetMapping("/etudiants/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id);
}
