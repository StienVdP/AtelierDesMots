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

public class PrincipaleWindow extends JFrame implements ActionListener, ItemListener {
	
	private Controller controller;
	private JComboBox<Eleve> listeDeroulante;
	private JPanel myPanel;
	private boolean hasJoueur = true;
	private JButton play, admin;
	private int sizeFenX, sizeFenY;
	
	public PrincipaleWindow(Controller c) {
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
    		// Label "Sélectionnez un joueur"
    	JLabel sousTitre = new JLabel("Sélectionnez un joueur");
    	sousTitre.setFont(new Font("Verdana", 1, 30));
    		// Liste déroulante
    	listeDeroulante = new JComboBox<Eleve>();
	    ArrayList<Eleve> eleves = new ArrayList<Eleve>();
		try {
			eleves = Eleve.getAllEleves();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for(int i=0; i< eleves.size(); i++) {
    		Eleve eleveCourant = eleves.get(i);
	    	listeDeroulante.addItem(eleveCourant);
    	}
    	
    	if(eleves.isEmpty()) {
    		hasJoueur = false;
    	}
    	
    	// LISTE DE MOTS POUR LES TESTS
    	/*String[] motsListe = {"atelier", "train", "sable", "citrouille", "ecureuil", "chataigne"};
    	ArrayList<Mot> mots = new ArrayList<Mot>();
    	try {
    		mots = Mot.getAllMots();
    	} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    	}
    	listeMots = new JComboBox<Mot>();
    	for(int i=0; i<mots.size(); i++) {
    		Mot m = mots.get(i);
    		listeMots.addItem(m);
    	}*/
			// Bouton play
		play = new JButton();
		ImageIcon imgPlay = new ImageIcon("img/boutons/boutonPlay.png");
		play.setIcon(imgPlay);
			// Label "Copyright"
		JLabel copyright = new JLabel("Copyright 2016 - Tous droits réservés");
		copyright.setFont(new Font("Verdana", 1, 15));
    		// Bouton admin
    	admin = new JButton();
    	ImageIcon imgAdmin = new ImageIcon("img/boutons/boutonAdmin.png");
    	admin.setIcon(imgAdmin);
		
		// Placement des différents éléments dans la fenêtre
    	sousTitre.setBounds(200, 200, 800, 50);
    	listeDeroulante.setBounds(195, 250, 400, 50);
    	//listeMots.setBounds(195, 300, 400, 50);
    	//play.setBounds(340, 300, 120, 120);
    	play.setBounds(340, 325, 120, 120);
    	play.setOpaque(false);
    	play.setContentAreaFilled(false);
    	play.setBorderPainted(false);
    	admin.setBounds(605, 510, 184, 60);
    	copyright.setBounds(5, 535, 400, 50);
    	
    	// Ajout des différents éléments à la fenêtre
    	myPanel.add(sousTitre);
    	myPanel.add(play);
    	myPanel.add(listeDeroulante);
    	myPanel.add(admin);
    	myPanel.add(copyright);
    	//myPanel.add(listeMots);
    	
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
    	play.addActionListener(this);
    	admin.addActionListener(this);
    	
		// Ajout du panneau à la fenêtre
    	this.setContentPane(myPanel);
	}
	
	public void setActivate() {
		this.setVisible(true);
	}

	public void setDesactivate() {
		this.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent push) {
		if (push.getSource() == play) {
		    //APPEL DE LA FENETRE CHOIX DU THEME
			Eleve eleveChoisi = (Eleve) listeDeroulante.getSelectedItem();
			//Mot motChoisi = (Mot) listeMots.getSelectedItem();
			if(hasJoueur) {
				controller.afficheChoixTheme(eleveChoisi);
			}
			else {
				controller.affichePasDeJoueur();
			}
			this.setDesactivate();
	    }
		
		if(push.getSource()==admin){
			//APPEL DE LA FENETRE ADMIN
			controller.afficheAdmin();
			this.setDesactivate();
		}
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}
