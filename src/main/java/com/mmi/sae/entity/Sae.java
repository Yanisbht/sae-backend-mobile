package com.mmi.sae.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String semestre;
    private String annee;
    private String domaine;
    private String ue;

    @Column(length = 1000)
    private String description;

    private Double note;
    private Double tauxReussite;

    private LocalDate dateDebut;
    private LocalDate dateFin;

    private String lienSite;
    private String lienCode;

    @ElementCollection
    private List<String> images;

    @ElementCollection
    private List<String> competences;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "groupe_id")
    private Groupe groupe;
}