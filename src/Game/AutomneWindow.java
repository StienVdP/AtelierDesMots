package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
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

public class AutomneWindow extends ThemeWindow implements ActionListener, ItemListener {
	
	private Controller controller;
	private Panneau myPanel;
	
	public AutomneWindow(Controller c){
		
		super(c);
		controller = super.getController();
		myPanel = super.getPanel();
		int niveau=controller.getNiveau();
		
		if(niveau==1){
			myPanel.setBackground("backgroundAutomne.png");
		}
		
		if(niveau==2){
			myPanel.setBackground(new Color(255, 203, 96));
		}
	
		this.setTitle("Jeu - Automne");
		// Ajout du panneau à la fenêtre
    	this.setContentPane(myPanel);
    	
	}
	
	public AutomneWindow(Controller c, Mot motC) {
		super(c, motC);
		controller = super.getController();
		myPanel = super.getPanel();
		int niveau=controller.getNiveau();
		
		if(niveau==1){
			myPanel.setBackground("backgroundAutomne.png");
		}
		
		if(niveau==2){
			myPanel.setBackground(new Color(255, 203, 96));
		}
 
		this.setTitle("Jeu - Automne");
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