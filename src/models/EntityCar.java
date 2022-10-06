package models;

import java.awt.Image;

import javax.swing.ImageIcon;

public class EntityCar {
	
	private Image image;
	private double x,y;
	private int altura, largura;
	private boolean isVisible;
	private Car car;
	
	private double VELOCIDADE;
	
	public EntityCar(int x, int y, Car car, double velocidade) {// esse construtor nos permite definir o tipo de carro e sua velocidade para tornar o jogo mais dinamico
		this.x = x;
		this.y = y;
		isVisible = true;
		this.car = car;
		this.VELOCIDADE = velocidade * -1;
	}
	
	public void load() {// carrega a imagem do carro que sera usado
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
		return (int) VELOCIDADE;
	}

	public void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
	}

	public Image getImage() {
		return image;
	}

	public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}
	
}
