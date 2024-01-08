package datenbanken2;

import java.util.ArrayList;

public class ClApplication {

	
	public static void main(String[] args) {
		Database database = new Database();
		database.setUser("postgres");
		database.setPassword("123");
		//database.setUrl("localhost", "5432", "postgres");
		database.setUrl("localhost", "5432", "praktikum15");
		database.openConnection();
		database.dbQuery("CREATE DATABASE praktikum15");//Erste Schritt : 13  auskommentiernen ->  Zweite Schritt: Kommentar auflösen und 12 auskommentieren 
		
		database.dbQuery("CREATE SCHEMA IF NOT EXISTS versuch15;");
		database.dbQuery("set SEARCH_PATH to versuch15;");
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
		database.closeConnection();
		
		for(int i=0; i<mitarbeiter.size(); i++) {
			for(int j=0; j<mitarbeiter.get(i).length; j++) {
				System.out.print(mitarbeiter.get(i)[j]+"\t");
			}
			System.out.println();
		}
		
		for(int i=0; i<abteilung.size(); i++) {
			for(int j=0; j<abteilung.get(i).length; j++) {
				System.out.print(abteilung.get(i)[j]+"\t");
			}
			System.out.println();
		}
	}
}


//database.setUrl("localhost", "5432", "praktikum15");//16



