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
	private List <Scenarios> build;
	private Road road1, road2;
	
	public Simulator() {
		setFocusable(true);// deixa a tela em foco para manter um framerate adequado
		setDoubleBuffered(true);// mantem um buffer dos itens já renderizados para reutilizar em funçoes de pintura
	
		ImageIcon reference = new ImageIcon("assets/scenario/background.png"); 
		background = reference.getImage();
		
		player = new PlayerCar(2);
		road1 = new Road(0,0);
		road2 = new Road(1024,0);
		player.load();
		road1.load();
		road2.load();
		
		addKeyListener(new TecladoAdapter());
		timer = new Timer(15, this); // seta a velocidade do jogo e por consequencia a velocidade do carro
		timer.start();
		
		inicializeEntity();
		inicializeBuild();
		
	}
	
	public void inicializeEntity() {
		int entitysValue [] = new int[400];
		entity = new ArrayList<EntityCar>();
		
		for(int i = 1; i <= entitysValue.length; i++) {
			
			int x = (int) (Math.random() * 400 + 1024 + (i * 500));// posição na qual o carro será gerado no eixo x e garante que eles nao serao sobrepostos
			int y = (int) (423); // garante que o carro seá gerado na mesma altura ficando sempre na pista
			int model = (int) (Math.random() * 8 - 1);// escolhe um dos tipos de carro
			Car car =  new Car(model);;
			entity.add(new EntityCar(x, y, car, 2));// adiona o carro na lista
			
			int x2 = (int) (Math.random() * 1000 + 1024 + (i * 2000));
			int y2 = (int) (500);
			int model2 = (int) (Math.random() * 8 - 1);
			Car car2 = new Car(model2);
			entity.add(new EntityCar(x2+(i*10), y2, car2, 6));
		}

	}
	
	public void inicializeBuild() {
		int BuildValue [] = new int[400];
		build = new ArrayList<Scenarios>();
		
		for(int i = 1; i <= BuildValue.length; i++) {
			int x =  i * 300; // gera uma casa a cada 300 pixels
			int y = (int) (23);
			int j = (int) (Math.random() * 3);
			build.add(new Scenarios(x,y,j));
		}

	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(background, 0, 0, null);// desenha o background na tela
		graficos.drawImage(road1.getImage(), road1.getX(), road1.getY(), this);// desenha uma das pistas na tela
		graficos.drawImage(road2.getImage(), road2.getX(), road2.getY(), this);// desenha a pista auxiliar
		
		for(int j = 0; j < entity.size(); j++) {
			EntityCar en = entity.get(j);
			en.load();// carrega as informaçoes graficas dos carros gerados
			graficos.drawImage(en.getImage(), en.getX(), en.getY(), this);// desenha os carros randomicos
		}
		
		for(int j = 0; j < build.size(); j++) {
			Scenarios en = build.get(j);
			en.load();// carrega as informaçoes graficas das contruções 
			graficos.drawImage(en.getImage(), en.getX(), en.getY(), this);// desenha uma construção
		}
		
		graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);// o carro do jogador sempre deve ser desenhado por ultimo, para nao haver sobreposição dos demais elementos
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {// esta função atualiza a cada evento que ocorre no caso é baseado no timer, e nos eventos do teclado
		player.update();//atualiza a posição do player
		road1.update();// atualiza a posição da estrada
		road2.update();// atualiza a posição da segunda estrada

		for(int j = 0; j < entity.size(); j++) {
			EntityCar en = entity.get(j);
			if(en.isVisible()) {
				en.update();// caso o carro gerado seja visivel na tela e ainda nao tenha passado pelo player, ele atualiza a sua posição
			}else {
				entity.remove(j);// caso o carro seja gerado e ja tenha passado pela tela ele é removido
			}
			
		}
		
		for(int j = 0; j < build.size(); j++) {
			Scenarios en = build.get(j);
			if(en.isVisible()) {
				en.update();// mesma lógica dos carros acima
			}else {
				build.remove(j);
			}
			
		}
		
		repaint();// redesenha os elementos na tela 
	}
	
	private class TecladoAdapter extends KeyAdapter{// funçoes para capturar eventos do teclado
		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
			int code = e.getKeyCode();
			if(code == KeyEvent.VK_RIGHT) {// caso o jogador pressione a tecla da seta direita o jogo irá acelerar e o carro se movera para frente
					 timer.setDelay(15);
			}
			if(code == KeyEvent.VK_LEFT) {// caso o jogador pressione a tecla da seta da esquer o jogador irá reduzer a velocidade e irá se mover para tras
				 timer.setDelay(30);
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
			
			int code = e.getKeyCode();
			if(code == KeyEvent.VK_RIGHT) {// caso nao pressione nenhuma tecla a velocidade do jogo se manterá em 20 e o carr ficara em uma posição na tela
				 timer.setDelay(20);;
			}
			if(code == KeyEvent.VK_LEFT) {// caso nao pressione nenhuma tecla a velocidade do jogo se manterá em 20 e o carr ficara em uma posição na tela
				 timer.setDelay(20);;
			}
		}
	}
	
}
