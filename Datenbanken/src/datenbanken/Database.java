// Database.java
package datenbanken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    
}






/*package datenbanken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	

	private String user="postgres";       
	private String password="123";
	private String url;
	private Connection connection; 
	
	private void loadJdbcDriver(){
		try{
			Class.forName("org.postgresql.Driver");
			System.out.println("JDBC-Treiber geladen");
	}
		catch(ClassNotFoundException e) {
			System.out.println("Fehler beim Laden des Treibers: "+e.getMessage());
			System.exit(1);
		}
	}
	
	public Database() {
		
		loadJdbcDriver();
	}
	
	public void openConnection()   {
		
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Ver Erfolgreich");
		}
		catch(SQLException sqlE) {
			
			System.out.println("Fehler bei der Ver");
		}
		
	}
	
	public void closeConnection(){
		try {
			connection.close();
			System.out.println("Ver Erfolgreich gesclossen");
		}
		catch(SQLException sqlE) {
			
			System.out.println("Fehler");
		}
		
	}
	

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setURL(String hostIP, int port, String dbName) {
        this.url = "jdbc:mysql://" + hostIP + ":" + port + "/" + dbName;
    }
	
	
}*/
