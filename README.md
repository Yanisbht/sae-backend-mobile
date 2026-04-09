# 🎓 SAé Backend — BUT MMI Meaux

API REST développée avec **Spring Boot** pour gérer la banque des SAé (Situations d'Apprentissage et d'Évaluation) du département MMI de Meaux. Elle est déployée sur **Railway** et consommée par l'application mobile React Native.

---

## 🛠️ Stack technique

| Technologie | Version |
|---|---|
| Java | 17 |
| Spring Boot | 4.0.3 |
| Spring Security | ✅ |
| Spring Data JPA | ✅ |
| MySQL | ✅ |
| JWT (jjwt) | 0.11.5 |
| Lombok | ✅ |
| Maven | ✅ |

---

## 📁 Structure du projet

```
src/main/java/com/mmi/sae/
├── config/
│   ├── DataLoader.java        # Chargement initial des données (SAE 303 & 501)
│   └── SecurityConfig.java    # Configuration Spring Security + filtre JWT
├── controller/
│   ├── AuthController.java    # Endpoint de connexion → génère un token JWT
│   └── SaeController.java     # CRUD et filtres sur les SAé
├── entity/
│   ├── Sae.java               # Entité principale (titre, note, domaine, liens...)
│   └── Groupe.java            # Groupe d'étudiants lié à une SAé
├── repository/
│   ├── SaeRepository.java
│   └── GroupeRepository.java
├── service/
│   ├── SaeService.java
│   └── JwtService.java        # Génération et validation des tokens JWT
└── SaeBackendApplication.java
```

---

## 🔐 Authentification

L'API utilise **JWT (JSON Web Token)**. Seuls les endpoints `GET /api/saes/**` sont publics. Toute écriture nécessite un token.

### Connexion

```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "mmi2026"
}
```

**Réponse :**
```json
{
  "token": "<jwt_token>"
}
```

Inclure le token dans les requêtes protégées :
```
Authorization: Bearer <jwt_token>
```

---

## 📡 Endpoints de l'API

### SAé — `/api/saes`

| Méthode | Route | Auth | Description |
|---|---|---|---|
| GET | `/api/saes` | ❌ | Toutes les SAé |
| GET | `/api/saes/{id}` | ❌ | Détail d'une SAé |
| GET | `/api/saes/annee/{annee}` | ❌ | Filtrer par année (`MMI2` / `MMI3`) |
| GET | `/api/saes/domaine/{domaine}` | ❌ | Filtrer par domaine |
| GET | `/api/saes/classement` | ❌ | Classement par note décroissante |
| POST | `/api/saes` | ✅ | Créer une SAé |

### Auth — `/api/auth`

| Méthode | Route | Description |
|---|---|---|
| POST | `/api/auth/login` | Connexion → retourne un JWT |

---

## 🗃️ Modèle de données

### Entité `Sae`

| Champ | Type | Description |
|---|---|---|
| `id` | Long | Identifiant auto |
| `titre` | String | Intitulé de la SAé |
| `semestre` | String | Ex : `S3`, `S5` |
| `annee` | String | `MMI2` ou `MMI3` |
| `domaine` | String | `Web`, `DI`, `3D`... |
| `ue` | String | Unité d'enseignement |
| `description` | String | Description longue |
| `note` | Double | Note sur 20 |
| `tauxReussite` | Double | Taux de réussite (%) |
| `dateDebut` | LocalDate | Début du projet |
| `dateFin` | LocalDate | Fin du projet |
| `lienSite` | String | URL du site rendu |
| `lienCode` | String | URL du dépôt de code |
| `images` | List\<String\> | URLs des images |
| `competences` | List\<String\> | Compétences mobilisées |
| `groupe` | Groupe | Groupe d'étudiants |

### Entité `Groupe`

| Champ | Type | Description |
|---|---|---|
| `id` | Long | Identifiant auto |
| `nom` | String | Nom du groupe |
| `annee` | String | `MMI2` ou `MMI3` |
| `membres` | List\<String\> | Noms des membres |

---

## ⚙️ Configuration

Créer un fichier `src/main/resources/application.properties` :

```properties
# Base de données MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/sae_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

# JWT
jwt.secret=your_very_long_secret_key_here
jwt.expiration=86400000
```

> En production (Railway), ces variables sont injectées via les variables d'environnement de la plateforme.

---

## 🚀 Lancement en local

### Prérequis

- Java 17+
- Maven
- MySQL (ou base H2 pour les tests)

### Démarrage

```bash
# Cloner le dépôt
git clone <url-du-repo>
cd sae-backend

# Compiler et lancer
mvn spring-boot:run
```

L'API sera disponible sur `http://localhost:8080`.

---

## ☁️ Déploiement

L'API est déployée sur **Railway** :

```
https://sae-backend-mobile-production.up.railway.app
```

Le `DataLoader` pré-charge automatiquement les données des SAE 303 (MMI2) et SAE 501 (MMI3) au démarrage si la base est vide.

---

## 🧪 Tests

```bash
mvn test
```

---

## 👥 Projet

BUT MMI — IUT de Meaux  
Promotion 2026
