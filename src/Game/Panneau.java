package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	
	private String bg;
	private Color c;
	
	public Panneau() {
		
	}
	
	public void setBackground(String bgP) {
		this.bg = bgP;
		repaint();
	}
	
	public void setBackground(Color c) {
		this.bg = null;
		this.c = c;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		if(bg == null) {
			g.setColor(c);
			g.fillRect(0, 0, 800, 600);
		}
		else {
			File input = new File("img/config/" + bg);
		    Image img = null;
			try {
				img = ImageIO.read(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(img, 0, 0, null);
		}
		repaint();
	}

}
