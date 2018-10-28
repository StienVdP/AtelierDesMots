package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StatsJoueurWindow extends JFrame implements ActionListener {		
	private Controller controller;
	private JPanel myPanel;
    private int sizeFenX, sizeFenY;
    private JButton boutonRetour;
    private JTable tableau;


	public StatsJoueurWindow(Controller c) {
		controller = c;

		// Définition de la taille de la fenêtre
		sizeFenX = 800;
		sizeFenY = 600;

		
		// Initialisation de la fenêtre
		this.setTitle("Statistiques des Joueurs");
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
    	
    	JLabel titre= new JLabel("Statistiques des Joueurs");
    	JLabel nb= new JLabel("NB: Les chiffres correspondent aux nombres de mots trouvés par niveau");
		
    	
    	boutonRetour = new JButton();
    	ImageIcon imgRetour = new ImageIcon("img/boutons/boutonRetour.png");
    	boutonRetour.setIcon(imgRetour);
    	boutonRetour.setContentAreaFilled(false);
    	boutonRetour.setBounds(20, 20, 100, 33);
    	titre.setBounds(200, 30, 500, 100);  	
    	titre.setFont(new Font("Verdana", 1, 30));
    	
    	nb.setBounds(5, 500, 600, 50);    	
    	nb.setFont(new Font("Verdana", 1, 12));

    	//Création du tableau.
    	
    	//Récupérer les données
    	JTable table=new JTable();
	    ArrayList<Eleve> eleves = new ArrayList<Eleve>();
		try {
			eleves = Eleve.getAllEleves();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//structurer les données et les boutons et des titres
    	Object[][]data=new Object[eleves.size()][3];
		String[]titres={"Nom et Prénom des joueurs","Niveau 1","Niveau 2"};
		
		//Placement des données dans le tableau
		for(int i=0;i<eleves.size();i++){
			data[i][0]=(String) eleves.get(i).getNom();
			data[i][1]=(int) eleves.get(i).getsN1();
			data[i][2]=(int) eleves.get(i).getsN2();
			//System.out.println(data[i][0]+" "+data[i][1]+" "+data[i][2]);
		}
		
		//Création du tableau
		MyTableModel tableModel=new MyTableModel(data,titres);
		
		this.tableau=new JTable(tableModel);		
		//System.out.println(this.tableau.getComponentListeners());
		
		this.tableau.setRowHeight(40);
		this.tableau.setShowVerticalLines(true);
		this.tableau.setFont(new Font("Verdana",1,18));
		JScrollPane tab=new JScrollPane(tableau);
		tab.setBounds(50,120,700,350);
		
		
		myPanel.add(tab);
    	myPanel.add(titre);
    	myPanel.add(boutonRetour);
    	myPanel.add(nb);
		
    	
    	// Mise à l'écoute des événements sur les boutons
    	boutonRetour.addActionListener(this);
    	
		// Ajout du panneau à la fenêtre
    	this.setContentPane(myPanel);
	}

	public void actionPerformed(ActionEvent push) {
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
	
}
