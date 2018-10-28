package Game;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Dialog extends JDialog {
	
	public Dialog(JFrame parent, String title, boolean modal, MessagePanneau panel){
		//On appelle le construteur de JDialog correspondant
		super(parent, title, modal);
		//On spécifie une taille
		this.setSize(400, 400);
		//La position
		this.setLocationRelativeTo(null);
		//La boîte ne devra pas être redimensionnable
		this.setResizable(false);
		//Toujours en premier plan
    	this.setAlwaysOnTop(true);
    	// on affecte un jpanel
    	this.setContentPane(panel);
    	// on enlève le placement par défaut
    	this.setLayout(null);
		//Enfin on l'affiche
		this.setVisible(true);
	}
	
}