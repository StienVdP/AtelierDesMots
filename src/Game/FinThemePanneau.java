package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FinThemePanneau extends MessagePanneau implements ActionListener {
	
	private JButton quitter, suivant;
	private Controller controller;

	public FinThemePanneau(Controller c) {
		super(c);
		controller = c;
		JLabel message = new JLabel("Thème terminé !");
		ImageIcon smiley = new ImageIcon("img/config/victoire.jpg");
		JLabel smileyLabel = new JLabel(smiley);
		smileyLabel.setBounds(100, 50, 200, 200);
		this.setBackground(new Color(252,246,232));
		quitter = new JButton("Quitter la partie");
		suivant = new JButton("Changer de thème");
		message.setBounds(0,0,400,50);
		quitter.setBounds(50, 300, 150, 30);
		suivant.setBounds(200, 300, 150, 30);
		message.setFont(new Font("Verdana",1,20));
		message.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(message);
		this.add(smileyLabel);
		this.add(quitter);
		this.add(suivant);
		quitter.addActionListener(this);
		suivant.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent push) {		
		if(push.getSource() == quitter) {
			//APPEL DE LA FENETRE CHOIX NIVEAUX
			controller.afficheFenetreAccueil();
			controller.closeFenetreJeu();
		}
		if(push.getSource() == suivant){
			//APPEL DE LA FENETRE DU MOT SUIVANT
			controller.levelUp(false);
			controller.afficheChoixTheme(controller.getJoueur());
			controller.closeFenetreJeu();
		}
	}

}
