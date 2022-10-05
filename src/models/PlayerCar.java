package models;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class PlayerCar {
	
	private int x,y;
	private int dx,dy;
	private Image imagem;
	private int altura, largura;
	
	public PlayerCar() {
		this.x = 100;
		this.y = 500;
		

	}
	
	public void load(){
		ImageIcon reference = new ImageIcon("assets/cars/sportive-black-car.png");
		imagem = reference.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}	
	
	public void update(){
		x += dx;
		y += dy;
		
		if( x >= 500) {
			x = 500;
		}
		
		if( x <= 10) {
			x = 10;
		}
		
		if( y >= 550) {
			y = 550;
		}
		
		if( y <= 400) {
			y = 400;
		}
		
	}
	
	public void keyPressed(KeyEvent key) {
		int code = key.getKeyCode();

		if(code == KeyEvent.VK_UP) {
			dy = -3;
		}
		if(code == KeyEvent.VK_DOWN) {
			dy = 3;
		}
		if(code == KeyEvent.VK_LEFT) {
			dx = -3;
		}
		if(code == KeyEvent.VK_RIGHT) {
			dx = 3;
		}	
	}
	
	public void keyReleased(KeyEvent key) {
		int code = key.getKeyCode();
		
		if(code == KeyEvent.VK_UP) {
			dy = 0;
		}
		if(code == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		if(code == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if(code == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}	
	
}
