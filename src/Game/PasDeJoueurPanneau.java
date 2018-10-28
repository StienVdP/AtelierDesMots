package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PasDeJoueurPanneau extends MessagePanneau implements ActionListener {
	
	private JButton quitter;
	private Controller controller;

	public PasDeJoueurPanneau(Controller c) {
		super(c);
		controller = c;
		JLabel message = new JLabel("Aucun élève n'est inscrit !");
		this.setBackground(new Color(252,246,232));
		quitter = new JButton("Quitter");
		message.setBounds(0,0,400,300);
		quitter.setBounds(125,300, 150, 30);
		message.setFont(new Font("Verdana",1,20));
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setVerticalAlignment(SwingConstants.CENTER);
		this.add(message);
		this.add(quitter);
		quitter.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent push) {		
		if(push.getSource() == quitter) {
			//APPEL DE LA FENETRE CHOIX NIVEAUX
			System.exit(0);
		}
	}

}
