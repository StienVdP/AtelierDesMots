package Game;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Connexion {
    private String DBPath = "";
    private Connection connection = null;
    private Statement statement = null;
 
    public Connexion(String dBPath) {
    	System.setProperty( "file.encoding", "UTF-8" );
        DBPath = dBPath;
    }
    
    public String getDbPath(){
    	return DBPath;
    }
    
    public Statement getStatement() {
    	return statement;
    }
 
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
            statement = connection.createStatement();
            System.out.println("Connexion a " + DBPath + " avec succes");
        } catch (ClassNotFoundException notFoundException) {
            notFoundException.printStackTrace();
            System.out.println("Erreur de connexion");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Erreur de connecxion");
        }
    }
 
    public void close() {
        try {
        	if (statement != null) statement.close();
        	if (connection != null) connection.close();
        	System.out.println("Connexion fermée");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problème lors de la fermeture de la connexion");
        }
    }
    public ResultSet query(String request) throws SQLException {
        ResultSet resultat = null;
        try {
            resultat = statement.executeQuery(request);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur dans la requete : " + request);
        }
        return resultat;
    }
    
    public int insert(String request) throws SQLException {
    	int resultat = 0;
    	try {
    		resultat = statement.executeUpdate(request);
    	} catch (SQLException e) {
    		e.printStackTrace();
    		System.out.println("Erreur dans la requête : " + request);
    	}
    	return resultat;
    }
    
}