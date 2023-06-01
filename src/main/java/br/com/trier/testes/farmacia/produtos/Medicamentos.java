package br.com.trier.testes.farmacia.produtos;

import lombok.Getter;

@Getter
public class Medicamentos extends Produtos{
	private boolean receita;
	private String nomeMedico;

	public Medicamentos(String nome, int estoque, double valor, boolean receita) {
		super(nome, estoque, valor);
		this.receita = receita;
	}
	
	

}
