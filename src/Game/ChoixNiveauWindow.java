package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoixNiveauWindow extends JFrame implements ActionListener, ItemListener {
	
	private Controller controller;
	private JPanel myPanel;
	private JButton bNv1, bNv2, boutonRetour;
    private int sizeFenX, sizeFenY;
    private int heightButton, widthButton;
    private int posXBoutonNv1, posYBoutonNv1;
	
	public ChoixNiveauWindow(Controller c){
		
		controller = c;
		
		// Définition de la taille de la fenêtre
		sizeFenX = 800;
		sizeFenY = 600;
		
		// Définition de la taille des boutons
    	heightButton = 262;
    	widthButton = 262;
    	
    	
    	posXBoutonNv1 = 119;
    	posYBoutonNv1 = 200;
    	
		// Initialisation de la fenêtre
		this.setTitle("Choix du niveau");
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
      	bNv1 = new JButton();
      	bNv2 = new JButton();
      	boutonRetour = new JButton();
      	
    	ImageIcon imgNiveau1 = new ImageIcon("img/boutons/niveauUn.png");
    	ImageIcon imgNiveau2 = new ImageIcon("img/boutons/niveauDeux.png");
    	ImageIcon imgRetour = new ImageIcon("img/boutons/boutonRetour.png");
    	
    	bNv1.setIcon(imgNiveau1);
    	bNv2.setIcon(imgNiveau2);
    	boutonRetour.setIcon(imgRetour);
      	
    	bNv1.setContentAreaFilled(false);
    	bNv2.setContentAreaFilled(false);
    	boutonRetour.setContentAreaFilled(false);
    	
    	bNv1.setBounds(posXBoutonNv1, posYBoutonNv1, widthButton, heightButton);
    	bNv2.setBounds(posXBoutonNv1+300, posYBoutonNv1, widthButton, heightButton);
    	boutonRetour.setBounds(20, 20, 100, 33);
    	
    	myPanel.add(bNv1);
    	myPanel.add(bNv2);
    	myPanel.add(boutonRetour);
    	
		// Ajout d'une image de fond
    	try {
    	    BufferedImage myPicture;
    	    myPicture = ImageIO.read(new File("img/config/choixNiveau.png"));
    	    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
    	    picLabel.setBounds(0, 0, 800, 600);
    	    myPanel.add(picLabel);
    	} catch (IOException e) {
    	    // TODO Auto-generated catch block
    	    e.printStackTrace();
    	}
    	
    	// Mise à l'écoute des événements sur les boutons
    	bNv1.addActionListener(this);
    	bNv2.addActionListener(this);
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
	
	public void actionPerformed(ActionEvent push) {
		if (push.getSource() == bNv1) {
		    //APPEL DE LA FENETRE JEU NIVEAU 1
			controller.setNiveau(1);
			this.setDesactivate();
	    }
		
		if (push.getSource() == bNv2) {
		    //APPEL DE LA FENETRE JEU NIVEAU 2
			controller.setNiveau(2);
			this.setDesactivate();
	    }
		
		if(push.getSource() == boutonRetour) {
			//APPEL DE LA FENETRE CHOIX THEME
			controller.afficheChoixTheme(controller.getJoueur());
			this.setDesactivate();
		}
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}
