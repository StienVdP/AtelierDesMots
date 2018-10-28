package Game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrintempsWindow extends ThemeWindow implements ActionListener, ItemListener {
	
	private Controller controller;
	private Panneau myPanel;
	
	public PrintempsWindow(Controller c){
		
		super(c);
		controller = super.getController();
		myPanel = super.getPanel();
		int niveau=controller.getNiveau();
		
		if(niveau==1){
			myPanel.setBackground("backgroundPrintemps.png");
		}
		
		if(niveau==2){
			myPanel.setBackground(new Color(1, 215, 88));
		}
   
		this.setTitle("Jeu - Printemps");
		// Ajout du panneau à la fenêtre
    	this.setContentPane(myPanel);
    	
	}
	
	public PrintempsWindow(Controller c, Mot motC) {
		super(c, motC);
		controller = super.getController();
		myPanel = super.getPanel();
		int niveau=controller.getNiveau();
		
		if(niveau==1){
			myPanel.setBackground("backgroundPrintemps.png");
		}
		
		if(niveau==2){
			myPanel.setBackground(new Color(1, 215, 88));
		}
    	
		this.setTitle("Jeu - Printemps");
		// Ajout du panneau à la fenêtre
    	this.setContentPane(myPanel);
    	
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Mot> genererListeMots() {
		// TODO Auto-generated method stub
		return null;
	}

}