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
	private int lastCoordenate;
	
	public Simulator() {
		setFocusable(true);
		setDoubleBuffered(true);
	
		ImageIcon reference = new ImageIcon("assets/scenario/background.png"); 
		background = reference.getImage();
		
		player = new PlayerCar(new Car(1, 230, 2, 2));
		road1 = new Road(0,0);
		road2 = new Road(1024,0);
		player.load();
		road1.load();
		road2.load();
		
		addKeyListener(new TecladoAdapter());
		timer = new Timer(10, this);
		timer.start();
		
		inicializeEntity();
		
	}
	
	public void inicializeEntity() {
		int entitysValue [] = new int[400];
		entity = new ArrayList<EntityCar>();
		
		for(int i = 1; i <= entitysValue.length; i++) {
			
			int x = (int) (Math.random() * 400 + 1024 + (i * 500));
			int y = (int) (423);
			int model = (int) (Math.random() * 8 - 1);
			Car car =  new Car(1, 230, 2, model);;
			entity.add(new EntityCar(x, y, car, 1));
			
			int x2 = (int) (Math.random() * 400 + 1024 + (i * 500));
			int y2 = (int) (500);
			int model2 = (int) (Math.random() * 8 - 1);
			Car car2 = new Car(1, 230, 2, model2);
			entity.add(new EntityCar(x2+(i*10), y2, car2, 5));
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
			int code = e.getKeyCode();
			if(code == KeyEvent.VK_RIGHT) {
				 if(player.getX() <= 11) {
					 timer.setDelay(3);;
				 }
			}
			if(code == KeyEvent.VK_LEFT) {
				 timer.setDelay(20);
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
			
			int code = e.getKeyCode();
			if(code == KeyEvent.VK_RIGHT) {
				 timer.setDelay(5);;
			}
			if(code == KeyEvent.VK_LEFT) {
				 timer.setDelay(5);;
			}
		}
	}
	
}
