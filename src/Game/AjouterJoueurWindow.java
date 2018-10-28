package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AjouterJoueurWindow extends JFrame implements ActionListener {
	
    private JTextField TexteNom = new JTextField("");
    private JTextField TextePrenom = new JTextField("");
	private Controller controller;
	private JPanel myPanel;
	private JButton ajouterJoueur, boutonRetour;
	private int sizeFenX, sizeFenY;
	private String nomBD, prenomBD;
	private Eleve eleve;
	
	public AjouterJoueurWindow(Controller c) {
		controller = c;
		
		// Définition de la taille de la fenêtre
		sizeFenX = 800;
		sizeFenY = 600;
		
		// Initialisation de la fenêtre
		this.setTitle("Atelier des mots");
    	this.setSize(sizeFenX, sizeFenY);
    	this.setLocationRelativeTo(null);
    	this.setResizable(false);
    	this.setAlwaysOnTop(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setLayout(null);
		
		// Initialisation du panneau
		myPanel = new JPanel();
    	myPanel.setBackground(new Color(252,246,232));
    	myPanel.setLayout(null);
		
    	// Initialisation des différents éléments
    	JLabel sousTitre = new JLabel("Ajouter un joueur");
    	sousTitre.setFont(new Font("Verdana", 1, 30));
    	JLabel nom = new JLabel("Nom");
    	nom.setFont(new Font("Verdana",1,20));
    	JLabel prenom = new JLabel("Prénom");
        prenom.setFont(new Font("Verdana",1,20));
           	
		// Bouton modifierJoueur
		ajouterJoueur = new JButton();
		ImageIcon imgAjouter = new ImageIcon("img/boutons/ajouter.png");
		ajouterJoueur.setIcon(imgAjouter);
		ajouterJoueur.setContentAreaFilled(false);		
    	
		// Bouton retour
    	boutonRetour = new JButton();
        ImageIcon imgRetour = new ImageIcon("img/boutons/boutonRetour.png");
        boutonRetour.setIcon(imgRetour);
        boutonRetour.setContentAreaFilled(false);
        
		// Placement des différents éléments dans la fenêtre
    	sousTitre.setBounds(220, 200, 800, 50);
    	nom.setBounds(100,265,150,40);
    	prenom.setBounds(450,265,150, 40);
    	TexteNom.setBounds(100,310,250,50);
    	TextePrenom.setBounds(450,310,250,50);
    	ajouterJoueur.setBounds(240,400,310,66);
    	//boutonRetour.setBounds(660, 520, 100, 33);
    	boutonRetour.setBounds(20, 20, 100, 33);
    	
    	// Ajout des différents éléments à la fenêtre
    	myPanel.add(sousTitre);
    	myPanel.add(nom);
    	myPanel.add(prenom);
    	myPanel.add(TexteNom);
    	myPanel.add(TextePrenom);
    	myPanel.add(ajouterJoueur);
    	myPanel.add(boutonRetour);
    	
    	
		// Ajout d'une image de fond
    	try {
    	    BufferedImage myPicture;
    	    myPicture = ImageIO.read(new File("img/config/accueil.png"));
    	    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
    	    picLabel.setBounds(0, 0, 800, 600);
    	    myPanel.add(picLabel);
    	} catch (IOException e) {
    	    // TODO Auto-generated catch block
    	    e.printStackTrace();
    	}
    	
    	// Mise à l'écoute des événements sur les boutons
    	ajouterJoueur.addActionListener(this);
    	boutonRetour.addActionListener(this);
    	
		// Ajout du panneau à la fenêtre
    	this.setContentPane(myPanel);
    
	}
	
	public void setActivate() {
		this.setVisible(true);
	}

	public void setDesactivate() {
		this.setVisible(false);
	}	
	
	public void actionPerformed(ActionEvent push){
		if (push.getSource() == ajouterJoueur) {
			// AJOUT À LA BASE DE DONNÉES
	    	String nomBD = TexteNom.getText();
	    	String prenomBD = TextePrenom.getText();
	    	try {
				Eleve.ajouterEleve(nomBD, prenomBD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	/* 
		    //APPEL DE LA FENETRE DE CONFIRMATION
			controller.afficheConfirmationAjouter());
			this.setDesactivate();
			*/
	    	controller.afficherConfirmationAjouterJoueur();
	    	this.setDesactivate();
	    }
		
		if(push.getSource() == boutonRetour) {
			//APPEL DE LA FENETRE CHOIX THEME
			controller.afficheGestionJoueur(); 
			this.setDesactivate();
		}
	}
	
}

  