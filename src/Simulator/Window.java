package Simulator;

import javax.swing.JFrame;

import models.Simulator;

public class Window extends JFrame{

	/*
	 * Copyright (C) 2022 by Eguinaldo Couras de Oliveira Junior
	 * 
	 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
	 * software and associated documentation files (Car game), to deal in the Software
	 * without restriction, including without limitation the rights to use, copy, modify, merge,
	 * publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to
	 * whom the Software is furnished to do so, subject to the following conditions:
	 * The above copyright notice and this permission notice shall be included in all copies or
	 * substantial portions of the Software.
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public Window() {
		add(new Simulator());// adiciona os elementos do simulador na tela
		setTitle("Car Simulator");// seta o nome da janema
		setSize(1024, 728);// define o tamanho da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// adiciona o botao de fechar na janea
		setLocationRelativeTo(null);//a janela irá aparecer no meio da tela, tamanho relativo ao monitor
		this.setResizable(false);// nao é possivel redimencionar a janela
		setVisible(true);// deixa a janela visivel
	}
	
	public static void main(String []args) {
		new Window();
	}
}
