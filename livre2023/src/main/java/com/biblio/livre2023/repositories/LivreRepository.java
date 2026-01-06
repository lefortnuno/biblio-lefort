package com.biblio.livre2023.repositories;

import com.biblio.livre2023.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, Long> {
}
