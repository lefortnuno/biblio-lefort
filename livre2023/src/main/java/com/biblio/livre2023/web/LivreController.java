package com.biblio.livre2023.web;

import com.biblio.livre2023.entities.Livre;
import com.biblio.livre2023.repositories.LivreRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivreController {
    LivreRepository livreRepository;

    public  LivreController(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    @GetMapping("/livres")
    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    @GetMapping("/livres/{id}")
    public Livre getLivreById(@PathVariable Long id) {
        return livreRepository.findById(id).get();
    }

    @PostMapping("/livres")
    public Livre createLivre(@RequestBody Livre livre) {
        return livreRepository.save(livre);
    }

    @PutMapping("/livres/{id}")
    public Livre updateLivre(@PathVariable Long id, @RequestBody Livre livre) {
        Livre p = livreRepository.findById(id).get();
        BeanUtils.copyProperties(livre, p);
        livreRepository.save(p);
        return p;
    }

    @DeleteMapping("/livres/{id}")
    public void deleteLivre(@PathVariable Long id) {
        livreRepository.deleteById(id);
    }
}
