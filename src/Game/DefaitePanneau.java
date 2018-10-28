package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DefaitePanneau extends MessagePanneau implements ActionListener {
	
	private JButton quitter, tryAgain, suivant;
	private Controller controller;

	public DefaitePanneau(Controller c) {
		super(c);
		controller = c;
		JLabel message = new JLabel("Dommage, essaye encore !");
		ImageIcon smiley = new ImageIcon("img/config/defaite.png");
		JLabel smileyLabel = new JLabel(smiley);
		smileyLabel.setBounds(100, 50, 200, 200);
		this.setBackground(new Color(252,246,232));
		quitter = new JButton("Quitter la partie");
		tryAgain = new JButton("Réessayer");
		suivant = new JButton("Passer au mot suivant");
		message.setBounds(0,0,400,50);
		quitter.setBounds(50, 300, 150, 30);
		tryAgain.setBounds(200, 300, 150, 30);
		suivant.setBounds(100, 340, 200, 30);
		message.setFont(new Font("Verdana",1,20));
		message.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(message);
		this.add(smileyLabel);
		this.add(quitter);
		this.add(tryAgain);
		if(controller.getNbEssai()>=3) {
			this.add(suivant);
			suivant.addActionListener(this);
		}
		quitter.addActionListener(this);
		tryAgain.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent push) {		
		if(push.getSource() == quitter) {
			//APPEL DE LA FENETRE CHOIX NIVEAUX
			controller.playSound("Gameover.wav");
			controller.afficheFenetreAccueil();
			controller.closeFenetreJeu();
		}
		if(push.getSource() == tryAgain){
			//APPEL DE LA FENETRE DU MEME MOT
			controller.closeFenetreJeu();
			ThemeWindow jeu = controller.getFenetreJeu();
			Mot motC = jeu.getMotChoisi();
			controller.retryMot(motC);
		}
		if(push.getSource() == suivant){
			//APPEL DE LA FENETRE DU MOT SUIVANT
			controller.closeFenetreJeu();
			// S'il reste des mots on passe au mot suivant
			if(controller.getListeDesMots().size()!=0) {
				controller.setNiveau(controller.getNiveau());
			}
			else {
				// Sinon on affiche la fin du niveau
				controller.afficherFinNiveau();
			}
		}
	}

}
