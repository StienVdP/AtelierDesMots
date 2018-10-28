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

public class ModifierJoueurWindow extends JFrame implements ActionListener {
	
	private JTextField TexteNom;
    private JTextField TextePrenom;
	private Controller controller;
	private JPanel myPanel;
	private JButton mJoueur, boutonRetour;
	private int sizeFenX, sizeFenY;
	private Eleve modEleve;
	
	public ModifierJoueurWindow(Controller c, Eleve el) {
		System.out.println("Construction fenêtre modifierJoueur");
		controller = c;
		modEleve = el;
		
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
    	
    	TexteNom = new JTextField(modEleve.getnom());
    	TextePrenom = new JTextField(modEleve.getprenom());
		
    	// Initialisation des différents éléments
    	JLabel sousTitre = new JLabel("Modifier un joueur");
    	sousTitre.setFont(new Font("Verdana", 1, 30));
    	JLabel nom = new JLabel("Nom");
    	nom.setFont(new Font("Verdana",1,20));
    	JLabel prenom = new JLabel("Prénom");
        prenom.setFont(new Font("Verdana",1,20));
           	
		// Bouton mJoueur
		mJoueur = new JButton();
		ImageIcon imgModifier = new ImageIcon("img/boutons/modifier.png");
		mJoueur.setIcon(imgModifier);
		mJoueur.setContentAreaFilled(false);
    	
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
    	mJoueur.setBounds(240,400,310,66);
    	//boutonRetour.setBounds(660, 520, 100, 33);
    	boutonRetour.setBounds(20, 20, 100, 33);
    	
    	// Ajout des différents éléments à la fenêtre
    	myPanel.add(sousTitre);
    	myPanel.add(nom);
    	myPanel.add(prenom);
    	myPanel.add(TexteNom);
    	myPanel.add(TextePrenom);
    	myPanel.add(mJoueur);
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
    	mJoueur.addActionListener(this);
    	boutonRetour.addActionListener(this);
    	
		// Ajout du panneau à la fenêtre
    	this.setContentPane(myPanel);
	}

	public void setDesactivate() {
		this.setVisible(false);
	}
	
	public void setActivate() {
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == boutonRetour) {
			controller.afficheGestionJoueur(); 
			this.setDesactivate();
		}
		if(arg0.getSource() == mJoueur) {
			modEleve.setNom(TexteNom.getText());
			modEleve.setPrenom(TextePrenom.getText());
			System.out.println(modEleve);
			try {
				Eleve.modifierEleve(modEleve);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			controller.afficherConfirmationModifierJoueur(); 
			this.setDesactivate();
		}
	}


	

}

  