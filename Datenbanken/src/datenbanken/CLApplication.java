// CLApplication.java
package datenbanken;

import java.util.ArrayList;

public class CLApplication {

    public static void main(String[] args) {
        // JDBC-URL, Benutzername und Passwort der PostgreSQL-Datenbank
      
        // Schritt 1: Erstellen der Database-Instanz
        Database database = new Database();
        database.setJdbcUrl("jdbc:postgresql://localhost:5432/Vorlesung");
        // Schritt 2: Öffnen der Verbindung zur Datenbank
        database.openConnection();

        // Fügen Sie hier Ihren Code für Datenbankoperationen ein

        // Schritt 3: Schließen der Verbindung zur Datenbank
        // Aufgabe Seite 5 Ausführen von SQL-Statements (ohne Rückgabewert) 
       String createSchemaSQL = "CREATE SCHEMA IF NOT EXISTS neuesSchema";
        String setSchemaSQL = "SET search_path TO neuesSchema";
        String createTableSQL = "CREATE TABLE IF NOT EXISTS neuesSchema.xyz (id SERIAL PRIMARY KEY, name VARCHAR(255))";

        database.dbQuery(createSchemaSQL);
        database.dbQuery(setSchemaSQL);
        database.dbQuery(createTableSQL);
        
        database.dbQuery("CREATE DATABASE praktikum4");
		database.dbQuery("CREATE SCHEMA IF NOT EXISTS versuch4;");
		database.dbQuery("set SEARCH_PATH to versuch4;");
		database.dbQuery("CREATE TABLE mitarbeiter ( mid int, name text, vorname text, aid int);");
		database.dbQuery("CREATE TABLE abteilung ( aid int, name text);");
		database.dbQuery("INSERT INTO mitarbeiter VALUES (01,'John','Geddy',007); ");
		database.dbQuery("INSERT INTO mitarbeiter VALUES (02,'Kabeer','Gawy',007); ");
		database.dbQuery("INSERT INTO mitarbeiter VALUES (03,'Hazlaom','Red',69); ");
		database.dbQuery("INSERT INTO abteilung VALUES (69,'Extra'); ");
		database.dbQuery("INSERT INTO abteilung VALUES (007,'Orginal'); ");
		database.dbQuery("INSERT INTO abteilung VALUES (112,'Emergency'); ");
		
		ArrayList<String[]> mitarbeiter = database.dbQueryResult("SELECT * FROM mitarbeiter;");
		ArrayList<String[]> abteilung = database.dbQueryResult("SELECT * FROM abteilung");
        
        
        //Schritt 4: Ausführen von SQL-Statements mit Rückgabewerten
        String selectSQL = "SELECT * FROM mitarbeiter";
        ArrayList<String[]> result = database.dbQueryResult(selectSQL);

        // Schritt 5: Anzeigen der Ergebnisse
        
        for (String[] row : result) {
            for (String value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        
        database.closeConnection();
    }
}


