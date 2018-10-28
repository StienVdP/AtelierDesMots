package Game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoixThemeWindow extends JFrame implements ActionListener, ItemListener {		
	private Controller controller;
	private JPanel myPanel;
	private int heightButton, widthButton;
    private int posXPrintemps, posYPrintemps;
    private int sizeFenX, sizeFenY;
    private JButton bEte, bPrintemps, bAutomne, bHiver, boutonRetour;


	public ChoixThemeWindow(Controller c) {
		controller = c;

		// Définition de la taille de la fenêtre
		sizeFenX = 800;
		sizeFenY = 600;
		
		// Définition de la taille des boutons
		heightButton = 200;
    	widthButton = 200;
    	
    	// Définition de la position du premier boutton
    	posXPrintemps = 185;
    	posYPrintemps = 120;
    	
		
		// Initialisation de la fenêtre
		this.setTitle("Choisis une saison");
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
    	
    	bPrintemps = new JButton();   
    	bEte = new JButton();    	
    	bAutomne = new JButton(); 	
    	bHiver = new JButton(); 
      	boutonRetour = new JButton();
    	
    	ImageIcon imgPrintemps = new ImageIcon("img/boutons/saisonPrintemps.png");
    	ImageIcon imgEte = new ImageIcon("img/boutons/saisonEte.png");
    	ImageIcon imgAutomne = new ImageIcon("img/boutons/saisonAutomne.png");
    	ImageIcon imgHiver = new ImageIcon("img/boutons/saisonHiver.png");
    	ImageIcon imgRetour = new ImageIcon("img/boutons/boutonRetour.png");
    	
    	bPrintemps.setIcon(imgPrintemps);	
    	bEte.setIcon(imgEte);
       	bAutomne.setIcon(imgAutomne);
    	bHiver.setIcon(imgHiver);
    	boutonRetour.setIcon(imgRetour);
	
    	bPrintemps.setContentAreaFilled(false);
    	bEte.setContentAreaFilled(false);
    	bAutomne.setContentAreaFilled(false);
    	bHiver.setContentAreaFilled(false);
    	boutonRetour.setContentAreaFilled(false);
    	
    	bPrintemps.setBounds(posXPrintemps, posYPrintemps, widthButton, heightButton);
    	bAutomne.setBounds(posXPrintemps, posYPrintemps+230, widthButton, heightButton);
    	bEte.setBounds(posXPrintemps+230, posYPrintemps, widthButton, heightButton);
    	bHiver.setBounds(posXPrintemps+230, posYPrintemps+230, widthButton, heightButton);
    	boutonRetour.setBounds(20, 20, 100, 33);

    	myPanel.add(bPrintemps);
    	myPanel.add(bAutomne);
    	myPanel.add(bEte);    	
    	myPanel.add(bHiver);
    	myPanel.add(boutonRetour);
		
    	// Ajout d'une image de fond
    	try {
    	    BufferedImage myPicture;
    	    myPicture = ImageIO.read(new File("img/config/choixSaison.png"));
    	    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
    	    picLabel.setBounds(0, 0, 800, 600);
    	    myPanel.add(picLabel);
    	} catch (IOException e) {
    	    // TODO Auto-generated catch block
    	    e.printStackTrace();
    	}
    	
    	// Mise à l'écoute des événements sur les boutons
    	bEte.addActionListener(this);
    	bPrintemps.addActionListener(this);
    	bHiver.addActionListener(this);
    	bAutomne.addActionListener(this);
    	boutonRetour.addActionListener(this);
    	
		// Ajout du panneau à la fenêtre
    	this.setContentPane(myPanel);
	}
	
	public void actionPerformed(ActionEvent push) {
		if (push.getSource() == bEte) {
		    //APPEL DE LA FENETRE CHOIX DU NIVEAU POUR ETE
			try {
				Theme t = new Theme("Ete");
				controller.afficheChoixNiveau(t);
			} catch(SQLException e) {
				
			}
	    }
		
		if (push.getSource() == bPrintemps) {
		    //APPEL DE LA FENETRE CHOIX DU NIVEAU POUR PRINTEMPS
			try {
				Theme t = new Theme("Printemps");
				controller.afficheChoixNiveau(t);
			} catch(SQLException e) {
				
			}
	    }
		
		if (push.getSource() == bHiver) {
		    //APPEL DE LA FENETRE CHOIX DU NIVEAU POUR HIVER
			try {
				Theme t = new Theme("Hiver");
				controller.afficheChoixNiveau(t);
			} catch(SQLException e) {
				
			}
	    }
		
		if (push.getSource() == bAutomne) {
		    //APPEL DE LA FENETRE CHOIX DU NIVEAU POUR AUTOMNE
			try {
				Theme t = new Theme("Automne");
				controller.afficheChoixNiveau(t);
			} catch(SQLException e) {
				
			}
	    }
		
		if(push.getSource() == boutonRetour) {
			//APPEL DE LA FENETRE ACCUEIL
			controller.afficheFenetreAccueil();
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
