-- creation-data-base
-- data base for home haelth facility manag system

CREATE SEQUENCE employes_seq START WITH 43529 INCREMENT BY 1
/

CREATE TABLE employes (
    code INT DEFAULT employes_seq.NEXTVAL PRIMARY KEY,
    nom VARCHAR2(50) NOT NULL,
      prenom VARCHAR2(50) NOT NULL,
    secteur VARCHAR2(20) CHECK(secteur IN ('medical', 'paramedical')) NOT NULL,
    anciennete INT,
    specialite VARCHAR2(50)
)
/


CREATE TABLE patients (
    nss INT PRIMARY KEY not null,
    nom VARCHAR2(50) NOT NULL,
    prenom VARCHAR2(50) NOT NULL,
    date_naissance DATE,
    adresse VARCHAR2(255),
    telephone VARCHAR2(20),
    email VARCHAR2(255)
)
/

CREATE SEQUENCE reservations_seq START WITH 43529 INCREMENT BY 1
/

CREATE TABLE reservations (
    numero INT DEFAULT reservations_seq.NEXTVAL PRIMARY KEY,
    date_resa date,
    date_dePrend DATE DEFAULT SYSDATE,
    type_resa VARCHAR2(20) CHECK(type_resa IN ('medicale', 'paramedicale')) NOT NULL,
    service_resa VARCHAR2(50) CHECK(service_resa IN ('injection', 'changement_pansements', 'prise_tension', 'consultation')) NOT NULL,
    descRes VARCHAR2(1000),
    nss INT NOT NULL,
    code INT NOT NULL,
    payed int,
    constraint fk_reservations_patients FOREIGN KEY (nss) REFERENCES patients(nss),
    constraint fk_reservations_employes FOREIGN KEY (code) REFERENCES employes(code)
)
/

CREATE SEQUENCE consultations_seq START WITH 43529 INCREMENT BY 1;

CREATE TABLE consultations (
    id_consultation INT DEFAULT consultations_seq.NEXTVAL PRIMARY KEY,
    resultat VARCHAR2(255),
    traitement VARCHAR2(255),
    recommandation VARCHAR2(255),
    notQualite NUMBER(2,0) CHECK (notQualite >= 0 AND notQualite <= 10),
    notPonctualite NUMBER(2,0) CHECK (notPonctualite >= 0 AND notPonctualite <= 10),
    numero_resa INT NOT NULL,
    CONSTRAINT fk_consultations_reservations FOREIGN KEY (numero_resa) REFERENCES reservations(numero)
)
/

CREATE SEQUENCE demande_annulation_med_seq START WITH 43529 INCREMENT BY 1
/

CREATE TABLE demande_annulation_med (
    id INT DEFAULT demande_annulation_med_seq.NEXTVAL PRIMARY KEY,
    demande_de VARCHAR2(20) CHECK (demande_de IN ('respo','employe')) NOT NULL,
    raison VARCHAR2(255),
    numero_resa INT NOT NULL,
    CONSTRAINT fk_demande_annulation_med_reservations FOREIGN KEY (numero_resa) REFERENCES reservations(numero)
)
/

CREATE TABLE clininfos (
    nom_clinique VARCHAR2(50),
    adresse VARCHAR2(255),
    site_web VARCHAR2(200),
    code_respo INT,
    tel1 NUMBER(10,0),
    tel2 NUMBER(10,0),
    tel3 NUMBER(10,0),
    admin_password INT
)
/
CREATE synonym resArchive for reservations
/