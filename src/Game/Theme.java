package Game;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JButton;

public class Theme {

	private int idTheme;
	private String libelleTheme;
	private String imageFond;
	
	public Theme(String libT) throws SQLException{
		libelleTheme=libT;
		Connexion con = new Connexion("atelierdesmots.db");
		con.connect();
		ResultSet theme = con.query("SELECT * FROM theme WHERE libelleTheme = '" + libelleTheme + "';");
		idTheme = theme.getInt("idTheme");
		imageFond = theme.getString("imageFond");
		con.close();
	}
	
	public int getIdTheme(){
		return idTheme;
	}
	
	public String getImageFond(){
		return imageFond;
	}
	
	public String getLibelleTheme() {
		return libelleTheme;
	}
	
	public String toString() {
		return libelleTheme;
	}
	
	public static void main(String[] args) {
		for(int i=1; i<=16; i++) {
			System.out.println("l"+i+" = new JButton();");
		}
		System.out.println();
		for(int i=1; i<=16; i++) {
			System.out.println("l"+i+".setIcon(imgcv);");
		}
		System.out.println();
		for(int i=1; i<=16; i++) {
			System.out.println("l"+i+".setContentAreaFilled(false);");
		}
		System.out.println();
		for(int i=1; i<=16; i++) {
			System.out.println("l"+i+".setOpaque(false);");
		}
		System.out.println();
		for(int i=1; i<=16; i++) {
			System.out.println("l"+i+".setBorderPainted(false);");
		}
		System.out.println();
		for(int i=1; i<=16; i++) {
			System.out.println("l"+i+".setBounds(x,y,w,h);");
		}
		System.out.println();
		for(int i=1; i<=16; i++) {
			System.out.println("myPanel.add(l"+i+");");
		}
	}
	
}
