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

public class ConfirmationAjouterMot extends JFrame implements ActionListener, ItemListener {
	
    private JTextField texte = new JTextField(" ");
	private Controller controller;
	private JPanel myPanel;
	private JButton boutonRetour;
	private int sizeFenX, sizeFenY;
	
	public ConfirmationAjouterMot(Controller c) {
		controller = c;
		
		// Définition de la taille de la fenÃªtre
		sizeFenX = 800;
		sizeFenY = 600;
		
		// Initialisation de la fenÃªtre
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
		
    	// Initialisation des diffÃ©rents Ã©lÃ©ments
    	JLabel sousTitre = new JLabel("Ajouter un mot");
    	JLabel confirmationAjout = new JLabel("Mot ajouté avec succés");
    	sousTitre.setFont(new Font("Verdana", 1, 30));
        confirmationAjout.setFont(new Font("Verdana",1,15));
    	
		// Bouton retour
    	boutonRetour = new JButton();
        ImageIcon imgRetour = new ImageIcon("img/boutons/boutonRetour.png");
        boutonRetour.setIcon(imgRetour);
        boutonRetour.setContentAreaFilled(false);
        
		// Placement des diffÃ©rents Ã©lÃ©ments dans la fenÃªtre
    	sousTitre.setBounds(240, 200, 800, 50);
    	confirmationAjout.setBounds(275,300,400, 50);
    	//boutonRetour.setBounds(660, 520, 100, 33);
    	boutonRetour.setBounds(20, 20, 100, 33);
    	
    	// Ajout des diffÃ©rents Ã©lÃ©ments Ã  la fenÃªtre
    	myPanel.add(sousTitre);
    	myPanel.add(confirmationAjout);
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
    	
    	// Mise Ã  l'Ã©coute des Ã©vÃ©nements sur les boutons
    	boutonRetour.addActionListener(this);
    	
		// Ajout du panneau Ã  la fenÃªtre
    	this.setContentPane(myPanel);
	}
	
	public void setActivate() {
		this.setVisible(true);
	}

	public void setDesactivate() {
		this.setVisible(false);
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == boutonRetour) {
			controller.afficheGestionMot();
			this.setDesactivate();
		}
	}
	

}

  