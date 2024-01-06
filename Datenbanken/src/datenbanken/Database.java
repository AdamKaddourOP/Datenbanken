// Database.java
package datenbanken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

    private String jdbcUrl;
    private String user = "postgres";
    private String password = "123";
    private Connection connection;

    public Database() {
       
        loadJdbcDriver();
    }

    private void loadJdbcDriver() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL JDBC-Treiber erfolgreich geladen");
        } catch (ClassNotFoundException e) {
            System.out.println("Fehler beim Laden des JDBC-Treibers: " + e.getMessage());
            System.exit(1);
        }
    }

    public void openConnection() {
        try {
            connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Verbindung zur PostgreSQL-Datenbank hergestellt");
        } catch (SQLException e) {
            System.out.println("Fehler bei der Verbindung zur PostgreSQL-Datenbank: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Verbindung zur PostgreSQL-Datenbank geschlossen");
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Schließen der Verbindung: " + e.getMessage());
        }
    }
    
    public String getJdbcUrl() {
 		return jdbcUrl;
 	}

 	public void setJdbcUrl(String jdbcUrl) {
 		this.jdbcUrl = jdbcUrl;
 	}

 	
 	//Methode dbQuery()
 	 // Aufgabe Seite 5 Ausführen von SQL-Statements (ohne Rückgabewert) 
 	public void dbQuery(String sql) {
        try {
        	
            Statement statement = connection.createStatement();
            // Führe das SQL-Statement aus
            statement.executeUpdate(sql);
            System.out.println("SQL-Statement erfolgreich ausgeführt");
            
        } catch (SQLException e) {
        	
            System.out.println("Fehler beim Ausführen des SQL-Statements: " + e.getMessage());
        }
    }
    
 	
 	 public ArrayList<String[]> dbQueryResult(String sql) {
         ArrayList<String[]> resultList = new ArrayList<>();

         try {
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql);
             ResultSetMetaData rsmd = result.getMetaData();
             int columnCount = rsmd.getColumnCount();

             while (result.next()) {
                 String[] row = new String[columnCount];
                 for (int i = 0; i < columnCount; i++) {
                     row[i] = result.getString(i + 1);
                 }
                 resultList.add(row);
             }

             System.out.println("SQL-Statement mit Rückgabewerten erfolgreich ausgeführt");
         } catch (SQLException e) {
             System.out.println("Fehler beim Ausführen des SQL-Statements mit Rückgabewerten: " + e.getMessage());
         }
         return resultList;
     }
 	
}

