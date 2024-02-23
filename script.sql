CREATE TABLE Carte (
  id_carte SERIAL PRIMARY KEY,
  couleur VARCHAR(10),
  valeur VARCHAR(10)
);
CREATE TABLE PaquetCarte (
  id_paquet SERIAL PRIMARY KEY,
  taille INT,
  id_carte INT,
  FOREIGN KEY (id_carte) REFERENCES Carte(id_carte)
);
CREATE TABLE Main (
  id_main INT PRIMARY KEY,
  valeurTotal INT,
  nbCartes INT,
  listCartes VARCHAR(1000),
  id_carte INT, 
  FOREIGN KEY (id_carte) REFERENCES Carte(id_carte)
);
CREATE TABLE Joueur (
  id_joueur SERIAL PRIMARY KEY,
  username VARCHAR(50),
  solde INT,
  id_main INT,
  FOREIGN KEY (id_main) REFERENCES Main(id_main)
);

CREATE TABLE Croupier (
  id_croupier SERIAL PRIMARY KEY,
  valeurTotalMlt INT,
  id_main INT,
  FOREIGN KEY (id_main) REFERENCES Main(id_main)
);











CREATE TABLE Croupier (
  id_croupier SERIAL PRIMARY KEY,
  valeurTotalMlt INT,
  id_main INT,
  FOREIGN KEY (id_main) REFERENCES Main(id_main)
);
