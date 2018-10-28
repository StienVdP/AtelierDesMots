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
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AjouterMotWindow extends JFrame implements ActionListener, ItemListener {

    private Controller controller;
	private JPanel myPanel;
	private JButton ajouterMot, boutonRetour, ouvrirFichier;
	private int sizeFenX, sizeFenY;
    private JTextField TexteLibelleMot = new JTextField("");
    private JCheckBox checkN1 = new JCheckBox("Niveau 1");
    private JCheckBox checkN2 = new JCheckBox("Niveau 2");
    private JCheckBox checkPrintemps = new JCheckBox("Printemps");
    private JCheckBox checkEte = new JCheckBox("Ete");
    private JCheckBox checkAutomne = new JCheckBox("Automne");
    private JCheckBox checkHiver = new JCheckBox("Hiver");
	private JFileChooser chercheFichier;
	private String nomFichier, extension;
    private JLabel image;
    private JTextField TexteLibelleImage = new JTextField("");

	public AjouterMotWindow(Controller c){
		controller = c;
		
		// Définition de la taille de la fenêtre
		sizeFenX = 800;
		sizeFenY = 600;
		
		// Initialisation de la fenêtre
		this.setTitle("Administration - Ajouter un Mot");
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

    	JLabel sousTitre = new JLabel("Ajouter un mot");
    	sousTitre.setFont(new Font("Verdana", 1, 30));

    	JLabel libelleMot = new JLabel("Mot");
    	libelleMot.setFont(new Font("Verdana",1,20));

    	JLabel img = new JLabel("Image");
        img.setFont(new Font("Verdana",1,20));


    	// Check box niveaux
        JLabel niveau = new JLabel("Niveau :");
        niveau.setFont(new Font("Verdana",1,20));
        checkN1.addActionListener(new StateListener());
    	JLabel niveau1 = new JLabel("1");
    	niveau1.setFont(new Font("Verdana",1,15));
        checkN2.addActionListener(new StateListener());
    	JLabel niveau2 = new JLabel("2");
    	niveau2.setFont(new Font("Verdana",1,15));
    	
    	// Check box thèmes
        JLabel themes = new JLabel("Thèmes :");
        themes.setFont(new Font("Verdana",1,20));
    	checkPrintemps.addActionListener(new StateListener());
    	checkEte.addActionListener(new StateListener());
    	checkAutomne.addActionListener(new StateListener());
    	checkHiver.addActionListener(new StateListener());
    	JLabel printemps = new JLabel("Printemps");
    	printemps.setFont(new Font("Verdana",1,15));
    	JLabel ete = new JLabel("Été");
    	ete.setFont(new Font("Verdana",1,15));
    	JLabel automne = new JLabel("Automne");
    	automne.setFont(new Font("Verdana",1,15));
    	JLabel hiver = new JLabel("Hiver");
    	hiver.setFont(new Font("Verdana",1,15));
        
		// Bouton retour
    	boutonRetour = new JButton();
        ImageIcon imgRetour = new ImageIcon("img/boutons/boutonRetour.png");
        boutonRetour.setIcon(imgRetour);
        boutonRetour.setContentAreaFilled(false);

		// Bouton ajouterMot
		ajouterMot = new JButton();
		ImageIcon imgAjouter = new ImageIcon("img/boutons/ajouter.png");
		ajouterMot.setIcon(imgAjouter);
		ajouterMot.setContentAreaFilled(false);
		
		// Bouton pour ajouter une image
	    chercheFichier = new JFileChooser();
	    nomFichier = "";
		ouvrirFichier = new JButton("..."); 
		ouvrirFichier.setFont(new Font("Verdana",1,15));
		ImageIcon imgChercher = new ImageIcon("img/boutons/chercher.png");
		ouvrirFichier.setIcon(imgChercher);
    	
    	// Placement
    	sousTitre.setBounds(260, 30, 800, 50);
    	
    	libelleMot.setBounds(100,150,150,40);
    	TexteLibelleMot.setBounds(100,180,250,50);
    	
    	img.setBounds(400,150,150, 40);
    	TexteLibelleImage.setBounds(400,180,250,50);
    	ouvrirFichier.setBounds(650,180,50,50);
    	
    	niveau.setBounds(328, 250, 100, 40);
        checkN1.setBounds(330, 290, 25, 25);
        niveau1.setBounds(355, 285, 100, 40);
        checkN2.setBounds(375, 290, 25, 25);
        niveau2.setBounds(400, 285, 100, 40);
        
    	themes.setBounds(325, 340, 150, 40);
    	checkPrintemps.setBounds(195, 380, 25, 25);
    	printemps.setBounds(220, 375, 100, 40);
    	checkEte.setBounds(325, 380, 25, 25);
    	ete.setBounds(350, 375, 100, 40);
    	checkAutomne.setBounds(395, 380, 25, 25);
    	automne.setBounds(420, 375, 100, 40);
    	checkHiver.setBounds(510, 380, 25, 25);
    	hiver.setBounds(535, 375, 100, 40);
    	
    	ajouterMot.setBounds(240,450,310,66);
    	
    	boutonRetour.setBounds(20, 20, 100, 33);
    	
    	TexteLibelleImage.setEditable(false);
    	
    	// Ajout des éléments à la fenêtre
    	myPanel.add(sousTitre);
    	myPanel.add(libelleMot);
    	myPanel.add(TexteLibelleMot);
    	myPanel.add(ajouterMot);
    	myPanel.add(img);
    	myPanel.add(TexteLibelleImage);
	    myPanel.add(ouvrirFichier);
    	myPanel.add(niveau);
    	myPanel.add(checkN1);
    	myPanel.add(niveau1);
    	myPanel.add(checkN2);
    	myPanel.add(niveau2);
    	myPanel.add(themes);
    	myPanel.add(checkPrintemps);
    	myPanel.add(printemps);
    	myPanel.add(checkEte);
    	myPanel.add(ete);
    	myPanel.add(checkAutomne);
    	myPanel.add(automne);
    	myPanel.add(checkHiver);
    	myPanel.add(hiver);
    	myPanel.add(boutonRetour);
		
    	// Mise à l'écoute des évènements sur les boutons
    	ajouterMot.addActionListener(this);
    	boutonRetour.addActionListener(this);
    	ouvrirFichier.addActionListener(this);
		
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
		
		if(push.getSource() == ouvrirFichier){ // Cherche une image
			// On définit les extensions que l'on accepte
			FileFilter imagesFilter = new FileNameExtensionFilter("Images (.bmp, .gif, .jpg, .jpeg, .png)", "bmp", "gif", "jpg", "jpeg", "png");
			chercheFichier.addChoosableFileFilter(imagesFilter);
			chercheFichier.setFileFilter(imagesFilter);
			if (chercheFichier.showDialog(myPanel, "Selectionez une image")==JFileChooser.APPROVE_OPTION) {
		         File fichier = chercheFichier.getSelectedFile();
		         nomFichier = fichier.toString();
		     	 TexteLibelleImage.setText(nomFichier);
		     	 // Récupère l'extension ex = ".png"
		     	 extension = nomFichier.substring(nomFichier.lastIndexOf("."));
		     	 extension = extension.substring(1); // Enleve le . de l'extension
		     	 System.out.println("EXTENSION : " + extension);
			}
		}		
		if (push.getSource() == ajouterMot){
			// AJOUT DU MOT A LA BASE DE DONNEES
	    	String libelMot = TexteLibelleMot.getText();
	    	String img;
			if(nomFichier != ""){
				saveImage(libelMot, nomFichier);
				img = "img/mots/"+ libelMot + '.' +extension;
			}
			else{
				img = "NULL";
			}
			// Initialisation des niveaux
	    	int n1 = 0;
	    	int n2 = 0;
	    	// Récupère la valeur des checkbox pour chaque niveaux
	    	if (checkN1.isSelected()){
	    		n1=1;
	    		System.out.println(n1);
	    	}
	    	if (checkN2.isSelected()){
	    		n2=1;
	    		System.out.println(n2);

	    	}	
	    	try { // Insertion du mot dans la base de données
	    		Mot newMot = Mot.ajouterMot(libelMot, img, n1, n2); 
	    		// Création d'un tableau pour les thèmes que l'on rempli suivant les valeurs des checkbox
		    	int[] tabThemes = {0,0,0,0}; 
		    	if(checkHiver.isSelected()){
		    		tabThemes[0] = 1;
		    	}
		    	if(checkAutomne.isSelected()){
		    		tabThemes[1] = 1;
		    	}
		    	if(checkPrintemps.isSelected()){
		    		tabThemes[2] = 1;
		    	}
		    	if(checkEte.isSelected()){
		    		tabThemes[3] = 1;
		    	}
		    	try { // insertion de chaque liaison entre le mot et les thèmes dans la base de données
		    		newMot.ajouterThemeMot(tabThemes);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    	
		    //APPEL DE LA FENETRE DE CONFIRMATION
			controller.afficheConfirmationAjouterMot();
			this.setDesactivate();
		}
		if(push.getSource() == boutonRetour) {
			//APPEL DE LA FENETRE CHOIX THEME
			controller.afficheGestionMot(); // a faire
			this.setDesactivate();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void saveImage(String nomMot, String p_name){
    	try {
			BufferedImage monImage;		
			monImage = ImageIO.read(new File(p_name));
			File outputfile = new File("img/mots/"+ nomMot + '.' + extension);
			ImageIO.write(monImage, extension, outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

class StateListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      System.out.println("source : " + ((JCheckBox)e.getSource()).getText() + " - état : " + ((JCheckBox)e.getSource()).isSelected());
    }
  }
