CREATE DATABASE biblioteka;
USE biblioteka;
CREATE TABLE kategoria(
id_kategoria INT PRIMARY KEY,
nazwa_kategorii VARCHAR(100)
);
SELECT * FROM kategoria;
INSERT INTO kategoria VALUES
(1, 'fantastyka'),
(2, 'horror');
DROP TABLE zamowienie;
CREATE TABLE bibliotekarz(
id_bibliotekarz INT PRIMARY KEY,
login VARCHAR(50),
haslo VARCHAR(50)
);
CREATE TABLE administrator(
id_administrator INT PRIMARY KEY,
login VARCHAR(50),
haslo VARCHAR(50)
);
CREATE TABLE ksiazka(
id_ksiazka INT PRIMARY KEY,
id_kategoria INT,
isbn VARCHAR(13),
tytul VARCHAR(100),
autor_imie VARCHAR(50),
autor_nazwisko VARCHAR(50),
wydawnictwo VARCHAR(50),
rok_wydania INT(4),
opis TEXT,
FOREIGN KEY (id_kategoria) REFERENCES kategoria(id_kategoria)
);
CREATE TABLE czytelnik(
id_czytelnik INT PRIMARY KEY,
login VARCHAR(50),
haslo VARCHAR(50),
imie VARCHAR(50),
nazwisko VARCHAR(50),
adres VARCHAR(150),
miasto VARCHAR(40),
kod_pocztowy VARCHAR(6),
telefon VARCHAR(15),
email VARCHAR(50)
);
CREATE TABLE zamowienie(
id_zamowienie INT PRIMARY KEY,
id_ksiazka INT,
id_czytelnik INT,
data_zamowienia DATE,
data_odbioru DATE,
data_zwrotu DATE,
termin_zwrotu DATE,
FOREIGN KEY (id_ksiazka) REFERENCES ksiazka(id_ksiazka),
FOREIGN KEY (id_czytelnik) REFERENCES czytelnik(id_czytelnik)
);
