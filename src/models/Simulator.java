package models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Simulator extends JPanel implements ActionListener {
	
	private Image background;
	private PlayerCar player;
	private Timer timer;
	
	public Simulator() {
		setFocusable(true);
		setDoubleBuffered(true);
	
		ImageIcon reference = new ImageIcon("assets/scenario/background.png"); 
		background = reference.getImage();
		
		player = new PlayerCar();
		player.load();
		
		addKeyListener(new TecladoAdapter());
		timer = new Timer(5, this);
		timer.start();
		
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(background, 0, 0, null);
		graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		repaint();
	}
	
	private class TecladoAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
		}
	}
	
}
