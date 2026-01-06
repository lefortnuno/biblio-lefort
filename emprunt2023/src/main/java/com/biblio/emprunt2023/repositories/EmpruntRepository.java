package com.biblio.emprunt2023.repositories;

import com.biblio.emprunt2023.entities.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
}
