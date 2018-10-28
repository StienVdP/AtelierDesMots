package Game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Lettre {
	
	private static char[] lettresBarres 	= {'T', 'F', 'E', 'I', 'L', 'J'};
	private static char[] lettresPonts 		= {'M', 'N', 'Z', 'W', 'H'};
	private static char[] lettresBols 		= {'P', 'B', 'R', 'D', 'S'};
	private static char[] lettresRondes 	= {'G', 'Q', 'O', 'C', 'U'};
	private static char[] lettresTraits 	= {'A', 'X', 'K', 'V', 'Y'};
	
	public static char[] getLettresParasites(char lettre) {
		/**
		 * On cherche ici à récupérer le tableau des lettres parasites de la lettre passée en paramètre
		 * Ainsi, on pourra générer des lettres parasites pour les mots de niveau 2
		 */
		char[] retour, tableauTraitement;
		lettre = Character.toUpperCase(lettre);
		int cpt = 0;
		if(lettre == 'A' || lettre == 'X' || lettre == 'K' || lettre == 'V' || lettre == 'Y') {
			tableauTraitement = lettresTraits;
		}
		else if(lettre == 'G' || lettre == 'Q' || lettre == 'O' || lettre == 'C' || lettre == 'U') {
			tableauTraitement = lettresRondes;
		}
		else if(lettre == 'P' || lettre == 'B' || lettre == 'R' || lettre == 'D' || lettre == 'S') {
			tableauTraitement = lettresBols;
		}
		else if(lettre == 'M' || lettre == 'N' || lettre == 'Z' || lettre == 'W' || lettre == 'H') {
			tableauTraitement = lettresPonts;
		}
		else {
			tableauTraitement = lettresBarres;
		}
		retour = new char[tableauTraitement.length-1];
		for(int i=0; i<tableauTraitement.length; i++) {
			if(tableauTraitement[i]!=lettre) {
				retour[cpt] = (char) tableauTraitement[i];
				cpt++;
			}
		}
		return retour;
	}
	
	public static String afficheTableau(char[] tab) {
		/**
		 * Simple fonction pour afficher le tableau de caractères en dev
		 */
		String str = "";
		for(int i=0; i<tab.length-1; i++) {
			str+=tab[i] + ", ";
		}
		str+=tab[tab.length-1];
		return str;
	}
	
	public static JLabel getCaseLettre(char l, Color c) {
		JLabel cl = new JLabel();
		char[] chaine = {l};
		cl.setText(Controller.stringUpperCase(new String(chaine)));
		cl.setFont(new Font("Verdana",1,40));
		if(c!=null) {
			cl.setForeground(c);
		}
		cl.setIcon(new ImageIcon("img/casesVides2.png"));
		cl.setVerticalTextPosition(SwingConstants.CENTER);
		cl.setHorizontalTextPosition(SwingConstants.CENTER);
		return cl;
	}
	
	public static void setCaseLettre(char l, Color c, JButton b) {
		char[] chaine = {l};
		b.setText(Controller.stringUpperCase(new String(chaine)));
		b.setFont(new Font("Verdana",1,40));
		if(c!=null) {
			b.setForeground(c);
		}
		b.setIcon(new ImageIcon("img/casesVides2.png"));
		b.setVerticalTextPosition(SwingConstants.CENTER);
		b.setHorizontalTextPosition(SwingConstants.CENTER);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Lettres parasites pour T");
		System.out.println(afficheTableau(getLettresParasites('T')));
		
	}
	
}
