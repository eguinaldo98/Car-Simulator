package Simulator;

import javax.swing.JFrame;

import models.Simulator;

public class Window extends JFrame{

	public Window() {
		add(new Simulator());
		setTitle("Car Simulator");
		setSize(1024, 728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
	
	public static void main(String []args) {
		new Window();
	}
}
