package com.biblio.emprunt2023.web;

import com.biblio.emprunt2023.modele.Livre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("LIVRE2023")
public interface LivreOpenFeign {
    @GetMapping("/livres")
    public List<Livre> getAllLivres();
    @GetMapping("/livres/{id}")
    public Livre getLivreById(@PathVariable Long id);
}
