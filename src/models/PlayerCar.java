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
	private Car car;
	
	public PlayerCar(Car car) {// esse construtor garante que o player será spawnado sempre no mesmo lugar
		this.x = 100;
		this.y = 500;
		this.car = car;
	}
	
	public void load(){// carrega a imagem do carro que o player irá correr
		ImageIcon reference = new ImageIcon(car.getModel());
		imagem = reference.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}	
	
	public void update(){
		x += dx;
		y += dy;
		
		if( x >= 650) {
			x = 650;
		}
		
		if( x <= 10) {
			x = 10;
		}
		
		if( y >= 524) {
			y = 525;
		}
		
		if( y <= 355) {
			y = 355;
		}
		
	}
	
	public void keyPressed(KeyEvent key) {// captura eventos do teclado
		int code = key.getKeyCode();

		if(code == KeyEvent.VK_UP) {// faz o carro se mover para cima
			dy = -5;
		}
		if(code == KeyEvent.VK_DOWN) {// faz o carro se mover para baixo
			dy = 5;
		}
		if(code == KeyEvent.VK_LEFT) {// faz o carro se mover para tras
			dx = -3;
		}
		if(code == KeyEvent.VK_RIGHT) {// faz o carro se mover para frente
			dx = 10;
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
