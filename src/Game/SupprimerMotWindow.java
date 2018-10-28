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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SupprimerMotWindow extends JFrame implements ActionListener {
	
    private JTextField texte = new JTextField("");
	private Controller controller;
	private JPanel myPanel;
	private JButton oui, non, boutonRetour;
	private int sizeFenX, sizeFenY;
	private Mot supprMot;
	
	public SupprimerMotWindow(Controller c, Mot m) {
		controller = c;
		supprMot = m;
		
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
    	JLabel sousTitre = new JLabel("Voulez-vous vraiment supprimer le mot");
    	sousTitre.setFont(new Font("Verdana", 1, 30));
           	
		// Bouton Oui
		oui = new JButton();
		ImageIcon imgOui = new ImageIcon("img/boutons/oui.png");
		oui.setIcon(imgOui);
		oui.setContentAreaFilled(false);
		
		// Bouton Oui
		non = new JButton();
		ImageIcon imgNon = new ImageIcon("img/boutons/non.png");
		non.setIcon(imgNon);
		non.setContentAreaFilled(false);
		
		JLabel mot = new JLabel(supprMot.getLibelleMot() + " ?");
    	
		// Bouton retour
    	boutonRetour = new JButton();
        ImageIcon imgRetour = new ImageIcon("img/boutons/boutonRetour.png");
        boutonRetour.setIcon(imgRetour);
        boutonRetour.setContentAreaFilled(false);
        
    	mot.setBounds(0,250, 800, 50);
    	mot.setHorizontalAlignment(SwingConstants.CENTER);
    	mot.setFont(new Font("Verdana", 1, 30));
        
		// Placement des différents éléments dans la fenêtre
    	sousTitre.setBounds(0, 200, 800, 50);
    	sousTitre.setHorizontalAlignment(SwingConstants.CENTER);
    	oui.setBounds(200,350,101,33);
    	non.setBounds(500,350,101,33);
    	//boutonRetour.setBounds(660, 520, 100, 33);
    	boutonRetour.setBounds(20, 20, 100, 33);
    	
    	// Ajout des différents éléments à la fenêtre
    	myPanel.add(sousTitre);
    	myPanel.add(mot);
    	myPanel.add(oui);
    	myPanel.add(non);
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
    	oui.addActionListener(this);
    	non.addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == boutonRetour) {
			controller.afficheGestionMot(); 
			this.setDesactivate();
		}
		if(arg0.getSource() == oui) { // suppression du mot	
			try {
				Mot.supprimerMot(supprMot.getIdMot()); // Supprimer le mot de la base de données
				controller.supprimerImage(supprMot.getImage()); // Supprimer l'image dans le dossier mots
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ConfirmationSupprimerMot confirm = new ConfirmationSupprimerMot(controller);
			confirm.setActivate();
			this.setDesactivate();
		}
		if(arg0.getSource() == non) {
			// meme action que retour
			controller.afficheGestionMot(); 
			this.setDesactivate();
		}
	}
	

}

  