CREATE TABLE Passager (
    Num_cl INTEGER PRIMARY KEY,
    Nom_Ps VARCHAR(20) NOT NULL,
    Prenom_Ps VARCHAR(20) NOT NULL,
    Email_Ps VARCHAR(50) NOT NULL,
    password_Ps VARCHAR(50) NOT NULL,
    Num_tel INTEGER,
    nome_utilisateur_ad VARCHAR2(150),
    FOREIGN KEY(nome_utilisateur_ad)
    REFERENCES administrateur_V(nome_utilisateur)
 );

CREATE TABLE administrateur_V
(
    nome_utilisateur VARCHAR2(150) PRIMARY KEY,
    nome VARCHAR2(50) NOT NULL,
    prenom VARCHAR2(50) NOT NULL,
    email VARCHAR2(50) NOT NULL,
    password VARCHAR2(50) NOT NULL
    
);

CREATE TABLE Destination(
    Code_d INTEGER PRIMARY KEY,
    Ville_ds VARCHAR(20)  NOT NULL,
    nome_utilisateur_ad VARCHAR2(150),
    FOREIGN KEY(nome_utilisateur_ad)
    REFERENCES administrateur_V(nome_utilisateur)
);



CREATE TABLE Bus(
    N_immutraculation INTEGER PRIMARY KEY,
    Marque VARCHAR(20) NOT NULL,
    Model VARCHAR(20) NOT NULL,
    Nombre_place INTEGER,
    nome_utilisateur_ad VARCHAR2(150),
    FOREIGN KEY(nome_utilisateur_ad)
    REFERENCES administrateur_V(nome_utilisateur)

);



CREATE TABLE Adress(
    Nemuro_ad INTEGER PRIMARY KEY,
    Nom_rue VARCHAR(20) NOT NULL,
    Ville_ad VARCHAR (20) NOT NULL,
    Code_postal INTEGER NOT NULL
    nome_utilisateur_ad VARCHAR2(150),
    FOREIGN KEY(nome_utilisateur_ad)
    REFERENCES administrateur_V(nome_utilisateur)
);



CREATE TABLE Voyage (
    Code_v INTEGER PRIMARY KEY,
    date_d TIMESTAMP NOT NULL,
    duree  INTEGER,
    N_immutraculation INTEGER,
    FOREIGN KEY (N_immutraculation) REFERENCES bus (N_immutraculation)  ON DELETE CASCADE 
    nome_utilisateur_ad VARCHAR2(150),
    FOREIGN KEY(nome_utilisateur_ad)
    REFERENCES administrateur_V(nome_utilisateur)

);



CREATE TABLE Effectuer(
    Periode_eff INTEGER,
    Num_cl INTEGER,
    FOREIGN KEY (Num_cl ) REFERENCES Passager(Num_cl) ON DELETE CASCADE,
    Code_v INTEGER,
    FOREIGN KEY (Code_v ) REFERENCES Voyage (Code_v ) ON DELETE CASCADE, 
    PRIMARY KEY(Num_cl,Code_v));




CREATE TABLE Constituer(
    Duree_s INTEGER,
    Code_v INTEGER,
    FOREIGN KEY (Code_v ) REFERENCES Voyage (Code_v )  ON DELETE CASCADE,
    Code_d INTEGER,
    FOREIGN KEY (Code_d ) REFERENCES Destination(Code_d )  ON DELETE CASCADE, 
    PRIMARY KEY(Code_v ,Code_d ));



CREATE TABLE Chauffeur(
    N_securite INTEGER PRIMARY KEY,
    Nom_Chf VARCHAR(20) NOT NULL,
    Prenom_Chf VARCHAR(20) NOT NULL,
    Nemuro_ad INTEGER,
    FOREIGN KEY (Nemuro_ad) REFERENCES Adress(Nemuro_ad) ON DELETE CASCADE
    nome_utilisateur_ad VARCHAR2(150),
    FOREIGN KEY(nome_utilisateur_ad)
    REFERENCES administrateur_V(nome_utilisateur)
);



CREATE TABLE Conduire(
    Distance NUMBER(33,3),
    N_securite INTEGER,
    FOREIGN KEY (N_securite) REFERENCES Chauffeur(N_securite)  ON DELETE CASCADE,
    N_immutraculation INTEGER,
    FOREIGN KEY(N_immutraculation ) REFERENCES Bus (N_immutraculation )  ON DELETE CASCADE, 
    PRIMARY KEY(N_securite ,N_immutraculation ),
    N_SECURITE2 INTEGER,FOREIGN KEY (N_SECURITE2) REFERENCES Chauffeur(N_securite)  ON DELETE CASCADE
);



CREATE TABLE Accident(
    Cle_a INTEGER PRIMARY KEY,
    Annee INTEGER ,
    N_accident INTEGER,
    N_securite INTEGER,
    FOREIGN KEY (N_securite ) REFERENCES Chauffeur (N_securite )  ON DELETE CASCADE);



CREATE TABLE Telephone(
    N_Telephone INTEGER PRIMARY KEY,
    N_securite INTEGER,
    FOREIGN KEY (N_securite ) REFERENCES Chauffeur (N_securite ) ON DELETE CASCADE
    nome_utilisateur_ad VARCHAR2(150),
    FOREIGN KEY(nome_utilisateur_ad)
    REFERENCES administrateur_V(nome_utilisateur)
);



