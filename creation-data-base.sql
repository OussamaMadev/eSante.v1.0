-- creation-data-base
-- data base for home haelth facility manag system

CREATE TABLE employes (
    code INT AUTO_INCREMENT,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    secteur ENUM('médical', 'paramédical') NOT NULL,
    anciennete INT,
    specialite VARCHAR(50),
    constraint PK_employes primary key (code)
);

CREATE TABLE patients (
    nss INT AUTO_INCREMENT,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    date_naissance DATE,
    adresse VARCHAR(255),
    telephone VARCHAR(20),
    email VARCHAR(255),
    constraint PK_patients primary key (nss)
);

CREATE TABLE reservations (
    numero INT AUTO_INCREMENT,
    date_resa DATETIME,
    date_dePrend date DEFAULT sysdate,
    type_resa ENUM('médicale', 'paramédicale') NOT NULL,
    service_resa ENUM('injection', 'changement_pansements', 'prise_tension', 'consultation') NOT NULL,
    descRes VARCHAR(1000),
    nss_patient INT NOT NULL,
    code_employe INT NOT NULL,

    constraint PK_reservations primary key (numero),
    constraint fk_reservaions_patients FOREIGN KEY (nss_patient) REFERENCES patients(nss),
    constraint fk_reservaion_employes FOREIGN KEY (code_employe) REFERENCES employes(code)
);

CREATE TABLE consultations (
    id_consultation INT AUTO_INCREMENT,
    
    resultat VARCHAR(255),
    traitement VARCHAR(255),
    recommandation VARCHAR(255),
    
    -- FEEDBACK patient
    notQualite INTEGER CHECK(ad >= 0 AND ad <= 10),
    notPonctualite INTEGER CHECK(ad >= 0 AND ad <= 10),

    
    numero_resa INT NOT NULL,
    
    constraint PK_consultations primary key (id_consultation)  
    constraint fk_consultations_reservations FOREIGN KEY (numero_resa) REFERENCES reservations(numero)
);


CREATE TABLE DemandeAnnulationMed (
    id INT not NULL AUTO_INCREMENT,
    demandeDE ENUM ('respo','employe') not null,
    
    raison VARCHAR(255),
    
    numero_resa INT NOT NULL,  
    constraint fk_consultations_reservations FOREIGN KEY (numero_resa) REFERENCES reservations(numero)
);
