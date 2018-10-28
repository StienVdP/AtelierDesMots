package Game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public abstract class ThemeWindow extends JFrame implements ActionListener, ItemListener {
	
	private Controller controller;
	private Panneau myPanel;
	private JButton boutonRetour;//, boutonPasser;
	private JLabel cvp1, cvp2, cvp3, cvp4, cvp5, cvp6, cvp7, cvp8, cvp9, cvp10, cvi1, cvi2, cvi3, cvi4, cvi5, cvi6, cvi7, cvi8, cvi9, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16;
    private int sizeFenX, sizeFenY;
    private int heightButton, widthButton;
    private int posXcv1, posYcv1;
	private static String cheminFond = "img/config/";
	private ArrayList<JLabel> casesLettresActives, casesVidesActives;
    private Point[][] positions;
    private ArrayList<Integer> pointsFixesEtat, recompositionIndices;
    private ArrayList<Point> pointsFixes, pointsMobiles;
    //private ArrayList<Mot> listeDesMots;
    private Mot motChoisi;
	
	public ThemeWindow(Controller c) {
		controller = c;
		
		//listeDesMots = c.getListeDesMots();
		
		// Définition de la taille de la fenêtre
		sizeFenX = 800;
		sizeFenY = 600;
		
		// Définition de la taille des boutons cases vides
    	heightButton = 70;
    	widthButton = 70;
    	
    	posXcv1 = 5;
    	posYcv1 = 340;
		
		// Initialisation de la fenêtre
    	this.setSize(sizeFenX, sizeFenY);
    	this.setLocationRelativeTo(null);
    	this.setResizable(false);
    	this.setAlwaysOnTop(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setLayout(null);
		
		// Initialisation du panneau
		myPanel = new Panneau();
    	myPanel.setBackground(new Color(252,246,232));
    	myPanel.setLayout(null);
    	
		// Placement des différents éléments dans la fenêtre
    	
      	boutonRetour = new JButton();
      	//boutonPasser = new JButton();
      	cvp1 = new JLabel();
      	cvp2 = new JLabel();
      	cvp3 = new JLabel();
      	cvp4 = new JLabel();
      	cvp5 = new JLabel();
      	cvp6 = new JLabel();
      	cvp7 = new JLabel();
      	cvp8 = new JLabel();
      	cvp9 = new JLabel();
      	cvp10 = new JLabel();
      	cvi1 = new JLabel();
      	cvi2 = new JLabel();
      	cvi3 = new JLabel();
      	cvi4 = new JLabel();
      	cvi5 = new JLabel();
      	cvi6 = new JLabel();
      	cvi7 = new JLabel();
      	cvi8 = new JLabel();
      	cvi9 = new JLabel();
      	l1 = new JLabel();
      	l2 = new JLabel();
      	l3 = new JLabel();
      	l4 = new JLabel();
      	l5 = new JLabel();
      	l6 = new JLabel();
      	l7 = new JLabel();
      	l8 = new JLabel();
      	l9 = new JLabel();
      	l10 = new JLabel();
      	l11 = new JLabel();
      	l12 = new JLabel();
      	l13 = new JLabel();
      	l14 = new JLabel();
      	
    	ImageIcon imgRetour = new ImageIcon("img/boutons/boutonRetour.png");
    	ImageIcon imgPasser = new ImageIcon("img/boutons/boutonPasser.png");
    	ImageIcon imgcv = new ImageIcon("img/casesVides2.png");
    	
    	boutonRetour.setIcon(imgRetour);
    	//boutonPasser.setIcon(imgPasser);
    	cvp1.setIcon(imgcv);
       	cvp2.setIcon(imgcv);   	
       	cvp3.setIcon(imgcv);
       	cvp4.setIcon(imgcv);
       	cvp5.setIcon(imgcv);
    	cvp6.setIcon(imgcv);
       	cvp7.setIcon(imgcv);   	
       	cvp8.setIcon(imgcv);
       	cvp9.setIcon(imgcv);
       	cvp10.setIcon(imgcv);
    	cvi1.setIcon(imgcv);
       	cvi2.setIcon(imgcv);   	
       	cvi3.setIcon(imgcv);
       	cvi4.setIcon(imgcv);
       	cvi5.setIcon(imgcv);
    	cvi6.setIcon(imgcv);
       	cvi7.setIcon(imgcv);   	
       	cvi8.setIcon(imgcv);
       	cvi9.setIcon(imgcv);
       	l1.setIcon(imgcv);
       	l2.setIcon(imgcv);
       	l3.setIcon(imgcv);
       	l4.setIcon(imgcv);
       	l5.setIcon(imgcv);
       	l6.setIcon(imgcv);
       	l7.setIcon(imgcv);
       	l8.setIcon(imgcv);
       	l9.setIcon(imgcv);
       	l10.setIcon(imgcv);
       	l11.setIcon(imgcv);
       	l12.setIcon(imgcv);
       	l13.setIcon(imgcv);
       	l14.setIcon(imgcv);

    	boutonRetour.setContentAreaFilled(false);
    	//boutonPasser.setContentAreaFilled(false);
    	/*cvp1.setContentAreaFilled(false);
    	cvp2.setContentAreaFilled(false);
    	cvp3.setContentAreaFilled(false);
    	cvp4.setContentAreaFilled(false);
    	cvp5.setContentAreaFilled(false);
    	cvp6.setContentAreaFilled(false);
    	cvp7.setContentAreaFilled(false);
    	cvp8.setContentAreaFilled(false);
    	cvp9.setContentAreaFilled(false);
    	cvp10.setContentAreaFilled(false);
    	cvi1.setContentAreaFilled(false);
    	cvi2.setContentAreaFilled(false);
    	cvi3.setContentAreaFilled(false);
    	cvi4.setContentAreaFilled(false);
    	cvi5.setContentAreaFilled(false);
    	cvi6.setContentAreaFilled(false);
    	cvi7.setContentAreaFilled(false);
    	cvi8.setContentAreaFilled(false);
    	cvi9.setContentAreaFilled(false);
    	l1.setContentAreaFilled(false);
    	l2.setContentAreaFilled(false);
    	l3.setContentAreaFilled(false);
    	l4.setContentAreaFilled(false);
    	l5.setContentAreaFilled(false);
    	l6.setContentAreaFilled(false);
    	l7.setContentAreaFilled(false);
    	l8.setContentAreaFilled(false);
    	l9.setContentAreaFilled(false);
    	l10.setContentAreaFilled(false);
    	l11.setContentAreaFilled(false);
    	l12.setContentAreaFilled(false);
    	l13.setContentAreaFilled(false);
    	l14.setContentAreaFilled(false);*/

    	boutonRetour.setOpaque(false);
    	//boutonPasser.setOpaque(false);
    	cvp1.setOpaque(false);
    	cvp2.setOpaque(false);
    	cvp3.setOpaque(false);
    	cvp4.setOpaque(false);
    	cvp5.setOpaque(false);
    	cvp6.setOpaque(false);
    	cvp7.setOpaque(false);
    	cvp8.setOpaque(false);
    	cvp9.setOpaque(false);
    	cvp10.setOpaque(false);
    	cvi1.setOpaque(false);
    	cvi2.setOpaque(false);
    	cvi3.setOpaque(false);
    	cvi4.setOpaque(false);
    	cvi5.setOpaque(false);
    	cvi6.setOpaque(false);
    	cvi7.setOpaque(false);
    	cvi8.setOpaque(false);
    	cvi9.setOpaque(false);
    	l1.setOpaque(false);
    	l2.setOpaque(false);
    	l3.setOpaque(false);
    	l4.setOpaque(false);
    	l5.setOpaque(false);
    	l6.setOpaque(false);
    	l7.setOpaque(false);
    	l8.setOpaque(false);
    	l9.setOpaque(false);
    	l10.setOpaque(false);
    	l11.setOpaque(false);
    	l12.setOpaque(false);
    	l13.setOpaque(false);
    	l14.setOpaque(false);
    	
    	boutonRetour.setBorderPainted(false);
    	//boutonPasser.setBorderPainted(false);
    	/*cvp1.setBorderPainted(false);
    	cvp2.setBorderPainted(false);
    	cvp3.setBorderPainted(false);
    	cvp4.setBorderPainted(false);
    	cvp5.setBorderPainted(false);
    	cvp6.setBorderPainted(false);
    	cvp7.setBorderPainted(false);
    	cvp8.setBorderPainted(false);
    	cvp9.setBorderPainted(false);
    	cvp10.setBorderPainted(false);
    	cvi1.setBorderPainted(false);
    	cvi2.setBorderPainted(false);
    	cvi3.setBorderPainted(false);
    	cvi4.setBorderPainted(false);
    	cvi5.setBorderPainted(false);
    	cvi6.setBorderPainted(false);
    	cvi7.setBorderPainted(false);
    	cvi8.setBorderPainted(false);
    	cvi9.setBorderPainted(false);
    	l1.setBorderPainted(false);
    	l2.setBorderPainted(false);
    	l3.setBorderPainted(false);
    	l4.setBorderPainted(false);
    	l5.setBorderPainted(false);
    	l6.setBorderPainted(false);
    	l7.setBorderPainted(false);
    	l8.setBorderPainted(false);
    	l9.setBorderPainted(false);
    	l10.setBorderPainted(false);
    	l11.setBorderPainted(false);
    	l12.setBorderPainted(false);
    	l13.setBorderPainted(false);
    	l14.setBorderPainted(false);*/

    	boutonRetour.setBounds(20, 20, 100, 33);
    	//boutonPasser.setBounds(680, 20, 100, 33);
    	// Cases vides quand mot de longueur pair
    	cvp1.setBounds(posXcv1, posYcv1, widthButton, heightButton);
    	cvp2.setBounds(posXcv1+80, posYcv1, widthButton, heightButton);
    	cvp3.setBounds(posXcv1+160, posYcv1, widthButton, heightButton );
    	cvp4.setBounds(posXcv1+240, posYcv1, widthButton, heightButton);
    	cvp5.setBounds(posXcv1+320, posYcv1, widthButton, heightButton);
    	cvp6.setBounds(posXcv1+400, posYcv1, widthButton, heightButton);
    	cvp7.setBounds(posXcv1+480, posYcv1, widthButton, heightButton);
    	cvp8.setBounds(posXcv1+560, posYcv1, widthButton, heightButton );
    	cvp9.setBounds(posXcv1+640, posYcv1, widthButton, heightButton);
    	cvp10.setBounds(posXcv1+720, posYcv1, widthButton, heightButton);
    	// Cases vides quand mot de longueur impair
    	cvi1.setBounds(posXcv1+40, posYcv1, widthButton, heightButton);
    	cvi2.setBounds(posXcv1+120, posYcv1, widthButton, heightButton);
    	cvi3.setBounds(posXcv1+200, posYcv1, widthButton, heightButton );
    	cvi4.setBounds(posXcv1+280, posYcv1, widthButton, heightButton);
    	cvi5.setBounds(posXcv1+360, posYcv1, widthButton, heightButton);
    	cvi6.setBounds(posXcv1+440, posYcv1, widthButton, heightButton);
    	cvi7.setBounds(posXcv1+520, posYcv1, widthButton, heightButton);
    	cvi8.setBounds(posXcv1+600, posYcv1, widthButton, heightButton );
    	cvi9.setBounds(posXcv1+680, posYcv1, widthButton, heightButton);
    	l1.setBounds(posXcv1+120, posYcv1+heightButton+15, widthButton, heightButton);
    	l2.setBounds(posXcv1+200, posYcv1+heightButton+15, widthButton, heightButton);
    	l3.setBounds(posXcv1+280, posYcv1+heightButton+15, widthButton, heightButton);
    	l4.setBounds(posXcv1+360, posYcv1+heightButton+15, widthButton, heightButton);
    	l5.setBounds(posXcv1+440, posYcv1+heightButton+15, widthButton, heightButton);
    	l6.setBounds(posXcv1+520, posYcv1+heightButton+15, widthButton, heightButton);
    	l7.setBounds(posXcv1+600, posYcv1+heightButton+15, widthButton, heightButton);
    	l8.setBounds(posXcv1+120, posYcv1+2*heightButton+20, widthButton, heightButton);
    	l9.setBounds(posXcv1+200, posYcv1+2*heightButton+20, widthButton, heightButton);
    	l10.setBounds(posXcv1+280, posYcv1+2*heightButton+20, widthButton, heightButton);
    	l11.setBounds(posXcv1+360, posYcv1+2*heightButton+20, widthButton, heightButton);
    	l12.setBounds(posXcv1+440, posYcv1+2*heightButton+20, widthButton, heightButton);
    	l13.setBounds(posXcv1+520, posYcv1+2*heightButton+20, widthButton, heightButton);
    	l14.setBounds(posXcv1+600, posYcv1+2*heightButton+20, widthButton, heightButton);

    	myPanel.add(boutonRetour);
    	//myPanel.add(boutonPasser);
    	myPanel.add(cvp1);
    	myPanel.add(cvp2);
    	myPanel.add(cvp3);
    	myPanel.add(cvp4);
    	myPanel.add(cvp5);
    	myPanel.add(cvp6);
    	myPanel.add(cvp7);
    	myPanel.add(cvp8);
    	myPanel.add(cvp9);
    	myPanel.add(cvp10);
    	myPanel.add(cvi1);
    	myPanel.add(cvi2);
    	myPanel.add(cvi3);
    	myPanel.add(cvi4);
    	myPanel.add(cvi5);
    	myPanel.add(cvi6);
    	myPanel.add(cvi7);
    	myPanel.add(cvi8);
    	myPanel.add(cvi9);
    	myPanel.add(l1);
    	myPanel.add(l2);
    	myPanel.add(l3);
    	myPanel.add(l4);
    	myPanel.add(l5);
    	myPanel.add(l6);
    	myPanel.add(l7);
    	myPanel.add(l8);
    	myPanel.add(l9);
    	myPanel.add(l10);
    	myPanel.add(l11);
    	myPanel.add(l12);
    	myPanel.add(l13);
    	myPanel.add(l14);
    	
    	ArrayList<Character> associationLettreCouleur = new ArrayList<Character>();
    	motChoisi = controller.getMot();
    	String mot = motChoisi.getLibelleMot();
    	mot = Controller.stringUpperCase(mot);
    	char[] motChar = mot.toCharArray();
    	for(int i=0; i<motChar.length; i++) {
    		if(!associationLettreCouleur.contains((Character) Controller.charUpperCase(motChar[i]))) {
    			associationLettreCouleur.add((Character) Controller.charUpperCase(motChar[i]));
    		}
    	}
    	
    	JLabel tabCVp[] = {cvp1, cvp2, cvp3, cvp4, cvp5, cvp6, cvp7, cvp8, cvp9, cvp10};
    	JLabel tabCVi[] = {cvi1, cvi2, cvi3, cvi4, cvi5, cvi6, cvi7, cvi8, cvi9};
    	JLabel tabCL[] = {l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14};
    	char[] casesLettres = positionCasesEtLettres(mot, controller.getNiveau(), tabCVp, tabCVi, tabCL, myPanel, associationLettreCouleur);
    	
    	ComponentMove listener = new ComponentMove(myPanel, null, getPointsFixes(), getPointsMobiles(), getPointsFixesEtat(), controller.getNiveau(), casesLettres);
    	myPanel.addMouseListener(listener);
    	myPanel.addMouseMotionListener(listener);

    	// Mise à l'écoute des événements sur les boutons
    	boutonRetour.addActionListener(this);
    	//boutonPasser.addActionListener(this);
    	
    	// On récupère l'image du mot
    	String imageMot = motChoisi.getImage();
    	// On teste si la partie jouée est de niveau 2 et si le mot contient ou non une image 
    	if(controller.getNiveau()==2 && (imageMot!=null || imageMot!="NULL" || imageMot!="null")) {
	    	// On créé le JLabel porteur de l'image
	    	JLabel imageMotLabel = new JLabel();
	    	// On créé l'icone contenant l'image
	    	ImageIcon imageMotII = new ImageIcon(imageMot);
	    	// On récupère sa taille
	    	int imgHauteur = imageMotII.getIconHeight();
	    	int imgLargeur = imageMotII.getIconWidth();
	
	    	// On calcule les nouvelles dimensions de l'image pour qu'elle puisse rentrer dans le cadre
			int[] newDimensions = Controller.nouvellesDimensionImage(imgLargeur, imgHauteur, 540, 240);
			// On les stocke dans des variables
			int newLargeur = newDimensions[0];
			int newHauteur = newDimensions[1];
			
			// On récupère l'image d'origine
			Image img = imageMotII.getImage();
			// On la redimensionne avec les nouvelles dimensions
			img = img.getScaledInstance(newLargeur, newHauteur, Image.SCALE_DEFAULT);
			// On modifie l'imageIcon
	    	imageMotII = new ImageIcon(img);
	    	// On l'ajoute au JLabel
	    	imageMotLabel.setIcon(imageMotII);
	    	
	    	// On calcule un éventuel décalage pour centrer l'image horizontalement et verticalement
	    	int decalageX, decalageY;
	    	decalageY = (540 - newLargeur)/2;
	    	decalageX = (240 - newHauteur)/2;
	    	
	    	// On défini son placement
	    	imageMotLabel.setBounds(130 + decalageY, 10 + decalageX, 540, 240);
	    	
	    	// On l'ajoute au JPanel
	    	myPanel.add(imageMotLabel);
    	}
    	
	}
	
	public ThemeWindow(Controller c, Mot motCourant) {
		controller = c;
		
		//listeDesMots = c.getListeDesMots();
		
		// Définition de la taille de la fenêtre
		sizeFenX = 800;
		sizeFenY = 600;
		
		// Définition de la taille des boutons cases vides
    	heightButton = 70;
    	widthButton = 70;
    	
    	posXcv1 = 5;
    	posYcv1 = 340;
		
		// Initialisation de la fenêtre
		this.setTitle("Jeu - Automne");
    	this.setSize(sizeFenX, sizeFenY);
    	this.setLocationRelativeTo(null);
    	this.setResizable(false);
    	this.setAlwaysOnTop(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setLayout(null);
		
		// Initialisation du panneau
		myPanel = new Panneau();
    	myPanel.setBackground(new Color(252,246,232));
    	myPanel.setLayout(null);
    	
		// Placement des différents éléments dans la fenêtre
    	
      	boutonRetour = new JButton();
      	//boutonPasser = new JButton();
      	cvp1 = new JLabel();
      	cvp2 = new JLabel();
      	cvp3 = new JLabel();
      	cvp4 = new JLabel();
      	cvp5 = new JLabel();
      	cvp6 = new JLabel();
      	cvp7 = new JLabel();
      	cvp8 = new JLabel();
      	cvp9 = new JLabel();
      	cvp10 = new JLabel();
      	cvi1 = new JLabel();
      	cvi2 = new JLabel();
      	cvi3 = new JLabel();
      	cvi4 = new JLabel();
      	cvi5 = new JLabel();
      	cvi6 = new JLabel();
      	cvi7 = new JLabel();
      	cvi8 = new JLabel();
      	cvi9 = new JLabel();
      	l1 = new JLabel();
      	l2 = new JLabel();
      	l3 = new JLabel();
      	l4 = new JLabel();
      	l5 = new JLabel();
      	l6 = new JLabel();
      	l7 = new JLabel();
      	l8 = new JLabel();
      	l9 = new JLabel();
      	l10 = new JLabel();
      	l11 = new JLabel();
      	l12 = new JLabel();
      	l13 = new JLabel();
      	l14 = new JLabel();
      	
    	ImageIcon imgRetour = new ImageIcon("img/boutons/boutonRetour.png");
    	//ImageIcon imgPasser = new ImageIcon("img/boutons/boutonPasser.png");
    	ImageIcon imgcv = new ImageIcon("img/casesVides2.png");
    	
    	boutonRetour.setIcon(imgRetour);
    	//boutonPasser.setIcon(imgPasser);
    	cvp1.setIcon(imgcv);
       	cvp2.setIcon(imgcv);   	
       	cvp3.setIcon(imgcv);
       	cvp4.setIcon(imgcv);
       	cvp5.setIcon(imgcv);
    	cvp6.setIcon(imgcv);
       	cvp7.setIcon(imgcv);   	
       	cvp8.setIcon(imgcv);
       	cvp9.setIcon(imgcv);
       	cvp10.setIcon(imgcv);
    	cvi1.setIcon(imgcv);
       	cvi2.setIcon(imgcv);   	
       	cvi3.setIcon(imgcv);
       	cvi4.setIcon(imgcv);
       	cvi5.setIcon(imgcv);
    	cvi6.setIcon(imgcv);
       	cvi7.setIcon(imgcv);   	
       	cvi8.setIcon(imgcv);
       	cvi9.setIcon(imgcv);
       	l1.setIcon(imgcv);
       	l2.setIcon(imgcv);
       	l3.setIcon(imgcv);
       	l4.setIcon(imgcv);
       	l5.setIcon(imgcv);
       	l6.setIcon(imgcv);
       	l7.setIcon(imgcv);
       	l8.setIcon(imgcv);
       	l9.setIcon(imgcv);
       	l10.setIcon(imgcv);
       	l11.setIcon(imgcv);
       	l12.setIcon(imgcv);
       	l13.setIcon(imgcv);
       	l14.setIcon(imgcv);

    	boutonRetour.setContentAreaFilled(false);
    	//boutonPasser.setContentAreaFilled(false);
    	/*cvp1.setContentAreaFilled(false);
    	cvp2.setContentAreaFilled(false);
    	cvp3.setContentAreaFilled(false);
    	cvp4.setContentAreaFilled(false);
    	cvp5.setContentAreaFilled(false);
    	cvp6.setContentAreaFilled(false);
    	cvp7.setContentAreaFilled(false);
    	cvp8.setContentAreaFilled(false);
    	cvp9.setContentAreaFilled(false);
    	cvp10.setContentAreaFilled(false);
    	cvi1.setContentAreaFilled(false);
    	cvi2.setContentAreaFilled(false);
    	cvi3.setContentAreaFilled(false);
    	cvi4.setContentAreaFilled(false);
    	cvi5.setContentAreaFilled(false);
    	cvi6.setContentAreaFilled(false);
    	cvi7.setContentAreaFilled(false);
    	cvi8.setContentAreaFilled(false);
    	cvi9.setContentAreaFilled(false);
    	l1.setContentAreaFilled(false);
    	l2.setContentAreaFilled(false);
    	l3.setContentAreaFilled(false);
    	l4.setContentAreaFilled(false);
    	l5.setContentAreaFilled(false);
    	l6.setContentAreaFilled(false);
    	l7.setContentAreaFilled(false);
    	l8.setContentAreaFilled(false);
    	l9.setContentAreaFilled(false);
    	l10.setContentAreaFilled(false);
    	l11.setContentAreaFilled(false);
    	l12.setContentAreaFilled(false);
    	l13.setContentAreaFilled(false);
    	l14.setContentAreaFilled(false);*/

    	boutonRetour.setOpaque(false);
    	//boutonPasser.setOpaque(false);
    	cvp1.setOpaque(false);
    	cvp2.setOpaque(false);
    	cvp3.setOpaque(false);
    	cvp4.setOpaque(false);
    	cvp5.setOpaque(false);
    	cvp6.setOpaque(false);
    	cvp7.setOpaque(false);
    	cvp8.setOpaque(false);
    	cvp9.setOpaque(false);
    	cvp10.setOpaque(false);
    	cvi1.setOpaque(false);
    	cvi2.setOpaque(false);
    	cvi3.setOpaque(false);
    	cvi4.setOpaque(false);
    	cvi5.setOpaque(false);
    	cvi6.setOpaque(false);
    	cvi7.setOpaque(false);
    	cvi8.setOpaque(false);
    	cvi9.setOpaque(false);
    	l1.setOpaque(false);
    	l2.setOpaque(false);
    	l3.setOpaque(false);
    	l4.setOpaque(false);
    	l5.setOpaque(false);
    	l6.setOpaque(false);
    	l7.setOpaque(false);
    	l8.setOpaque(false);
    	l9.setOpaque(false);
    	l10.setOpaque(false);
    	l11.setOpaque(false);
    	l12.setOpaque(false);
    	l13.setOpaque(false);
    	l14.setOpaque(false);
    	
    	boutonRetour.setBorderPainted(false);
    	//boutonPasser.setBorderPainted(false);
    	/*cvp1.setBorderPainted(false);
    	cvp2.setBorderPainted(false);
    	cvp3.setBorderPainted(false);
    	cvp4.setBorderPainted(false);
    	cvp5.setBorderPainted(false);
    	cvp6.setBorderPainted(false);
    	cvp7.setBorderPainted(false);
    	cvp8.setBorderPainted(false);
    	cvp9.setBorderPainted(false);
    	cvp10.setBorderPainted(false);
    	cvi1.setBorderPainted(false);
    	cvi2.setBorderPainted(false);
    	cvi3.setBorderPainted(false);
    	cvi4.setBorderPainted(false);
    	cvi5.setBorderPainted(false);
    	cvi6.setBorderPainted(false);
    	cvi7.setBorderPainted(false);
    	cvi8.setBorderPainted(false);
    	cvi9.setBorderPainted(false);
    	l1.setBorderPainted(false);
    	l2.setBorderPainted(false);
    	l3.setBorderPainted(false);
    	l4.setBorderPainted(false);
    	l5.setBorderPainted(false);
    	l6.setBorderPainted(false);
    	l7.setBorderPainted(false);
    	l8.setBorderPainted(false);
    	l9.setBorderPainted(false);
    	l10.setBorderPainted(false);
    	l11.setBorderPainted(false);
    	l12.setBorderPainted(false);
    	l13.setBorderPainted(false);
    	l14.setBorderPainted(false);*/

    	boutonRetour.setBounds(20, 20, 100, 33);
    	//boutonPasser.setBounds(680, 20, 100, 33);
    	// Cases vides quand mot de longueur pair
    	cvp1.setBounds(posXcv1, posYcv1, widthButton, heightButton);
    	cvp2.setBounds(posXcv1+80, posYcv1, widthButton, heightButton);
    	cvp3.setBounds(posXcv1+160, posYcv1, widthButton, heightButton );
    	cvp4.setBounds(posXcv1+240, posYcv1, widthButton, heightButton);
    	cvp5.setBounds(posXcv1+320, posYcv1, widthButton, heightButton);
    	cvp6.setBounds(posXcv1+400, posYcv1, widthButton, heightButton);
    	cvp7.setBounds(posXcv1+480, posYcv1, widthButton, heightButton);
    	cvp8.setBounds(posXcv1+560, posYcv1, widthButton, heightButton );
    	cvp9.setBounds(posXcv1+640, posYcv1, widthButton, heightButton);
    	cvp10.setBounds(posXcv1+720, posYcv1, widthButton, heightButton);
    	// Cases vides quand mot de longueur impair
    	cvi1.setBounds(posXcv1+40, posYcv1, widthButton, heightButton);
    	cvi2.setBounds(posXcv1+120, posYcv1, widthButton, heightButton);
    	cvi3.setBounds(posXcv1+200, posYcv1, widthButton, heightButton );
    	cvi4.setBounds(posXcv1+280, posYcv1, widthButton, heightButton);
    	cvi5.setBounds(posXcv1+360, posYcv1, widthButton, heightButton);
    	cvi6.setBounds(posXcv1+440, posYcv1, widthButton, heightButton);
    	cvi7.setBounds(posXcv1+520, posYcv1, widthButton, heightButton);
    	cvi8.setBounds(posXcv1+600, posYcv1, widthButton, heightButton );
    	cvi9.setBounds(posXcv1+680, posYcv1, widthButton, heightButton);
    	l1.setBounds(posXcv1+120, posYcv1+heightButton+15, widthButton, heightButton);
    	l2.setBounds(posXcv1+200, posYcv1+heightButton+15, widthButton, heightButton);
    	l3.setBounds(posXcv1+280, posYcv1+heightButton+15, widthButton, heightButton);
    	l4.setBounds(posXcv1+360, posYcv1+heightButton+15, widthButton, heightButton);
    	l5.setBounds(posXcv1+440, posYcv1+heightButton+15, widthButton, heightButton);
    	l6.setBounds(posXcv1+520, posYcv1+heightButton+15, widthButton, heightButton);
    	l7.setBounds(posXcv1+600, posYcv1+heightButton+15, widthButton, heightButton);
    	l8.setBounds(posXcv1+120, posYcv1+2*heightButton+20, widthButton, heightButton);
    	l9.setBounds(posXcv1+200, posYcv1+2*heightButton+20, widthButton, heightButton);
    	l10.setBounds(posXcv1+280, posYcv1+2*heightButton+20, widthButton, heightButton);
    	l11.setBounds(posXcv1+360, posYcv1+2*heightButton+20, widthButton, heightButton);
    	l12.setBounds(posXcv1+440, posYcv1+2*heightButton+20, widthButton, heightButton);
    	l13.setBounds(posXcv1+520, posYcv1+2*heightButton+20, widthButton, heightButton);
    	l14.setBounds(posXcv1+600, posYcv1+2*heightButton+20, widthButton, heightButton);

    	myPanel.add(boutonRetour);
    	//myPanel.add(boutonPasser);
    	myPanel.add(cvp1);
    	myPanel.add(cvp2);
    	myPanel.add(cvp3);
    	myPanel.add(cvp4);
    	myPanel.add(cvp5);
    	myPanel.add(cvp6);
    	myPanel.add(cvp7);
    	myPanel.add(cvp8);
    	myPanel.add(cvp9);
    	myPanel.add(cvp10);
    	myPanel.add(cvi1);
    	myPanel.add(cvi2);
    	myPanel.add(cvi3);
    	myPanel.add(cvi4);
    	myPanel.add(cvi5);
    	myPanel.add(cvi6);
    	myPanel.add(cvi7);
    	myPanel.add(cvi8);
    	myPanel.add(cvi9);
    	myPanel.add(l1);
    	myPanel.add(l2);
    	myPanel.add(l3);
    	myPanel.add(l4);
    	myPanel.add(l5);
    	myPanel.add(l6);
    	myPanel.add(l7);
    	myPanel.add(l8);
    	myPanel.add(l9);
    	myPanel.add(l10);
    	myPanel.add(l11);
    	myPanel.add(l12);
    	myPanel.add(l13);
    	myPanel.add(l14);
    	
    	ArrayList<Character> associationLettreCouleur = new ArrayList<Character>();
    	motChoisi = motCourant;
    	String mot = motChoisi.getLibelleMot();
    	mot = Controller.stringUpperCase(mot);
    	char[] motChar = mot.toCharArray();
    	for(int i=0; i<motChar.length; i++) {
    		if(!associationLettreCouleur.contains((Character) Controller.charUpperCase(motChar[i]))) {
    			associationLettreCouleur.add((Character) Controller.charUpperCase(motChar[i]));
    		}
    	}
    	
    	JLabel tabCVp[] = {cvp1, cvp2, cvp3, cvp4, cvp5, cvp6, cvp7, cvp8, cvp9, cvp10};
    	JLabel tabCVi[] = {cvi1, cvi2, cvi3, cvi4, cvi5, cvi6, cvi7, cvi8, cvi9};
    	JLabel tabCL[] = {l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14};
    	char[] casesLettres = positionCasesEtLettres(mot, controller.getNiveau(), tabCVp, tabCVi, tabCL, myPanel, associationLettreCouleur);
    	
    	ComponentMove listener = new ComponentMove(myPanel, null, getPointsFixes(), getPointsMobiles(), getPointsFixesEtat(), controller.getNiveau(), casesLettres);
    	myPanel.addMouseListener(listener);
    	myPanel.addMouseMotionListener(listener);

    	// Mise à l'écoute des événements sur les boutons
    	boutonRetour.addActionListener(this);
    	//boutonPasser.addActionListener(this);
    	
    	// On récupère l'image du mot
    	String imageMot = motChoisi.getImage();
    	// On teste si la partie jouée est de niveau 2 et si le mot contient ou non une image 
    	if(controller.getNiveau()==2 && (imageMot!=null || imageMot!="NULL" || imageMot!="null")) {
	    	// On créé le JLabel porteur de l'image
	    	JLabel imageMotLabel = new JLabel();
	    	// On créé l'icone contenant l'image
	    	ImageIcon imageMotII = new ImageIcon(imageMot);
	    	// On récupère sa taille
	    	int imgHauteur = imageMotII.getIconHeight();
	    	int imgLargeur = imageMotII.getIconWidth();
	
	    	// On calcule les nouvelles dimensions de l'image pour qu'elle puisse rentrer dans le cadre
			int[] newDimensions = Controller.nouvellesDimensionImage(imgLargeur, imgHauteur, 540, 240);
			// On les stocke dans des variables
			int newLargeur = newDimensions[0];
			int newHauteur = newDimensions[1];
			
			// On récupère l'image d'origine
			Image img = imageMotII.getImage();
			// On la redimensionne avec les nouvelles dimensions
			img = img.getScaledInstance(newLargeur, newHauteur, Image.SCALE_DEFAULT);
			// On modifie l'imageIcon
	    	imageMotII = new ImageIcon(img);
	    	// On l'ajoute au JLabel
	    	imageMotLabel.setIcon(imageMotII);
	    	
	    	// On calcule un éventuel décalage pour centrer l'image horizontalement et verticalement
	    	int decalageX, decalageY;
	    	decalageY = (540 - newLargeur)/2;
	    	decalageX = (240 - newHauteur)/2;
	    	
	    	// On défini son placement
	    	imageMotLabel.setBounds(130 + decalageY, 10 + decalageX, 540, 240);
	    	
	    	// On l'ajoute au JPanel
	    	myPanel.add(imageMotLabel);
    	}
    	
	}
	
	public Controller getController() {
		return controller;
	}
	
	public Panneau getPanel() {
		return myPanel;
	}
	
	public Mot getMotChoisi() {
		return motChoisi;
	}
	
	public void actionPerformed(ActionEvent push) {		
		if(push.getSource() == boutonRetour) {
			//APPEL DE LA FENETRE CHOIX NIVEAUX
			controller.afficheChoixNiveau(controller.getTheme());
			this.setDesactivate();
		}
	}
	
	public void setActivate() {
		this.setVisible(true);
	}

	public void setDesactivate() {
		this.setVisible(false);
	}
	
	public int getHeightButton() {
		return heightButton;
	}
	
	public int getWidthButton() {
		return widthButton;
	}
	
	public static char[] genererLettresNiveau1(String mot) {
		mot = Controller.stringUpperCase(mot);
		List arrlist = new ArrayList<Character>();
		for (char c : mot.toCharArray()) {
			arrlist.add(c);
		}
		// mélanger tableau
		Collections.shuffle(arrlist);
		char[] retour = new char[arrlist.size()];
		for(int i = 0; i < arrlist.size(); i++) {
			retour[i] = (Character) arrlist.get(i);
		}
		return retour;
	}	

	public static char[] genererLettresNiveau2(String mot) {
		mot = Controller.stringUpperCase(mot);
		List arrlist = new ArrayList<Character>();
		char current;
		char[] lettresParasites;
		// transforme le string en char[] puis en arraylist
		for (char c : mot.toCharArray()) {
			arrlist.add(c);
		}
		int taille = arrlist.size();
		// génrèe une lettre parasite par lettre du mot
		for(int i=0; i<4; i++) {
			Random rand = new Random();
			int index = rand.nextInt(taille);
			current = (Character) arrlist.get(index);
			lettresParasites = Lettre.getLettresParasites(current);
			arrlist.add(lettresParasites[Controller.genererAleatoire(0, lettresParasites.length-1)]);
		}
		// mélange les lettres
		Collections.shuffle(arrlist);
		char[] retour = new char[arrlist.size()];
		for(int i = 0; i < arrlist.size(); i++) {
			retour[i] = (Character) arrlist.get(i);
		}
		return retour;
	}
	
	public String getCheminFond() {
		return cheminFond;
	}
	
	public String getLienFond(String nomImage) {
		return getCheminFond() + nomImage;
	}
	
	/*
	 * Si le mot est paire -> moitié d'un coté et le reste de l'autre.
	 * Si le mot est impaire -> lettre du milieu au milieu, premiere moitier d'un coté et le reste de
	 * l'autre.
	 * Pour les cases vide on peut désactiver celle qui sont en "trop"
	 * Niveau 1 :
	 * 	Lettre du mot en mode random
	 * Niveau 2 :
	 * 	Max 10 lettre le mot.
	 * 	Max 16 lettre alphabet
	 * 	2 ligne de 8 lettres.
	 * setEnabled(boolean) 
	 * motChar[nb/2];
	*/
	public char[] positionCasesEtLettres(String mot, int niveau, JLabel[] tabCVp, JLabel[] tabCVi, JLabel[] tabCL, JPanel myPanel, ArrayList<Character> associationLettreCouleur){ // positionne automatiquement des cases vides et des lettre en fonction de la longueur du mot
		ArrayList<Point> pointsFixes = new ArrayList<Point>(), pointsMobiles = new ArrayList<Point>();
		ArrayList<Integer> pointsFixesEtat = new ArrayList<Integer>(), recompositionIndices = new ArrayList<Integer>();
		int nb = mot.length(); // longueur du mot
		char[] motChar = mot.toCharArray(); // rend le mot un arrayList de char (lettre par lettre)
		casesVidesActives = new ArrayList<JLabel>();
		int cpt = 0;
		Color[] couleursLettre = {Color.BLUE, Color.RED, Color.GREEN, Color.MAGENTA, Color.CYAN, Color.ORANGE, new Color(100,155,136), new Color(120,94,47), new Color(161,6,132), new Color(127,0,255)};
		
		/* Positionnement des cases vides */		
		if(nb%2 == 0){ // Si le mot est paire
			int j = 10-nb; // Calcul le nombre de case à desactiver
			for (int i = 0; i < 10; i++){ // Désactive les cases en "trop" en partant des extrémités.
				if(i < j/2 || i >= (motChar.length + j/2)) {
					//tabCV[i].setEnabled(false);
					myPanel.remove(tabCVp[i]);
				}
				else {
					casesVidesActives.add(tabCVp[i]);
					/*JButton b = Lettre.getCaseLettre(motChar[cpt], null);
					Point p = tabCVp[i].getLocation();
					b.setBounds((int) p.getX(), (int) p.getY() - 80, 70, 70);
					myPanel.add(b);*/
				}
			}	
			for(int i=0; i<tabCVi.length; i++) {
				myPanel.remove(tabCVi[i]);
			}
		}
		else{ // Si le mot est impaire			
			int j = 10-nb; // Calcul le nombre de case à desactiver
			int i;
			for (i = 0; i<9; i++){ // Désactive les cases en "trop" en partant des extrémités.
				if(i < (j-1)/2 || i >= (motChar.length + (j-1)/2)) {
					myPanel.remove(tabCVi[i]);
				}
				else {
					casesVidesActives.add(tabCVi[i]);
				}
			}
			//tabCV[10-(i+1)].setEnabled(false); // Désactive la cases impaire en "trop" 
			//myPanel.remove(tabCVi[9-i]);
												// -> du coup le mot n'est pas au milieu de la fenetre...
	    	
			for(i=0; i<tabCVp.length; i++) {
				myPanel.remove(tabCVp[i]);
			}	
		}
		cpt = 0;
		for(int i=0; i<casesVidesActives.size(); i++) {
			JLabel b = Lettre.getCaseLettre(motChar[i], null);
			Point p = casesVidesActives.get(i).getLocation();
			b.setBounds((int) p.getX(), (int) p.getY() - 80, 70, 70);
			if(niveau==1) {
				int index = associationLettreCouleur.indexOf(b.getText().toCharArray()[0]);
				if(index>=0) b.setForeground(couleursLettre[index]);
				else b.setForeground(couleursLettre[0]);
			}
			myPanel.add(b);
			Point bP = b.getLocation();
			int x = (int)bP.getX();
			int y = (int)bP.getY()+80;
			pointsFixes.add(new Point(x,y));
			pointsFixesEtat.add(0);
			cpt++;
		}
		
		/*for(int i=0; i<motChar.length; i++) {
			actifs[i] = Lettre.getCaseLettre(motChar[i], null);
		*/
			
	    /* Positionnement des cases lettres */			
		//if (niveau == 1){ // Si le jeu est au niveau 1
			
			/* Soit on affiche la meme ligne que la lignes des cases vide
			 * parce que on pars du principe due le niveau 1 a des mots courts
			 * donc qu'ils feront jamais plus de 8 lettres
			 * Soit on fait le schéma chelou ...
			*/
		char[] casesLettres;
		if(niveau==1) casesLettres = genererLettresNiveau1(mot);
		else casesLettres = genererLettresNiveau2(mot);
		char[] casesLettresLigne1, casesLettresLigne2;
		int lenTab = casesLettres.length, lenL1, lenL2;
		if(lenTab > 7) {
			if(lenTab%2 == 0) {
				lenL1 = lenTab/2;
				lenL2 = lenL1;
			}
			else {
				lenL1 = lenTab/2 + 1;
				lenL2 = lenTab/2;
			}
			casesLettresLigne1 = new char[lenL1];
			casesLettresLigne2 = new char[lenL2];
			for(int i=0; i < lenL1; i++) {
				casesLettresLigne1[i] = casesLettres[i];
			}
			for(int i=lenL1; i < lenTab; i++) {
				casesLettresLigne2[i-lenL1] = casesLettres[i];
			}
		}
		else {
			lenL1 = lenTab; lenL2 = 0;
		}
		casesLettresActives = new ArrayList<JLabel>();
		if(lenL2 == 0) {
			//cas il n'y à qu'une ligne
			//parcours 1e ligne
			int j = 7 - lenL1;
			for(int i=7; i<14; i++) {
				if(i < j/2+7 || i >= (lenL1 + j/2+7)) {
					myPanel.remove(tabCL[i]);
				}
				else {
					casesLettresActives.add(tabCL[i]);
				}
				myPanel.remove(tabCL[i]);
			}
			for(int i=0; i<7; i++) {
				myPanel.remove(tabCL[i]);
			}
			boolean nbCasesL1Pair = lenL1%2==0;
			for(int i=0; i<casesLettresActives.size(); i++) {
				JLabel b = Lettre.getCaseLettre(casesLettres[i], null);
				Point p = casesLettresActives.get(i).getLocation();
				if(i<lenL1 && nbCasesL1Pair) {
					b.setBounds((int) p.getX()+40, (int) p.getY(), 70, 70);
				}
				else {
					b.setBounds((int) p.getX(), (int) p.getY(), 70, 70);
				}
				if(niveau==1) {
					int index = associationLettreCouleur.indexOf(b.getText().toCharArray()[0]);
					if(index>=0) b.setForeground(couleursLettre[index]);
					else b.setForeground(couleursLettre[0]);
				}
				casesLettresActives.set(i, b);
				//b.addMouseListener(listener);
				//b.addMouseMotionListener(listener);
				myPanel.add(b);
				pointsMobiles.add(b.getLocation());
			}
		}
		else {
			//cas 2 lignes
			int j = 7 - lenL1;
			for(int i=0; i<7; i++) {
				if(i < j/2 || i >= (lenL1 + j/2)) {
					myPanel.remove(tabCL[i]);
				}
				else {
					casesLettresActives.add(tabCL[i]);
				}
				myPanel.remove(tabCL[i]);
			}
			j = 7 - lenL2;
			for(int i=7; i<14; i++) {
				if(i < j/2+7 || i >= (lenL2 + j/2+7)) {
					myPanel.remove(tabCL[i]);
				}
				else {
					casesLettresActives.add(tabCL[i]);
				}
				myPanel.remove(tabCL[i]);
			}
			boolean nbCasesL1Pair = lenL1%2==0;
			boolean nbCasesL2Pair = lenL2%2==0;
			for(int i=0; i<casesLettresActives.size(); i++) {
				JLabel b = Lettre.getCaseLettre(casesLettres[i], null);
				Point p = casesLettresActives.get(i).getLocation();
				if(i<lenL1 && nbCasesL1Pair) {
					b.setBounds((int) p.getX()+40, (int) p.getY(), 70, 70);
				}
				else if(i>=lenL1 && nbCasesL2Pair) {
					b.setBounds((int) p.getX()+40, (int) p.getY(), 70, 70);
				}
				else {
					b.setBounds((int) p.getX(), (int) p.getY(), 70, 70);
				}
				if(niveau==1) {
					int index = associationLettreCouleur.indexOf(b.getText().toCharArray()[0]);
					if(index>=0) b.setForeground(couleursLettre[index]);
					else b.setForeground(couleursLettre[0]);
				}
				casesLettresActives.set(i, b);
				//b.addMouseListener(listener);
				//b.addMouseMotionListener(listener);
				myPanel.add(b);
				pointsMobiles.add(b.getLocation());
			}
		}
		setPointsFixes(pointsFixes);
		setPointsMobiles(pointsMobiles);
		setPointsFixesEtat(pointsFixesEtat);
		return casesLettres;
	}
	
	public void setPointsFixes(ArrayList<Point> pointsF) {
		pointsFixes = pointsF;
	}
	public void setPointsMobiles(ArrayList<Point> pointsM) {
		pointsMobiles = pointsM;
	}
	public void setPointsFixesEtat(ArrayList<Integer> pointsFE) {
		pointsFixesEtat = pointsFE;
	}
	public ArrayList<Point> getPointsFixes() {
		return pointsFixes;
	}
	public ArrayList<Point> getPointsMobiles() {
		return pointsMobiles;
	}
	public ArrayList<Integer> getPointsFixesEtat() {
		return pointsFixesEtat;
	}
	
	public abstract ArrayList<Mot> genererListeMots();
	
	private  class ComponentMove extends MouseAdapter {
	
    	//attributs
        private boolean move;
        private JComponent component;
        private Container container;
        private Point[][] positions;
        private ArrayList<Point> pointsFixes, pointsMobiles;
        private ArrayList<Integer> pointsFixesEtat, recompositionIndices;
        private ArrayList<JLabel> casesLettresActives, casesVidesActives;
        private Point depart;
        private int indice;
        private int relx, rely;
        @SuppressWarnings("unused")
		private int niveau;
        private char[] casesLettres;
        
        
        //constructeur
        public ComponentMove(Container container, Point[][] points, ArrayList<Point> pointsF, ArrayList<Point> pointsM, ArrayList<Integer> pointsFE, int niv, char[] cl) {
	        this.container=container;
		    this.positions = points;
		    this.niveau=niv;
		    this.pointsFixes = pointsF;
		    this.pointsMobiles = pointsM;
		    this.pointsFixesEtat = pointsFE;
		    this.recompositionIndices = new ArrayList<Integer>();
		    this.casesLettres = cl;
		    this.casesLettresActives = getCasesLettresActives();
		    this.casesVidesActives = getCasesVidesActives();
        }
 
        //methodes
        	//gestion du click de la souris
	    public void mousePressed(MouseEvent e) {
        	 //si la souris est déja en mouvement et que l'on click
	        if ( move ) {
	            move=false; // arrêt du mouvement
	            Point p = PositionArrivee(e.getX(),e.getY());
	                
	             /*on récupère les coordonnées de l'endroit où l'on click et on les compare
	              * à l'endroit où il faut clicker pour que que les images soit correctement accordées
	              * - si ce n'est pas la bonne position la partie mobile clickée retourne à sa position de départ
	              * - si c'est la bonne position elle reste fixée et l'image se forme*/
	            if(!pointsFixes.contains(p)) {
				    component.setLocation((int)depart.getX(), (int)depart.getY());
				}
				else {
					// On positionne la lettre à la place de la case fixe
					component.setLocation((int)p.getX(), (int)p.getY());
					// On supprime les cases non utilisables (dépôt comme mobile)
					pointsMobiles.remove(p);
					pointsMobiles.remove(depart);
					casesLettresActives.remove(component);
					// On modifie l'état de la case dépôt
		            pointsFixesEtat.set(IndiceA(p), 1);
		            //on insère un booléen signalant que l'image a été reconstituée
		            boolean fin = true;
		                
		            //on verifie que toutes les images ont été reconstituées
		            for (int i=0; i<pointsFixesEtat.size(); i++) {
		            	if (pointsFixesEtat.get(i)==0) fin = false;
		            }
		                
		            //lorsque c'est le cas, le niveau est fini, on lance l'interface de victoire et on passe au niveau suivant
		            if (fin) {
		            	System.out.println("fin");
		            	char[] recompositionLettres = new char[pointsFixes.size()];
		            	for(int i=0; i<pointsFixes.size(); i++) {
		            		//recompositionLettres[i] = casesLettres[recompositionIndices.get(i)];
		            		Point point = pointsFixes.get(i);
		            		JLabel current = (JLabel) getComponent((int) point.getX(), (int) point.getY());
		            		String lettre = current.getText();
		            		char[] lettres = lettre.toCharArray();
		            		recompositionLettres[i] = lettres[0];
		            		System.out.print(recompositionLettres[i]);
		            	}
		            	System.out.println();
		            	if(Controller.verifierMot(Controller.stringUpperCase(motChoisi.toString()), recompositionLettres)) {
		            		System.out.println("Victoire");
		            		Eleve joueur = controller.getJoueur();
		            		try {
								joueur.incremente(controller.getNiveau());
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		            		controller.afficheVictoire();
		            	}
		            	else {
		            		System.out.println("Défaite");
		            		controller.afficheDefaite();
		            	}
						//System.out.println("Victoire");                 
						//this.container.setVisible(false);
						//Victoire win = new Victoire(niveau);
						//monControleur.afficheFinNiv();
						//monControleur.levelUp();
		            }
		                
		        }
				component=null;
			}
	        /*gestion du click de la souris quand elle n'est pas déja en mouvement
	         * donc lorsque l'on veut capturer une image*/
	        else {
				Point p = PositionRelative(e.getX(),e.getY());
				if ((p.getX()!=0)&&(p.getY()!=0)) {
					depart = new Point(p);//position de départ
					component = getComponent(e.getX(), e.getY());
					indice = IndiceD(p);
					container.setComponentZOrder(component,0); // place le composant le plus haut possible
					relx = e.getX()-component.getX(); // on mémorise la position relative
					rely = e.getY()-component.getY(); // on mémorise la position relative
					move=true; // démarrage du mouvement
				}
	        }
        }
 
        private JComponent getComponent(int x, int y) {
            // on recherche le premier composant qui correspond aux coordonnées de la souris
            for(Component component : container.getComponents()) {
                if ( component instanceof JComponent && component.getBounds().contains(x, y) ) {
                    return (JComponent)component;
                }
            }
            return null;
        }
 
        //gestion du déplacement de l'image avec la souris
        public void mouseMoved(MouseEvent e) {
            if ( move ) {
                // si on déplace
                component.setLocation(e.getX()-relx, e.getY()-rely);
            }
        }
	
		public Point PositionArrivee (int x, int y) {
	
		    int i = 0;
		    int j = 0;
		    JLabel current;
		    Point p;
		    
		    boolean trouve = false;
	
		    for(int k=0; k<casesVidesActives.size() && !trouve; k++) {
		    	current = casesVidesActives.get(k);
		    	p = current.getLocation();
		    	if((x>=(int)p.getX())&&(x<=(int)p.getX()+70)) {
		    		i = (int)p.getX();
		    		trouve = true;
		    	}
		    	if(pointsFixesEtat.get(k)==1) {
		    		i = 0;
		    	}
		    }
		    
		    /*if ((x>=5)&&(x<=75)) i = 5;
		    else if ((x>=85)&&(x<=155)) i = 85;
		    else if ((x>=165)&&(x<=235)) i = 165;
		    else if ((x>=245)&&(x<=315)) i = 245;
		    else if ((x>=325)&&(x<=395)) i = 325;
		    else if ((x>=405)&&(x<=475)) i = 405;
		    else if ((x>=485)&&(x<=555)) i = 485;
		    else if ((x>=565)&&(x<=635)) i = 565;
		    else if ((x>=645)&&(x<=715)) i = 645;
		    else if ((x>=725)&&(x<=795)) i = 725;*/
		    
		    if ((y>=340)&&(y<=410)) j = 340;
	
		    return new Point(i,j);
		}
		
		public Point PositionRelative (int x, int y) {
			
			int i = 0;
			int j = 0;
			JLabel current;
			Point p;
			
		    boolean trouve = false;
	
		    for(int k=0; k<casesLettresActives.size() && !trouve; k++) {
		    	current = casesLettresActives.get(k);
		    	p = current.getLocation();
		    	if((x>=(int)p.getX())&&(x<=(int)p.getX()+70)) {
		    		i = (int)p.getX();
		    		trouve = true;
		    	}
		    }
		    trouve = false;
		    for(int k=0; k<casesLettresActives.size() && !trouve; k++) {
		    	current = casesLettresActives.get(k);
		    	p = current.getLocation();
		    	if((y>=(int)p.getY())&&(y<=(int)p.getY()+70)) {
		    		j = (int)p.getY();
		    		trouve = true;
		    	}
		    }	
			
			return new Point(i,j);
		}
		
		//assigne un indice à chaque partie mobile d'image, cet indice est le même pour les deux parties d'une même image
    	public int IndiceA (Point p) {
    	    int place = 0;
    	    for (int i=0; i<pointsFixes.size(); i++) {   		
    	    	if (pointsFixes.get(i).equals(p)) place = i;
    	    }
    	    return place;
    	}
    	//assigne un indice à chaque partie mobile d'image, cet indice est le même pour les deux parties d'une même image
    	public int IndiceD (Point p) {
    	    int place = 0;
    	    for (int i=0; i<pointsMobiles.size(); i++) {   		
    	    	if (pointsMobiles.get(i).equals(p)) place = i;
    	    }
    	    return place;
    	}   
	}//fin private class componentMove
	
	/*public Point PositionArriveeImpair (int x, int y) {

	    int i = 0;
	    int j = 0;

	    if ((x>=45)&&(x<=115)) i = 45;
	    else if ((x>=125)&&(x<=195)) i = 125;
	    else if ((x>=205)&&(x<=275)) i = 205;
	    else if ((x>=285)&&(x<=355)) i = 285;
	    else if ((x>=365)&&(x<=435)) i = 365;
	    else if ((x>=445)&&(x<=515)) i = 445;
	    else if ((x>=525)&&(x<=595)) i = 525;
	    else if ((x>=605)&&(x<=675)) i = 605;
	    else if ((x>=685)&&(x<=755)) i = 685;
	   
	    if ((y>=340)&&(y<=410)) j = 340;
	    

	    return new Point(i,j);
	}*/

	public ArrayList<JLabel> getCasesVidesActives() {
		return casesVidesActives;
	}
	
	public void removeCasesVidesActives(JComponent component) {
		casesVidesActives.remove(component);
	}
	
	public ArrayList<JLabel> getCasesLettresActives() {
		return casesLettresActives;
	}	
	
	public void removeCasesLettresActives(JComponent component) {
		casesLettresActives.remove(component);
	}
	
	public static String testCLA(ArrayList<JLabel> cla) {
		String str = "";
		for(int i=0; i<cla.size(); i++) {
			str += cla.get(i).toString();
		}
		return str;
	}
	
	/*public static void main(String[] args) {
		System.out.println("Mot avant mélange : " + Controller.stringUpperCase("train"));
		System.out.println("Mot après mélange niveau 1 : " + new String(genererLettresNiveau1("train")));
		System.out.println("Mot après mélange niveau 2 : " + new String(genererLettresNiveau2("train")));
		System.out.println("Proposition du joueur : TRANI");
		System.out.println("Réponse du jeu : " + Controller.verifierMot("TRAIN", new char[] {'T','R','A','N','I'}));
		System.out.println("Proposition du joueur : TRAIN");
		System.out.println("Réponse du jeu : " + Controller.verifierMot("TRAIN", new char[] {'T','R','A','I','N'}));
	}*/

}
