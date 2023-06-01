package br.com.trier.testes.farmacia.produtos;

import lombok.Getter;

@Getter
public class EquipamentosMedicos extends Produtos{

	public EquipamentosMedicos(String nome, int estoque, double valor) {
		super(nome, 0, valor);
	}

}
