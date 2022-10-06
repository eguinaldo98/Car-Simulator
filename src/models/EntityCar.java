package models;

import java.awt.Image;

import javax.swing.ImageIcon;

public class EntityCar {
	
	private Image image;
	private int x,y;
	private int altura, largura;
	private boolean isVisible;
	private Car car;
	
	private int VELOCIDADE;
	
	public EntityCar(int x, int y, Car car, int velocidade) {
		this.x = x;
		this.y = y;
		isVisible = true;
		this.car = car;
		this.VELOCIDADE = velocidade * -1;
	}
	
	public void load() {
		ImageIcon reference= new ImageIcon(car.getModel());
		image = reference.getImage();
		
		this.largura = image.getWidth(null);
		this.altura = image.getHeight(null);
	}
	
	public void update() {
		this.x += VELOCIDADE;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public int getVELOCIDADE() {
		return VELOCIDADE;
	}

	public void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
	}

	public Image getImage() {
		return image;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
