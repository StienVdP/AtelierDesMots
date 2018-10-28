package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MotWindow extends JFrame implements ActionListener, ItemListener {		
	private Controller controller;
	private JPanel myPanel;
    private int sizeFenX, sizeFenY;
    private JButton bModifier, bSupprimer, bAjouter, boutonRetour;
    private JTable tableau;
    private JComboBox<Mot> listeDeroulante;


	public MotWindow(Controller c) {
		controller = c;

		// Définition de la taille de la fenêtre
		sizeFenX = 800;
		sizeFenY = 600;

		
		// Initialisation de la fenêtre
		this.setTitle("Gestion des Mots");
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
    	
    	JLabel titre= new JLabel("Gestion des Mots");
   	
    	bAjouter = new JButton(); 	 
      	boutonRetour = new JButton();
    	

    	ImageIcon imgAjouter = new ImageIcon("img/boutons/Ajouter.png");
    	ImageIcon imgRetour = new ImageIcon("img/boutons/boutonRetour.png");
    	

       	bAjouter.setIcon(imgAjouter);
    	boutonRetour.setIcon(imgRetour);
	

    	bAjouter.setContentAreaFilled(false);
    	boutonRetour.setContentAreaFilled(false);
    	
    	bAjouter.setBounds(70, 475, 310, 66);
    	boutonRetour.setBounds(20, 20, 100, 33);
    	titre.setBounds(250, 30, 400, 100);
    	titre.setFont(new Font("Verdana", 1, 30));

    	myPanel.add(boutonRetour);
		myPanel.add(titre);
    	
    	//Cr�ation du tableau.
    	

    /*	for(int i=0; i< eleves.size(); i++) {
    		
    		
    		Eleve eleveCourant = eleves.get(i); // parcours les �l�ves
	    	listeDeroulante.addItem(eleveCourant); // ajout au tableau
    	}
    	
    	/*THEORIE :
    	* Un JPanel liste.
    	* Une JPanel row.
    	* une arraylist d'eleves
    	* for int i=0, i<eleves.size();i++
    	* 	nouvelle row.
    	* 	nouveau boutons
    	* 	nouvel eleve.
    	*   positionné : X pareil, Y en Y+40
    	* 	row.add(EleveCourant), row.add(bModifier), row.add(bSupprimer)
    	* 	liste.add(row);
    	*/
    	
    	//Récupérer les données
	    ArrayList<Mot> mots = new ArrayList<Mot>();
		try {
			mots = Mot.getAllMots();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//structurer les données et les boutons et des titres
    	Object[][]data=new Object[mots.size()][1];
		String[]titres={"Liste des mots"};
		
		//Placement des données dans le tableau
		for(int i=0;i<mots.size();i++){
			data[i][0]=mots.get(i).toString();
		}
		
		//Création du tableau
		MyTableModel tableModel=new MyTableModel(data,titres);		
		this.tableau=new JTable(tableModel);
		this.tableau.setRowHeight(40);
		this.tableau.setShowVerticalLines(false);
		this.tableau.setFont(new Font("Verdana",1,18));
		JScrollPane tab=new JScrollPane(tableau);
		tab.setBounds(50,115,350,350);
		
		
		myPanel.add(tab);
		myPanel.add(bAjouter);  
    	
		// Label "Sélectionnez un joueur"
    	JLabel sousTitre = new JLabel("Sélectionnez un mot");
    	sousTitre.setFont(new Font("Verdana", 1, 15));
    		// Liste déroulante
    	listeDeroulante = new JComboBox<Mot>();
    	
    	for(int i=0; i< mots.size(); i++) {
    		Mot motCourant = mots.get(i);
	    	listeDeroulante.addItem(motCourant);
    	}
    	
    	bModifier=new JButton();
    	ImageIcon imgModifier=new ImageIcon("img/boutons/modifier_petit.png");
    	bModifier.setIcon(imgModifier);
    	bModifier.setContentAreaFilled(false);
    	bModifier.addActionListener(this);
    	
    	bSupprimer=new JButton();
    	ImageIcon imgSupprimer=new ImageIcon("img/boutons/supprimer_petit.png");
    	bSupprimer.setIcon(imgSupprimer);
    	bSupprimer.setContentAreaFilled(false);
    	bSupprimer.addActionListener(this);
    	
    	
    	sousTitre.setBounds(500,140,300,40);
    	listeDeroulante.setBounds(450, 190, 300, 50);
    	bModifier.setBounds(490,300,101,33);
    	bSupprimer.setBounds(630,300,101,33);
    	  	
    	myPanel.add(sousTitre);
    	myPanel.add(listeDeroulante);
		myPanel.add(bModifier);
		myPanel.add(bSupprimer);
    
    	
    	
    	// Mise à l'écoute des événements sur les boutons
 
    	bAjouter.addActionListener(this);
    	bModifier.addActionListener(this);
    	bSupprimer.addActionListener(this);
    	boutonRetour.addActionListener(this);
    	
		// Ajout du panneau à la fenêtre
    	this.setContentPane(myPanel);
	}
	
	public void actionPerformed(ActionEvent push) {
		
		if (push.getSource() == bModifier) {
		    //APPEL DE LA FENETRE CHOIX DU THEME
			Mot motChoisi = (Mot) listeDeroulante.getSelectedItem();
			controller.afficheModifierMot(motChoisi);
			this.setDesactivate();
	    }
		
		if (push.getSource() == bSupprimer){
		    //APPEL DE LA FENETRE CHOIX DU THEME
			Mot motChoisi = (Mot) listeDeroulante.getSelectedItem();
			controller.afficheSupprimerMot(motChoisi);
			this.setDesactivate();
			
		}
		
		if (push.getSource() == bAjouter) {
		    //APPEL DE LA FENETRE CHOIX DU NIVEAU POUR ETE
				 AjouterMotWindow am= new AjouterMotWindow(controller);
				 this.setDesactivate();
				 am.setActivate();
	    }
	
		
		if(push.getSource() == boutonRetour) {
			//APPEL DE LA FENETRE ACCUEIL
			controller.afficheAdmin();
			this.setDesactivate();
		}
	}
		
	public void setActivate() {
		this.setVisible(true);
	}

	public void setDesactivate() {
		this.setVisible(false);
	}
	
	public  Controller getController(){
		return this.controller;
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main (String[] args){
        Controller c = new Controller();
      JoueurWindow jouer= new JoueurWindow(c);
        jouer.setActivate();
    }
	
}
