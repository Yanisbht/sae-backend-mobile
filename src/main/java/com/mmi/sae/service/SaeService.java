package com.mmi.sae.service;

import com.mmi.sae.entity.Sae;
import com.mmi.sae.repository.SaeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaeService {

    private final SaeRepository saeRepository;

    public List<Sae> getAll()                     { return saeRepository.findAll(); }
    public List<Sae> getByAnnee(String annee)     { return saeRepository.findByAnnee(annee); }
    public List<Sae> getByDomaine(String domaine) { return saeRepository.findByDomaine(domaine); }
    public List<Sae> getClassementByNote()        { return saeRepository.findAllByOrderByNoteDesc(); }
    public Sae getById(Long id)                   { return saeRepository.findById(id).orElseThrow(); }
    public Sae save(Sae sae)                      { return saeRepository.save(sae); }
}