package com.biblio.etudiant2023.repositories;

import com.biblio.etudiant2023.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
