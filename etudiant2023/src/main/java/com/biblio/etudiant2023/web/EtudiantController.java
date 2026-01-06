package com.biblio.etudiant2023.web;

import com.biblio.etudiant2023.entities.Etudiant;
import com.biblio.etudiant2023.repositories.EtudiantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EtudiantController {
    EtudiantRepository etudiantRepository;

    public  EtudiantController(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @GetMapping("/etudiants")
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @GetMapping("/etudiants/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id) {
        return etudiantRepository.findById(id).get();
    }

    @PostMapping("/etudiants")
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @PutMapping("/etudiants/{id}")
    public Etudiant updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        Etudiant clt = etudiantRepository.findById(id).get();
        BeanUtils.copyProperties(etudiant, clt);
        etudiantRepository.save(clt);
        return clt;
    }

    @DeleteMapping("/etudiants/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantRepository.deleteById(id);
    }
}
