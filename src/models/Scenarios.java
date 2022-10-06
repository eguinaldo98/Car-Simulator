package models;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Scenarios {
	
	private Image image;
	private int x,y;
	private int altura, largura;
	private boolean isVisible;
	private String[] buildings = {// path das imagens que irão renderizar as construções
			"assets/scenario/bank.png",	
			"assets/scenario/casa sprite 1.png",	
			"assets/scenario/building.png",	
	};
	private String build;
	
	private static int VELOCIDADE = -8;// velocidade deve ser a mesma que a da Road
	
	public Scenarios(int x, int y, int build) {
		this.x = x;
		this.y = y;
		isVisible = true;
		this.build = buildings[build];// pega o path da imagem que sera utilizado na classe de simulador para setar o tipo de construção
	}
	
	public void load() {// funçao que irá carregar a imagem, que sera usada para desenhar na tela
		ImageIcon reference= new ImageIcon(build);
		image = reference.getImage();
		
		this.largura = image.getWidth(null);
		this.altura = image.getHeight(null);
	}
	
	public void update() {// faz a movimentação do elemento na tela
		this.x += VELOCIDADE;
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
