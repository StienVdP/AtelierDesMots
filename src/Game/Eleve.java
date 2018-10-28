package Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Eleve {

	private int idEleve;
	private String prenom;
	private String nom;
	private int scoreN1;
	private int scoreN2;
	
	public Eleve(int id, String p, String n, int sN1, int sN2){
		idEleve = id;
		prenom=p;
		nom=n;
		scoreN1=sN1;
		scoreN2=sN2;
	}
	
	public Eleve(String p, String n, int sN1, int sN2){
		prenom=p;
		nom=n;
		scoreN1=sN1;
		scoreN2=sN2;
	}
	
	public static ArrayList<Eleve> getAllEleves() throws SQLException{
		ArrayList<Eleve> eleve = new ArrayList<Eleve>();
		Connexion con = new Connexion("atelierdesmots.db");
		con.connect();
		ResultSet eleves = con.query("SELECT * FROM eleve ORDER BY nom");
		while (eleves.next()){
			int sscoreN1 = eleves.getInt("scoreN1");
			int sscoreN2 = eleves.getInt("scoreN2");
			eleve.add(new Eleve(eleves.getInt("idEleve"), eleves.getString("prenom"), eleves.getString("nom"), sscoreN1, sscoreN2));
		}
		con.close();
		return eleve;
	}
	
	public void incremente(int niveau) throws SQLException {
		Connexion con = new Connexion("atelierdesmots.db");
		con.connect();
		if(niveau==1) {
			String query = "UPDATE eleve SET scoreN1 = scoreN1+1 WHERE idEleve = " + this.idEleve + ";";
			int eleve = con.insert(query);
		}
		else {
			String query = "UPDATE eleve SET scoreN2 = scoreN2+1 WHERE idEleve = " + this.idEleve + ";";
			int eleve = con.insert(query);
		}
		con.close();
	}
	
	public static void ajouterEleve(String n, String p) throws SQLException{
		Connexion con = new Connexion("atelierdesmots.db");
		con.connect();
		String query = "INSERT INTO eleve(idEleve, nom, prenom, scoreN1, scoreN2) VALUES (NULL, '" + n + "', '" + p +"', 0, 0);";
		int eleve = con.insert(query);
		con.close();
	}
	
	public static void modifierEleve(Eleve e) throws SQLException{
		Connexion con = new Connexion("atelierdesmots.db");
		con.connect();
		String query = "UPDATE eleve SET nom = '" + e.nom + "', prenom = '" + e.prenom + "' WHERE idEleve = " + e.idEleve + ";";
		int eleve = con.insert(query);
		con.close();
		
	}
	
	public static void supprimerEleve(int idE) throws SQLException{
		Connexion con = new Connexion("atelierdesmots.db");
		con.connect();
		String query = "DELETE FROM eleve WHERE idEleve = " + idE + ";";
		int eleve = con.insert(query);
		con.close();
	}

	public String getNom(){
		//return this.nom+" "+this.prenom ;
		return this.toString();
	}
	
	public String getnom(){
		return this.nom;
	}
	public String getprenom(){
		return this.prenom;
	}
	public int getsN1(){
		return this.scoreN1;
	}
	public int getsN2(){
		return this.scoreN2;
	}
	
	public int getIdEleve() {
		return idEleve;
	}
	
	public void setNom(String n) {
		this.nom = n;
	}
	
	public void setPrenom(String p) {
		this.prenom = p;
	}
	
	public String toString() {
		return Controller.firstCharUpperCase(this.prenom) + ' ' + Controller.firstCharUpperCase(this.nom);
	}
	
}
