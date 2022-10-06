package models;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Road {
	
	private Image image;
	private int x,y;
	private int altura, largura;
	private boolean isVisible;
	
	private static int VELOCIDADE = -8;
	
	public Road(int x, int y) {
		this.x = x;
		this.y = y;
		isVisible = true;
	}
	
	public void load() {// carrega a imagem que sera usada para desenhar a pista
		ImageIcon reference= new ImageIcon("assets/scenario/Road.png");
		image = reference.getImage();
		
		this.largura = image.getWidth(null);
		this.altura = image.getHeight(null);
	}
	
	public void update() {
		this.x += VELOCIDADE;
		
		if(this.x <-1023) {// com isso nao precisamos criar uma estrada GIANTESCA e permitimos um looping da estrada
			this.x = 1023;// sempre que ela chegar no seu limite da tela ela volta para o inicio, com isso precisamos apenas de duas estradas que ficam em um looping infinito e tornando o jogo sem limites
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
