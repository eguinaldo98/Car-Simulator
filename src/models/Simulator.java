package models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Simulator extends JPanel implements ActionListener {
	
	private Image background;
	private PlayerCar player;
	private Timer timer;
	private List <EntityCar> entity;
	private Road road1, road2;
	
	public Simulator() {
		setFocusable(true);
		setDoubleBuffered(true);
	
		ImageIcon reference = new ImageIcon("assets/scenario/background.png"); 
		background = reference.getImage();
		
		player = new PlayerCar();
		player.load();
		road1 = new Road(0,0);
		road2 = new Road(1024,0);
		road1.load();
		road2.load();
		
		
		addKeyListener(new TecladoAdapter());
		timer = new Timer(5, this);
		timer.start();
		
		inicializeEntity();
		
	}
	
	public void inicializeEntity() {
		int entitysValue [] = new int[40];
		entity = new ArrayList<EntityCar>();
		
		for(int i = 0; i < entitysValue.length; i++) {
			int x = (int) (Math.random() * 8000 + 1024);
			int y = (int) (450);
			entity.add(new EntityCar(x,y));
			int x2 = (int) (Math.random() * 8000 + 1024);
			int y2 = (int) (500);
			entity.add(new EntityCar(x2,y2));
		}

	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(background, 0, 0, null);
		graficos.drawImage(road1.getImage(), road1.getX(), road1.getY(), this);
		graficos.drawImage(road2.getImage(), road2.getX(), road2.getY(), this);
		

		
		for(int j = 0; j < entity.size(); j++) {
			EntityCar en = entity.get(j);
			en.load();
			graficos.drawImage(en.getImage(), en.getX(), en.getY(), this);
		}
		
		
		graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		road1.update();
		road2.update();
		
		for(int j = 0; j < entity.size(); j++) {
			EntityCar en = entity.get(j);
			if(en.isVisible()) {
				en.update();
			}else {
				entity.remove(j);
			}
			
		}
		

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
