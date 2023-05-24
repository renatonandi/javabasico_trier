package br.com.trier.aula_2.carros;

import javax.swing.JOptionPane;

public class Util {

	static int opcaoSelecionada() {
		String menu = "1 - Cadastrar novo carro\n" + "2 - Listar carros por período de fabricação\n"
				+ "3 - Listar carros por marca\n" + "4 - Listar carros por cor\n\n" + "5 - Sair";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
	

}
