package Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Mot {
	
	private int idMot;
	private String libelleMot;
	private String image; 
	private boolean n1;
	private boolean n2;
	
	public Mot(int idM, String libM, String img, int niv1, int niv2){
		idMot=idM;
		libelleMot=libM;
		image=img;
		n1 = niv1==1;
		n2 = niv2==1;
	}
	
	public static ArrayList<Mot> getAllMots() throws SQLException {
		ArrayList<Mot> mot = new ArrayList<Mot>();
		Connexion con = new Connexion("atelierdesmots.db");
		con.connect();
		ResultSet mots = con.query("SELECT * FROM mot ORDER BY libelleMot");
		while(mots.next()){
			Mot m = new Mot(mots.getInt("idMot"),mots.getString("libelleMot"),mots.getString("image"), mots.getInt("n1"), mots.getInt("n2"));
			mot.add(m);	
		}
		con.close();
		return mot;
	}
	
	public static Mot getMotById(int idM) throws SQLException {
		Connexion con = new Connexion("atelierdesmots.db");
		con.connect();
		ResultSet mots = con.query("SELECT * FROM mot WHERE idMot = " + idM + ";");
		Mot m = null;
		while(mots.next()){
			m = new Mot(mots.getInt("idMot"),mots.getString("libelleMot"),mots.getString("image"), mots.getInt("n1"), mots.getInt("n2"));	
		}
		con.close();
		return m;
	}
	
	public ArrayList<Theme> getThemesMot() throws SQLException {
		ArrayList<Theme> themes = new ArrayList<Theme>();
		Connexion con = new Connexion("atelierdesmots.db");
		con.connect();
		ResultSet mots = con.query("SELECT * FROM theme t JOIN themeMot tm ON tm.idTheme = t.idTheme WHERE idMot = " + this.getIdMot() + ";");
		while(mots.next()){
			Theme t = new Theme(mots.getString("libelleTheme"));
			themes.add(t);	
		}
		con.close();
		return themes;
	}
	
	public static ArrayList<Mot> getAllMotsByTheme(Theme t) throws SQLException {
		int idTheme = t.getIdTheme();
		ArrayList<Mot> mot = new ArrayList<Mot>();
		Connexion con = new Connexion("atelierdesmots.db");
		con.connect();
		ResultSet mots = con.query("SELECT * FROM mot m JOIN themeMot tm ON tm.idMot = m.idMot WHERE idTheme = " + idTheme + ";");
		while(mots.next()){
			Mot m = new Mot(mots.getInt("idMot"),mots.getString("libelleMot"),mots.getString("image"), mots.getInt("n1"), mots.getInt("n2"));
			mot.add(m);	
		}
		con.close();
		return mot;
	}
	
	public int getIdMot() {
		return idMot;
	}
	
	public String getLibelleMot() {
		return libelleMot;
	}
	
	public String getImage() {
		return image;
	}
	
	public String toString() {
		return libelleMot;
	}
	
	public boolean isN1() {
		return this.n1;
	}
	
	public boolean isN2() {
		return this.n2;
	}
	
	public void setLibelleMot(String lm) {
		this.libelleMot = lm;
	}
	
	public void setImage(String i) {
		this.image = i;
	}
	
	public int getN1() {
		return n1?1:0;
	}
	
	public int getN2() {
		return n2?1:0;
	}
	
	public void setN1(int niv1) {
		if (niv1==1){
			this.n1 = true;
		}
		else {
			this.n1 = false;
		}
	}
	
	public void setN2(int niv2) {
		if (niv2==1){
			this.n2 = true;
		}
		else {
			this.n2 = false;
		}
	}
	
	/* Pour ajouter un mot il faut l'ajouter dans la table Mot mais aussi associer 
	 * les themes dans lequel il peut être dans la table ThemeMot
	 */
	public static Mot ajouterMot(String lm, String img, int N1, int N2) throws SQLException{
		Connexion con = new Connexion("atelierdesmots.db");
		con.connect();
		String query = "INSERT INTO mot(idMot, libelleMot, image, n1, n2) VALUES (NULL, '" + lm + "', '" + img +"', '" + N1 + "', '" + N2 + "');";
		int mot = con.insert(query);
		con.close();
		con.connect();  
		String chercheIdM = "SELECT idMot AS lastId FROM mot ORDER BY idMot DESC;";
		ResultSet idM = con.query(chercheIdM);
		idM.next();
		int lastIdMot = Integer.parseInt(idM.getString("lastId"));
		con.close();
		return getMotById(lastIdMot);
	}
	
	public void ajouterThemeMot(int[] tab) throws SQLException{
		Connexion con = new Connexion("atelierdesmots.db");
		int lastIdMot = this.idMot;
		for (int i = 0; i<tab.length; i++){
			if (tab[i] == 1){
				int idT = i+1;
				con.connect();
				String query = "INSERT INTO themeMot(idTheme, idMot) VALUES (" + idT + ", " + lastIdMot + ");";
				int mot = con.insert(query);
				con.close();
			}
		}
	}
	
	public static void modifierMot(Mot m, int[] tab) throws SQLException {
		Connexion con = new Connexion("atelierdesmots.db");
		con.connect();
		String query = "UPDATE mot SET libelleMot = '" + m.libelleMot + "', image = '" + m.image + "', n1 = " + m.getN1() + ", n2 = " + m.getN2() + " WHERE idMot = " + m.idMot + ";";
		String query2 = "DELETE FROM themeMot WHERE idmot = " + m.idMot + ";";
		con.insert(query);
		con.close();
		con.connect();
		con.insert(query2);
		con.close();
		m.ajouterThemeMot(tab);
	}
	
	public static void supprimerMot(int idM) throws SQLException{
		Connexion con = new Connexion("atelierdesmots.db");
		con.connect();
		String query = "DELETE FROM mot WHERE idmot = " + idM + ";";
		String query2 = "DELETE FROM themeMot WHERE idmot = " + idM + ";";
		int mot = con.insert(query);
		con.close();
		con.connect();
		int mot2 = con.insert(query2);
		con.close();
	}
		
}
