package models;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Road {
	
	private Image image;
	private int x,y;
	private int altura, largura;
	private boolean isVisible;
	
	
	private static int VELOCIDADE = -2;
	
	public Road(int x, int y) {
		this.x = x;
		this.y = y;
		isVisible = true;
	}
	
	public void load() {
		ImageIcon reference= new ImageIcon("assets/scenario/Road.png");
		image = reference.getImage();
		
		this.largura = image.getWidth(null);
		this.altura = image.getHeight(null);
	}
	
	public void update() {
		this.x += VELOCIDADE;
		
		if(this.x <-1024) {
			this.x = 1023;
		}
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public static int getVELOCIDADE() {
		return VELOCIDADE;
	}

	public static void setVELOCIDADE(int vELOCIDADE) {
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
