package com.mmi.sae.repository;

import com.mmi.sae.entity.Sae;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SaeRepository extends JpaRepository<Sae, Long> {
    List<Sae> findByAnnee(String annee);
    List<Sae> findByDomaine(String domaine);
    List<Sae> findAllByOrderByNoteDesc();
}