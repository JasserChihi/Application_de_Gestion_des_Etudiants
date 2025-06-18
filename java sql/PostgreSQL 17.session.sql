CREATE TABLE Etudiant (
    IdEtd VARCHAR(50) PRIMARY KEY,
    Nom VARCHAR(50),
    Prenom VARCHAR(50),
    Adresse VARCHAR(255),
    Section VARCHAR(50)
);

CREATE TABLE Cours (
    codeCours VARCHAR(50) PRIMARY KEY,
    nomCours VARCHAR(50) NOT NULL,
    numSalle VARCHAR(50),
    coef NUMERIC
);

CREATE TABLE Professeur (
    idProf VARCHAR(50) PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    idDep VARCHAR(50)
);

CREATE TABLE Inscription (
    idEtd VARCHAR(50),
    codeCours VARCHAR(50),
    PRIMARY KEY (idEtd, codeCours),
    FOREIGN KEY (idEtd) REFERENCES Etudiant(idEtd),
    FOREIGN KEY (codeCours) REFERENCES Cours(codeCours)
);

CREATE TABLE Enseignement (
    idProf VARCHAR(50),
    codeCours VARCHAR(50),
    PRIMARY KEY (idProf, codeCours),
    FOREIGN KEY (idProf) REFERENCES Professeur(idProf),
    FOREIGN KEY (codeCours) REFERENCES Cours(codeCours)
);
