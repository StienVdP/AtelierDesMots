package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminAccueilWindow extends JFrame implements ActionListener, ItemListener {
	
	private Controller controller;
	private JPanel myPanel;
	private JButton boutonRetour, boutonJoueurs, boutonStats, boutonMots;
    private int sizeFenX, sizeFenY;
    private int heightButton, widthButton;
    private int posXboutonJoueurs, posYboutonJoueurs;
	
	public AdminAccueilWindow(Controller c) {
		controller = c;
		
		// Définition de la taille de la fenêtre
		sizeFenX = 800;
		sizeFenY = 600;
		
		// Définition de la taille des boutons du menu
    	heightButton = 200;
    	widthButton = 200;
    	
    	posXboutonJoueurs = 60;
    	posYboutonJoueurs = 300;
    	
		// Initialisation de la fenêtre
		this.setTitle("Accueil Administration");
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
    	
		// Placement des différents éléments dans la fenêtre
    	
      	boutonRetour = new JButton();
      	boutonJoueurs = new JButton();
      	boutonStats = new JButton();
      	boutonMots = new JButton();

    	ImageIcon imgRetour = new ImageIcon("img/boutons/boutonRetour.png");
    	ImageIcon imgJoueurs = new ImageIcon("img/boutons/adminJoueurs.png");
    	ImageIcon imgStats = new ImageIcon("img/boutons/adminStats.png");
    	ImageIcon imgMots = new ImageIcon("img/boutons/adminMots.png");
    	
    	boutonRetour.setIcon(imgRetour);
    	boutonJoueurs.setIcon(imgJoueurs);
    	boutonStats.setIcon(imgStats);
    	boutonMots.setIcon(imgMots);

       	boutonRetour.setBounds(20, 20, 100, 33);
    	boutonJoueurs.setBounds(posXboutonJoueurs, posYboutonJoueurs, widthButton, heightButton);
    	boutonStats.setBounds(posXboutonJoueurs+240, posYboutonJoueurs, widthButton, heightButton);
    	boutonMots.setBounds(posXboutonJoueurs+480, posYboutonJoueurs, widthButton, heightButton);

    	// Ajout des différents éléments à la fenêtre

    	myPanel.add(boutonRetour);
    	myPanel.add(boutonJoueurs);
    	myPanel.add(boutonStats);
    	myPanel.add(boutonMots);
    	
    	// Mise � l'�coute des �v�nements sur les boutons
    	boutonRetour.addActionListener(this);
    	boutonJoueurs.addActionListener(this);
    	boutonStats.addActionListener(this);
    	boutonMots.addActionListener(this);
    	
		// Ajout d'une image de fond
    	try {
    	    BufferedImage myPicture;
    	    myPicture = ImageIO.read(new File("img/config/bgAdmin-Panel.png"));
    	    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
    	    picLabel.setBounds(0, 0, 800, 600);
    	    myPanel.add(picLabel);
    	} catch (IOException e) {
    	    // TODO Auto-generated catch block
    	    e.printStackTrace();
    	}
    	
		// Ajout du panneau à la fenêtre
    	this.setContentPane(myPanel); 	
    	
	}
	
	public void actionPerformed(ActionEvent push){
		
		if(push.getSource() == boutonRetour) {
			//APPEL DE LA FENETRE ACCUEIL
			controller.afficheFenetreAccueil(); 
			this.setDesactivate();
		}		
		
		if(push.getSource() == boutonJoueurs) {
			//APPEL DE LA FENETRE GESTION DES JOUEURS
			controller.afficheGestionJoueur(); 
			this.setDesactivate();
		}
		
		if(push.getSource() == boutonStats) {
			//APPEL DE LA FENETRE CHOIX THEME
			controller.afficheStats(); 
			this.setDesactivate();
		}
		
		if(push.getSource() == boutonMots) {
			//APPEL DE LA FENETRE CHOIX THEME
			controller.afficheGestionMot(); // a faire 
			this.setDesactivate();
		}
	}
	
	
	public void setActivate() {
		this.setVisible(true);
	}

	public void setDesactivate() {
		this.setVisible(false);
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
