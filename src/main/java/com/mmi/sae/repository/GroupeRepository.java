package com.mmi.sae.repository;

import com.mmi.sae.entity.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {
    List<Groupe> findByAnnee(String annee);
}