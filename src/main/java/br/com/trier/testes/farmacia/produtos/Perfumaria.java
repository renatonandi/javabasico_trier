package br.com.trier.testes.farmacia.produtos;

import lombok.Getter;

@Getter
public class Perfumaria extends Produtos{

	public Perfumaria(String nome, int estoque, double valor) {
		super(nome, estoque, valor);
	}

}
