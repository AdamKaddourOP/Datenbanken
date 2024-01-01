// CLApplication.java
package datenbanken;

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
        database.closeConnection();
    }
}


/*
package datenbanken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CLApplication {

    // JDBC-URL, Benutzername und Passwort der PostgreSQL-Datenbank
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/Vorlesung";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";

    public static void main(String[] args) {
        try {
            // Schritt 1: JDBC-Treiber laden
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL JDBC-Treiber erfolgreich geladen");

            // Schritt 2: Verbindung zur Datenbank herstellen
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("Verbindung zur PostgreSQL-Datenbank hergestellt");

            // Fügen Sie hier Ihren Code für Datenbankoperationen ein

            // Schritt 3: Verbindung schließen
            connection.close();
            System.out.println("Verbindung zur PostgreSQL-Datenbank geschlossen");

        } catch (ClassNotFoundException e) {
            System.out.println("Fehler beim Laden des JDBC-Treibers: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Fehler bei der Verbindung zur PostgreSQL-Datenbank: " + e.getMessage());
        }
    }
}
*/
