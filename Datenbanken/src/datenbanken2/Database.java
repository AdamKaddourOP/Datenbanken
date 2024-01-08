package datenbanken2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
	
	private String user;
	private String password;
	private String url;
	private Connection connection;
	
	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrl(String ip, String port, String name) {
		this.url = "jdbc:postgresql://"+ip+":"+port+"/"+name;
	}

	public Database() {
		loadJdbcDriver();
	}
	
	private void loadJdbcDriver() {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("JDBC-Treiber geladen");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Fehler beim Laden des Treibers: " + e.getMessage());
			System.exit(1);
		}
	}
	
	public void openConnection() {
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Datenbank geoeffnet");
		} catch (SQLException e) {
			System.out.println("Fehler beim Datenbank ofnnen: "+e.getMessage());
		}
	}
	
	public void closeConnection() {
		try {
			connection.close();
			System.out.println("Datenbank closed");
		} catch (SQLException e) {
			System.out.println("Fehler beim Datenbank closen: "+e.getMessage());
		}
	}
	
	public void dbQuery(String sql){
		try {
			Statement state = connection.createStatement();
			System.out.println("statement created");
			try {
				state.executeUpdate(sql);
				System.out.println("statement updated");
			}
			catch (SQLException e) {
				System.out.println("Fehler beim updated: "+e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println("Fehler beim createn: "+e.getMessage());
		}
	}
	
	public ArrayList<String[]> dbQueryResult(String sQuery){		
		try {
			Statement state = connection.createStatement();
			System.out.println("statement gelesen");
			ArrayList<String[]> aResult = new ArrayList<String[]>();
			ResultSet result = state.executeQuery(sQuery);
			ResultSetMetaData rsmd = result.getMetaData();
			int cCount = rsmd.getColumnCount();
			while (result.next()) {
				String sRow[] = new String[cCount];
				for (int i=0; i<cCount; i++) {
					sRow[i] = result.getString(i+1);
				}
				aResult.add(sRow);
			}
			return aResult;
		} catch (SQLException e) {
			System.out.println("Fehler beim lesen: "+e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}

}