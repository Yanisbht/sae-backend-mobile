package com.mmi.sae.controller;

import com.mmi.sae.entity.Sae;
import com.mmi.sae.service.SaeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/saes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SaeController {

    private final SaeService saeService;

    @GetMapping
    public List<Sae> getAll() { return saeService.getAll(); }

    @GetMapping("/{id}")
    public Sae getById(@PathVariable Long id) { return saeService.getById(id); }

    @GetMapping("/annee/{annee}")
    public List<Sae> getByAnnee(@PathVariable String annee) { return saeService.getByAnnee(annee); }

    @GetMapping("/domaine/{domaine}")
    public List<Sae> getByDomaine(@PathVariable String domaine) { return saeService.getByDomaine(domaine); }

    @GetMapping("/classement")
    public List<Sae> getClassement() { return saeService.getClassementByNote(); }

    @PostMapping
    public ResponseEntity<Sae> create(@RequestBody Sae sae) {
        return ResponseEntity.ok(saeService.save(sae));
    }
}