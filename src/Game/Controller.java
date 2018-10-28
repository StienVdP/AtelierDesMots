package Game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Controller {

	private PrincipaleWindow fenetreAccueil;// = new PrincipaleWindow(this);
	private ChoixNiveauWindow fenetreChoixNiveau;// = new ChoixNiveauWindow(this);
	private ChoixThemeWindow fenetreChoixTheme;// = new ChoixThemeWindow(this);
	private AutomneWindow fenetreAutomne;// = new AutomneWindow(this);
	private HiverWindow fenetreHiver;// = new HiverWindow(this);
	private EteWindow fenetreEte;// = new EteWindow(this);
	private PrintempsWindow fenetrePrintemps;// = new PrintempsWindow(this);
	private ThemeWindow fenetreJeu;
	private ModifierJoueurWindow modifierJoueur;
	private ModifierMotWindow modifierMot;
	private SupprimerMotWindow supprimerMot;
	private SupprimerJoueurWindow supprimerJoueur;
	private Eleve joueur;
	private int niveau;
	private Theme theme;
	private ArrayList<Mot> listeDesMots, listeDesMotsTheme, listeDesMotsNiveau;
	private boolean levelUp = false;
	private int nbEssai = 1;
	private AdminAccueilWindow fenetreAdmin;
	private JoueurWindow fenetreGestionJ;
	private StatsJoueurWindow fenetreStats;
	private MotWindow fenetreGestionM;
	
	public Controller() {
		fenetreAccueil = new PrincipaleWindow(this);
		fenetreAccueil.setActivate();
	}
	
	public void afficheFenetreAccueil() {
		joueur = null;
		niveau = 0;
		theme = null;
		fenetreAccueil = new PrincipaleWindow(this);
		fenetreAccueil.setActivate();
	}
	
	public void afficheAdmin(){
		fenetreAdmin=new AdminAccueilWindow(this);
		fenetreAdmin.setActivate();
	}
	
	public void afficheGestionJoueur(){
		fenetreGestionJ=new JoueurWindow(this);
		fenetreGestionJ.setActivate();
	}
	
	public void afficheGestionMot() {
		fenetreGestionM=new MotWindow(this);
		fenetreGestionM.setActivate();
	}
	
	public void afficheStats(){
		fenetreStats=new StatsJoueurWindow(this);
		fenetreStats.setActivate();
	}
	
	public void closeFenetreJeu() {
		fenetreJeu.dispose();
	}
	
	public void afficheModifierEleve(Eleve el) {
		if(modifierJoueur!=null) {
			if(!modifierJoueur.isActive()) {
				modifierJoueur.dispose();
				modifierJoueur = new ModifierJoueurWindow(this, el);
				modifierJoueur.setActivate();
			}
		}
		else {
			modifierJoueur = new ModifierJoueurWindow(this, el);
			modifierJoueur.setActivate();
		}
	}
	
	public void afficheModifierMot(Mot m) {
		if(modifierMot!=null) {
			if(!modifierMot.isActive()) {
				modifierMot.dispose();
				modifierMot = new ModifierMotWindow(this, m);
				modifierMot.setActivate();
			}
		}
		else {
			modifierMot = new ModifierMotWindow(this, m);
			modifierMot.setActivate();
		}
	}
	
	public void afficheSupprimerEleve(Eleve el) {
		if(supprimerJoueur!=null) {
			if(!supprimerJoueur.isActive()) {
				supprimerJoueur.dispose();
				supprimerJoueur = new SupprimerJoueurWindow(this, el);
				supprimerJoueur.setActivate();
			}
		}
		else {
			supprimerJoueur = new SupprimerJoueurWindow(this, el);
			supprimerJoueur.setActivate();
		}
	}
	
	public void afficheSupprimerMot(Mot m) {
		if(supprimerMot!=null) {
			if(!supprimerMot.isActive()) {
				supprimerMot.dispose();
				supprimerMot = new SupprimerMotWindow(this, m);
				supprimerMot.setActivate();
			}
		}
		else {
			supprimerMot = new SupprimerMotWindow(this, m);
			supprimerMot.setActivate();
		}
	}
	
	public void afficheChoixTheme(Eleve eleveChoisi) {
		joueur = eleveChoisi;
		fenetreChoixTheme = new ChoixThemeWindow(this);
		fenetreChoixTheme.setActivate();
	}
	
	public ThemeWindow getFenetreJeu() {
		return fenetreJeu;
	}
	
	public void afficheChoixNiveau(Theme themeChoisi) {
		theme = themeChoisi;
		fenetreChoixTheme.dispose();
		try {
			listeDesMotsTheme = Mot.getAllMotsByTheme(this.getTheme());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(listeDesMotsTheme.size()!=0) {
			fenetreChoixTheme.setDesactivate();
			fenetreChoixNiveau = new ChoixNiveauWindow(this);
			fenetreChoixNiveau.setActivate();
			listeDesMots = listeDesMotsTheme;
		}
		else {
			// il n'y a pas de mots pour ce thème
			playSound("Bump.wav");
			JOptionPane.showMessageDialog(fenetreChoixTheme, "Aucun mot pour ce thème");
			afficheChoixTheme(this.getJoueur());
			//System.exit(0);
		}
	}
	
	public ArrayList<Mot> triMotsNiveau(ArrayList<Mot> nonTrie, int niv) {
		ArrayList<Mot> trie = new ArrayList<Mot>();
		if(niv==1) {
			for(int i=0; i<nonTrie.size(); i++) {
				if(nonTrie.get(i).isN1()) {
					trie.add(nonTrie.get(i));
				}
			}
		}
		else {
			for(int i=0; i<nonTrie.size(); i++) {
				if(nonTrie.get(i).isN2()) {
					trie.add(nonTrie.get(i));
				}
			}
		}
		return trie;
	}
	
	public void retryMot(Mot motC) {
		nbEssai++;
		fenetreJeu.dispose();
		switch(theme.getLibelleTheme()) {
			case "Automne":
				fenetreJeu = new AutomneWindow(this, motC);
				//fenetreAutomne.setActivate();
				break;
			case "Hiver":
				fenetreJeu = new HiverWindow(this, motC);
				//fenetreHiver.setActivate();
				break;
			case "Printemps":
				fenetreJeu = new PrintempsWindow(this, motC);
				//fenetrePrintemps.setActivate();
				break;
			case "Ete":
				fenetreJeu = new EteWindow(this, motC);
				//fenetreEte.setActivate();
				break;
			default:
				fenetreJeu = new AutomneWindow(this, motC);
				//fenetreAutomne.setActivate();
				break;
		}
		fenetreJeu.setActivate();
	}
	
	public int getNbEssai() {
		return nbEssai;
	}
	
	public void setNiveau(int level) {
		niveau = level;
		nbEssai = 1;
		fenetreChoixNiveau.dispose();
		listeDesMotsNiveau = triMotsNiveau(listeDesMots, niveau);
		if(listeDesMotsNiveau.size()!=0) {
			listeDesMots = listeDesMotsNiveau;
			// lancement du jeu
			System.out.println("Lancement du jeu...");
			System.out.println("Joueur : " + joueur.toString());
			System.out.println("Thème : " + this.theme);
			System.out.println("Niveau : " + this.niveau);
			switch(theme.getLibelleTheme()) {
				case "Automne":
					//fenetreAutomne = new AutomneWindow(this);
					fenetreJeu = new AutomneWindow(this);
					//fenetreAutomne.setActivate();
					break;
				case "Hiver":
					//fenetreHiver = new HiverWindow(this);
					fenetreJeu = new HiverWindow(this);
					//fenetreHiver.setActivate();
					break;
				case "Printemps":
					//fenetrePrintemps = new PrintempsWindow(this);
					fenetreJeu = new PrintempsWindow(this);
					//fenetrePrintemps.setActivate();
					break;
				case "Ete":
					//fenetreEte = new EteWindow(this);
					fenetreJeu = new EteWindow(this);
					//fenetreEte.setActivate();
					break;
				default:
					//fenetreAutomne = new AutomneWindow(this);
					fenetreJeu = new AutomneWindow(this);
					//fenetreAutomne.setActivate();
					break;
			}
			fenetreJeu.setActivate();
		}
		else if (levelUp==false) {
			// Il n'y a pas de mots pour ce niveau
			playSound("Bump.wav");
			JOptionPane.showMessageDialog(fenetreChoixNiveau, "Aucun mot pour ce niveau");
			afficheChoixNiveau(this.getTheme());
			//System.exit(0);
		}
		else {
			listeDesMots = listeDesMotsTheme;
			setNiveau(level);
		}
	}
	
	public void levelUp(boolean b) {
		levelUp = b;
	}
	
	public Eleve getJoueur() {
		return joueur;
	}
	
	public Theme getTheme() {
		return theme;
	}
	
	public ArrayList<Mot> getListeDesMots() {
		return listeDesMots;
	}
	
	public int getNiveau() {
		return this.niveau;
	}
	
	public void quitGame() {
		System.exit(0);
	}
	
	public static String firstCharUpperCase(String chaine) {
		char[] char_table = chaine.toCharArray();
		char_table[0]=Character.toUpperCase(char_table[0]);
		return new String(char_table);
	}
	
	public static char charUpperCase(char c) {
		c = Character.toUpperCase(c);
		return c;
	}
	
	public static String stringUpperCase(String chaine) {
		char[] char_table = chaine.toCharArray();
		for(int i=0; i < char_table.length; i++) {
			char_table[i]=Character.toUpperCase(char_table[i]);
		}
		return new String(char_table);
	}
	
	public static int genererAleatoire(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}
	
	public Mot getMot() {
		Random rand = new Random();
		int max = listeDesMots.size();
		int nombreAleatoire = rand.nextInt(max);
		Mot mot = listeDesMots.get(nombreAleatoire);
		listeDesMots.remove(mot);
		for(int i=0; i<listeDesMots.size(); i++) {
			System.out.println(listeDesMots.get(i));
		}
		return mot;
	}
	
	public static boolean verifierMot(String mot, char[] proposition) {
		char[] motChar = mot.toCharArray();
		int i = 0;
		boolean egal = true;
		while(egal && i < motChar.length) {
			if(motChar[i] != proposition[i]) {
				egal = false;
			}
			i++;
		}
		return egal;
	}
	
	public static ImageIcon redimensionnerImage(String lien, int width, int height) {
		ImageIcon icon = new ImageIcon(lien); 
    	Image img = icon.getImage(); 
    	BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); 
    	Graphics g = bi.createGraphics(); 
    	g.drawImage(img, 0, 0, width, height, null); 
    	ImageIcon newIcon = new ImageIcon(bi); 
    	return newIcon;
	}
	
	public static int[] nouvellesDimensionImage(int imgLargeur, int imgHauteur, int cadreL, int cadreH) {
		int newLargeur = imgLargeur, newHauteur = imgHauteur;
    	if(imgLargeur <= cadreL && imgHauteur <= cadreH) {
    		// on l'ajoute simplement
    		newLargeur = imgLargeur;
    		newHauteur = imgHauteur;
    	}
    	else {
    		float ratioImg = imgLargeur/imgHauteur;
			int difL = imgLargeur - cadreL;
			int difH = imgHauteur - cadreH;
			float ratioImgL = 1 - ((float)difL/imgLargeur);
			float ratioImgH = 1 - ((float)difH/imgHauteur);
			float newLByL = ratioImgL*imgLargeur;
			float newLByH = ratioImgH*imgLargeur;
			float newHByL = ratioImgL*imgHauteur;
			float newHByH = ratioImgH*imgHauteur;
    		// différents cas
    		if(imgLargeur > cadreL) {
    			if(imgHauteur > cadreH) {
    				// l > cadreL & h > cadreH
    				if(newLByL <= cadreL && newHByL <= cadreH) {
    					if(newLByH <= cadreL && newHByH <= cadreH) {
    						if(newLByH*newHByH > newLByL*newHByL) {
    							newLargeur = (int) newLByH;
    							newHauteur = (int) newHByH;
    						}
    						else {
    							newLargeur = (int) newLByL;
    							newHauteur = (int) newHByL;
    						}
    					}
    					else {
    						newLargeur = (int) newLByL;
							newHauteur = (int) newHByL;
    					}
    				}
    				else {
						newLargeur = (int) newLByH;
						newHauteur = (int) newHByH;
    				}
    			}
    			else {
    				// l > cadreL & h <= cadreH
					newLargeur = (int) newLByL;
					newHauteur = (int) newHByL;
    			}
    		}
    		else {
    			if(imgHauteur > cadreH) {
    				// l <= cadreL & h > cadreH
					newLargeur = (int) newLByH;
					newHauteur = (int) newHByH;
    			}
    		}
    	}
    	return new int[] {newLargeur, newHauteur};
	}
	
	public void afficheConfirmationAjouterMot() {
		ConfirmationAjouterMot cam = new ConfirmationAjouterMot(this);
		cam.setActivate();
	}
	
	public void afficherConfirmationAjouterJoueur() {
        ConfirmationAjouterJoueur caj = new ConfirmationAjouterJoueur(this);
        caj.setActivate();
	}
	
	public void afficheConfirmationModifierMot() {
		ConfirmationModifierMot cmm = new ConfirmationModifierMot(this);
		cmm.setActivate();
	}
	
	public void afficherConfirmationModifierJoueur() {
        ConfirmationModifierJoueur cmj = new ConfirmationModifierJoueur(this);
        cmj.setActivate();
	}	
	
	public void affichePasDeJoueur() {
		playSound("Bump.wav");
		Dialog p = new Dialog(fenetreAccueil, "Aucun joueur", true, new PasDeJoueurPanneau(this));
	}
	
	public void afficheVictoire() {
		playSound("Flagpole.wav");
		Dialog v = new Dialog(fenetreJeu, "Victoire", true, new VictoirePanneau(this));
	}
	
	public void afficheDefaite() {
		playSound("Death.wav");
		Dialog d = new Dialog(fenetreJeu, "Défaite", true, new DefaitePanneau(this));
	}
	
	public void afficherFinNiveau() {
		if(niveau==1) {
			Dialog n = new Dialog(fenetreJeu, "Fin du niveau", true, new FinNiveauPanneau(this));
		}
		else {
			afficheFinTheme();
		}
	}
	
	public void afficheFinTheme() {
		Dialog t = new Dialog(fenetreJeu, "Fin du thème", true, new FinThemePanneau(this));
	}
	
	public void supprimerImage(String p_nomDuFichier) {
    	File fichier = new File(p_nomDuFichier);
    	fichier.delete();
	}
	
	public synchronized void playSound(final String p_url) {
		  new Thread(new Runnable() {
		    public void run() {
		    	try
		        {
		            Clip clip = AudioSystem.getClip();
		            clip.open(AudioSystem.getAudioInputStream(new File("song/"+p_url)));
		            clip.start();
		        }
		        catch (Exception exc)
		        {
		            exc.printStackTrace(System.out);
		        }
		    }
		  }).start();
	}
	
}
