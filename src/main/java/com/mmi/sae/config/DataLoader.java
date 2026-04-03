package com.mmi.sae.config;

import com.mmi.sae.entity.Groupe;
import com.mmi.sae.entity.Sae;
import com.mmi.sae.repository.GroupeRepository;
import com.mmi.sae.repository.SaeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final SaeRepository saeRepository;
    private final GroupeRepository groupeRepository;

    @Override
    public void run(String... args) {

        // ======= SAE 303 - MMI2 =======
        List<String[]> data303 = List.of(
                new String[]{"ADJAOUD Rayane", "13.75"},
                new String[]{"HUANG Patrick", "11.75"},
                new String[]{"NIEWIDZIALA-BECKER Zoran", "11.75"},
                new String[]{"LOUBARESSE Victor", "13.0"},
                new String[]{"LUFUNDU Océane", "9.75"},
                new String[]{"BOREL Maïlys", "9.25"},
                new String[]{"MONNERAT Maxime", "10.5"},
                new String[]{"DA COSTA Timéo", "17.0"},
                new String[]{"GADAGNI Soumiyya", "17.25"},
                new String[]{"JANVIER Charly", "17.0"},
                new String[]{"TREFFAULT Axel", "17.0"},
                new String[]{"MORANCY Manon", "5.25"},
                new String[]{"ONESTAS Radji", "5.25"},
                new String[]{"MAUDET Dylan", "5.25"},
                new String[]{"MOYEUX Dorian", "5.25"},
                new String[]{"GÜNDEM Enes", "15.25"},
                new String[]{"PICARD-ALVAREZ Erwan", "15.5"},
                new String[]{"ROBERT Lucas", "15.25"},
                new String[]{"ABDI Enzo", "17.75"},
                new String[]{"CORPET Kilian", "13.25"},
                new String[]{"THEVIN Alexis", "13.0"},
                new String[]{"LACHAB Imène", "14.25"},
                new String[]{"GERANCE Lény", "14.75"},
                new String[]{"PARADIS Jérémy", "10.25"},
                new String[]{"GIROUX Benjamin", "10.25"},
                new String[]{"SAIDJ Sofiane", "14.0"},
                new String[]{"YO KING CHUEN Darel", "10.25"},
                new String[]{"REDOT Naël", "10.25"},
                new String[]{"LAUDET Mathieu", "15.0"},
                new String[]{"JOUAN Gregoire", "14.75"},
                new String[]{"GOSMAT Adam", "14.5"},
                new String[]{"FARRUGGIA Maxime", "14.5"},
                new String[]{"DERENNES Maxime", "17.75"},
                new String[]{"TOCQUEVILLE Joachim", "12.5"},
                new String[]{"CHISIU Sébastien", "16.25"},
                new String[]{"DRAME Ibrahim", "13.0"},
                new String[]{"CHOUDJAY Dylan", "11.5"},
                new String[]{"SAVOURIN Thomas", "11.75"},
                new String[]{"GUIDDIR Naïm", "11.25"},
                new String[]{"CHUPIN Nathan", "11.0"},
                new String[]{"COSTE Maxence", "16.25"},
                new String[]{"RABARIJAONA Samuel", "15.75"},
                new String[]{"GUESNON Clément", "5.0"},
                new String[]{"DELEN Corentin", "15.75"},
                new String[]{"SAMOURA Diaba", "15.75"},
                new String[]{"ADMI Séfora", "11.0"},
                new String[]{"GILET Amel", "15.5"},
                new String[]{"LEBRETON Laura", "14.0"},
                new String[]{"LUYEYE POLYDOR Nelly", "10.5"},
                new String[]{"BOULLARD Raphaël", "14.5"},
                new String[]{"KADI Wassim", "11.5"},
                new String[]{"SIMON-JEAN Leana", "11.5"},
                new String[]{"MARTON Eliot", "11.5"},
                new String[]{"FLEURY Noa", "14.0"},
                new String[]{"ANDOUARD Liam", "13.25"},
                new String[]{"BOUQUET Ethan", "14.25"},
                new String[]{"JEULAND Enzo", "13.25"},
                new String[]{"TRELLE Florian", "13.25"}
        );

        for (String[] entry : data303) {
            Groupe groupe = Groupe.builder()
                    .nom(entry[0])
                    .annee("MMI2")
                    .membres(List.of(entry[0]))
                    .build();
            groupeRepository.save(groupe);

            double note = Double.parseDouble(entry[1]);
            Sae sae = Sae.builder()
                    .titre("SAE 303 - " + entry[0])
                    .annee("MMI2")
                    .semestre("S3")
                    .domaine("Web")
                    .ue("UE3")
                    .description("Réalisation d'un site web dans le cadre de la SAE 303 — BUT MMI Meaux. Ce projet met en œuvre les compétences de développement web, d'intégration et de conception UI/UX.")
                    .note(note)
                    .tauxReussite(note >= 10 ? 100.0 : 0.0)
                    .dateDebut(LocalDate.of(2024, 9, 2))
                    .dateFin(LocalDate.of(2024, 12, 20))
                    .competences(List.of(
                            "Développer pour le web",
                            "Intégrer des contenus",
                            "Concevoir un produit ou un service interactif",
                            "Travailler en mode projet"
                    ))
                    .groupe(groupe)
                    .build();
            saeRepository.save(sae);
        }

        // ======= SAE 501 - MMI3 =======
        List<String[]> data501 = List.of(
                new String[]{"BEN BOUBAKER", "Sheinez", "10.05"},
                new String[]{"BAL", "Zeinabou", "13.05"},
                new String[]{"HOUNSOU", "Markhus", "12.3"},
                new String[]{"MHOUMADI", "Makine", "10.8"},
                new String[]{"BUHOT", "Yanis", "12.0"},
                new String[]{"CHAPUT", "Théo", "12.375"},
                new String[]{"HAMON", "Alexandre", "13.125"},
                new String[]{"VANDELET", "Marin", "15.0"},
                new String[]{"CHTIOUI", "Ibtissem", "13.45"},
                new String[]{"GONCALVES", "Hugo Vitor", "11.7"},
                new String[]{"PEREIRA", "Ruben", "11.7"},
                new String[]{"MAHJOUB", "Assia", "10.7"},
                new String[]{"KONATE", "Hamed", "10.65"},
                new String[]{"KECKET-BAKER", "Trystan", "10.4"},
                new String[]{"MANSOIBOU", "Warrick", "10.4"},
                new String[]{"CHEURFA", "Liam", "15.05"},
                new String[]{"BRUSA", "Joris", "11.3"},
                new String[]{"CARPENTIER", "Timothé", "13.05"},
                new String[]{"ZAIEM", "Sarah", "12.75"},
                new String[]{"BROUILLARD", "Thilya", "11.75"},
                new String[]{"BUISSET", "Nicolas", "15.25"},
                new String[]{"THIABAS HOULAI", "Keyla", "10.95"},
                new String[]{"EDDABACHI", "Younes", "10.45"},
                new String[]{"KOUASSI", "Emmanuel", "11.7"},
                new String[]{"PEREZ SANCHEZ", "John", "12.2"},
                new String[]{"THEVAKUMAR", "Aathavan", "15.55"},
                new String[]{"VIGNESWARAN", "Abi", "11.8"},
                new String[]{"SALAOUDINE", "Saffana", "13.8"},
                new String[]{"BAER", "Oscar", "12.55"},
                new String[]{"LAWSON", "Killian", "13.275"},
                new String[]{"VEOPRASEUTH", "Nolan", "10.9"},
                new String[]{"ZENATI", "Mehdi", "12.65"},
                new String[]{"PREVOST", "Adrien", "14.15"},
                new String[]{"VASANTHAN", "Luxchan", "11.55"},
                new String[]{"KRISHNAKUMAR", "Abeeschan", "12.8"},
                new String[]{"ANTUNES", "Enzo", "10.8"},
                new String[]{"RANNOU", "Nicolas", "10.3"},
                new String[]{"BALDINETTI", "Mattéo", "15.95"},
                new String[]{"DINH", "Ken", "18.7"},
                new String[]{"ROURE", "Vincent", "15.45"},
                new String[]{"SEGHIRI", "Marwan", "13.45"},
                new String[]{"CAMELIN", "Yannis", "14.05"},
                new String[]{"RAKOTOMAVO", "Mathias", "13.8"},
                new String[]{"SOM", "Yohan", "15.175"},
                new String[]{"LOPERE", "Alexandre", "13.55"}
        );

        for (String[] entry : data501) {
            String nom = entry[0] + " " + entry[1];
            Groupe groupe = Groupe.builder()
                    .nom(nom)
                    .annee("MMI3")
                    .membres(List.of(nom))
                    .build();
            groupeRepository.save(groupe);

            double note = Double.parseDouble(entry[2]);
            Sae sae = Sae.builder()
                    .titre("SAE 501 - " + nom)
                    .annee("MMI3")
                    .semestre("S5")
                    .domaine("Développement")
                    .ue("UE5")
                    .description("Réalisation d'un projet de développement dans le cadre de la SAE 501 — BUT MMI Meaux. Ce projet mobilise les compétences avancées en développement web et dispositifs interactifs.")
                    .note(note)
                    .tauxReussite(note >= 10 ? 100.0 : 0.0)
                    .dateDebut(LocalDate.of(2025, 9, 1))
                    .dateFin(LocalDate.of(2026, 1, 31))
                    .competences(List.of(
                            "Développer en équipe",
                            "Concevoir une architecture technique",
                            "Gérer un projet en autonomie",
                            "Déployer une application web",
                            "Rédiger une documentation technique"
                    ))
                    .groupe(groupe)
                    .build();
            saeRepository.save(sae);
        }

        System.out.println("✅ DataLoader : SAE 303 et 501 chargées avec toutes les infos !");
    }
}