package com.biblio.emprunt2023.web;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import com.biblio.emprunt2023.entities.Emprunt;
import com.biblio.emprunt2023.modele.Etudiant; 
import com.biblio.emprunt2023.modele.Livre;
import com.biblio.emprunt2023.repositories.EmpruntRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpruntController {
    EmpruntRepository gardeRepository;
    EtudiantOpenFeign studentOpenFeign;
    LivreOpenFeign livreOpenFeign;

    public EmpruntController(EmpruntRepository gardeRepository,  EtudiantOpenFeign studentOpenFeign, LivreOpenFeign livreOpenFeign) {
        this.gardeRepository = gardeRepository;
        this.studentOpenFeign = studentOpenFeign;
        this.livreOpenFeign = livreOpenFeign;
    }


    @GetMapping("/emprunts")
    public List<Emprunt> findAll() {
        List<Emprunt> emprunts = gardeRepository.findAll();
        List<Etudiant> students = studentOpenFeign.getAllEtudiants();
        List<Livre> livres = livreOpenFeign.getAllLivres();
        for(Emprunt garde : emprunts){
            for(Etudiant student : students){
                if (garde.getIdEtudiant().equals(student.getIdEtudiant())){
                    garde.setEtudiant(student);
                    break;
                }
            }
            for (Livre livre : livres){
                if (garde.getIdLivre().equals(livre.getIdLivre())){
                    garde.setLivre(livre);
                }
            }
        }
        return emprunts;
    }

    @GetMapping("/emprunts/{id}")
    public Emprunt findById(@PathVariable Long id) {
        Emprunt garde = gardeRepository.findById(id).get();
        Etudiant student = studentOpenFeign.getEtudiantById(garde.getIdEtudiant());
        Livre livre = livreOpenFeign.getLivreById(garde.getIdEmprunt());

        garde.setEtudiant(student);
        garde.setLivre(livre);
        return garde;
    }

    @PostMapping("/emprunts")
    public Emprunt save(@RequestBody Emprunt garde) {
        return gardeRepository.save(garde);
    }

    @PutMapping("/emprunts/{id}")
    public Emprunt update(@PathVariable Long id, @RequestBody Emprunt garde) {
        Emprunt cmd = gardeRepository.findById(id).get();
        BeanUtils.copyProperties(garde, cmd);
        gardeRepository.save(cmd);
        return cmd;
    }

    @DeleteMapping("/emprunts/{id}")
    public void deleteById(@PathVariable Long id) {
        gardeRepository.deleteById(id);
    }

}
