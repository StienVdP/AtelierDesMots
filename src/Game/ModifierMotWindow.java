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
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ModifierMotWindow extends JFrame implements ActionListener {

    private Controller controller;
	private JPanel myPanel;
	private JButton modifierMot, boutonRetour, ouvrirFichier;
	private int sizeFenX, sizeFenY;
    private JCheckBox checkN1 = new JCheckBox("Niveau 1");
    private JCheckBox checkN2 = new JCheckBox("Niveau 2");
    private JCheckBox checkPrintemps = new JCheckBox("Printemps");
    private JCheckBox checkEte = new JCheckBox("Ete");
    private JCheckBox checkAutomne = new JCheckBox("Automne");
    private JCheckBox checkHiver = new JCheckBox("Hiver");
	private JFileChooser chercheFichier;
	private String nomFichier;
	private Mot modMot;
    private JLabel image;

    //private JTextField TexteLibelleMot = new JTextField("");
    //private JTextField TexteLibelleImage = new JTextField("");
    private JTextField TexteLibelleMot;
    private JTextField TexteLibelleImage;
	
	public ModifierMotWindow(Controller c, Mot m) {

		controller = c;
		modMot = m;

		System.out.println(modMot.getLibelleMot());
		System.out.println(modMot.getImage());

		// Définition de la taille de la fenêtre
		sizeFenX = 800;
		sizeFenY = 600;
		
		// Initialisation de la fenêtre
		this.setTitle("Administration - Modifier un Mot");
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

    	JLabel sousTitre = new JLabel("Modifier un mot");
    	sousTitre.setFont(new Font("Verdana", 1, 30));

    	JLabel libelleMot = new JLabel("Mot");
    	libelleMot.setFont(new Font("Verdana",1,20));
    	TexteLibelleMot = new JTextField(modMot.getLibelleMot());

    	JLabel img = new JLabel("Image");
        img.setFont(new Font("Verdana",1,20));
        TexteLibelleImage = new JTextField(modMot.getImage());
        TexteLibelleImage.setEditable(false);
        
    	// Check box niveaux
        checkN1 = new JCheckBox("Niveau 1", modMot.isN1());
        checkN2 = new JCheckBox("Niveau 2", modMot.isN2());
        JLabel niveau = new JLabel("Niveau :");
        niveau.setFont(new Font("Verdana",1,20));
        checkN1.addActionListener(new StateListener());
    	JLabel niveau1 = new JLabel("1");
    	niveau1.setFont(new Font("Verdana",1,15));
        checkN2.addActionListener(new StateListener());
    	JLabel niveau2 = new JLabel("2");
    	niveau2.setFont(new Font("Verdana",1,15));
    	
    	// Check box thèmes
    	ArrayList<Theme> ARthemes = new ArrayList<Theme>();
		try {
			ARthemes = modMot.getThemesMot();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	int[] tabThemes = {0,0,0,0};
		for(int i=0; i<ARthemes.size(); i++) {
			tabThemes[ARthemes.get(i).getIdTheme()-1] = 1;
		}
    	if(tabThemes[0] == 1){
    		checkHiver = new JCheckBox("Hiver", true);
    	}
    	if(tabThemes[1] == 1){
    		checkAutomne = new JCheckBox("Automne", true);
    	}
    	if(tabThemes[2] == 1){
    		checkPrintemps = new JCheckBox("Printemps", true);
    	}
    	if(tabThemes[3] == 1){
    		checkEte = new JCheckBox("Ete", true);
    	}
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

		// Bouton modifierMot
		modifierMot = new JButton();
		ImageIcon imgAjouter = new ImageIcon("img/boutons/modifier.png");
		modifierMot.setIcon(imgAjouter);
		modifierMot.setContentAreaFilled(false);
        
		// Bouton pour ajouter une image
	    chercheFichier = new JFileChooser();
	    nomFichier = "";
		ouvrirFichier = new JButton("..."); 
		ouvrirFichier.setFont(new Font("Verdana",1,15));
    	
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
    	
    	modifierMot.setBounds(240,450,310,66);
    	
    	boutonRetour.setBounds(20, 20, 100, 33);
        	
    	// Ajout des éléments à la fenêtre
    	myPanel.add(sousTitre);
    	myPanel.add(libelleMot);
    	myPanel.add(TexteLibelleMot);
    	myPanel.add(modifierMot);
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
    	modifierMot.addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent push) {
		// TODO Auto-generated method stub
		if(push.getSource() == ouvrirFichier){ // Cherche une image
			// On définit les extensions que l'on accepte
			FileFilter imagesFilter = new FileNameExtensionFilter("Images (.bmp, .gif, .jpg, .jpeg, .png)", "bmp", "gif", "jpg", "jpeg", "png");
			chercheFichier.addChoosableFileFilter(imagesFilter);
			chercheFichier.setFileFilter(imagesFilter);
			if (chercheFichier.showDialog(myPanel, "Selectionez un fichier")==JFileChooser.APPROVE_OPTION) {
		         File fichier = chercheFichier.getSelectedFile();
		         nomFichier = fichier.toString();
		     	 TexteLibelleImage.setText(nomFichier);
			}
		}			
		if(push.getSource() == boutonRetour) {
			controller.afficheGestionMot(); 
			this.setDesactivate();
		}
		if(push.getSource() == modifierMot) {
			String libelMot = TexteLibelleMot.getText();
			modMot.setLibelleMot(libelMot);
	    	String oldImage = modMot.getImage();
	    	String oldExtension = "";
	    	String newNomFichier = TexteLibelleImage.getText();
	    	String newExtension = "";
	    	String img = "";
	    	System.out.println(oldImage);
	    	if (oldImage != "NULL" && oldImage != "" && oldImage != null && oldImage != "null"){
	    		int lastIO = oldImage.lastIndexOf(".");
	    		if(lastIO > 0) {
			    	oldExtension = oldImage.substring(lastIO);
			     	oldExtension = oldExtension.substring(1); // Enleve le . de l'extension
	    		}
	    		else {
	    			oldExtension = "lala";
	    		}
//		    	controller.supprimerImage(oldImage);
		    	System.out.println("OLD EXTENSION : " + oldExtension);
	    	}
    		newExtension = newNomFichier.substring(newNomFichier.lastIndexOf(".")); 
    		newExtension = newExtension.substring(1); // Enleve le . de l'extension
	     	System.out.println("NEW EXTENSION : " + newExtension);
			if(newNomFichier != ""){
				if (oldExtension != null && oldExtension != "" && oldExtension == newExtension){
					img = "img/mots/"+ libelMot + '.' + oldExtension;
					saveImage(libelMot, newNomFichier, oldExtension);
			    	controller.supprimerImage(oldImage);
				}
				else {
					img = "img/mots/"+ libelMot + '.' + newExtension;
					saveImage(libelMot, newNomFichier, newExtension);
			    	controller.supprimerImage(oldImage);
				}
			}
			else if (newNomFichier == ""){
				img = "NULL";
			}
	    	modMot.setImage(img);
    		modMot.setN1(0);
    		modMot.setN2(0);
	    	if (checkN1.isSelected()){
	    		modMot.setN1(1);
	    	}
	    	if (checkN2.isSelected()){
	    		modMot.setN2(1);
	    	}

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
	    	
			System.out.println(modMot);
			try {
				Mot.modifierMot(modMot, tabThemes);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			controller.afficheConfirmationModifierMot(); 
			this.setDesactivate();
		}
	}
    
	public void saveImage(String nomMot, String p_name, String extension){
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
