SELECT * FROM Profesori
WHERE godine > 45;

SELECT ime, prezime FROM Ucenici
WHERE godine > 15 AND prosek > 6.5;

SELECT * FROM Ucenici
ORDER BY godine DESC;

SELECT * FROM profesori
WHERE predmet = 'Informatika';

SELECT ucenikid, ime, prezime FROM ucenici
WHERE length(ime)=6;
