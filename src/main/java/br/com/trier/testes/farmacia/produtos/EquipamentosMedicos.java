package br.com.trier.testes.farmacia.produtos;

import br.com.trier.testes.farmacia.cliente.Cliente;
import lombok.Getter;

@Getter
public class EquipamentosMedicos extends Produtos{

	public EquipamentosMedicos(String nome, int estoque, double valor) {
		super(nome, 0, valor);
	}
	
	@Override
	public boolean realizaVenda(Cliente cliente, Produtos produto, Integer quantidade) {
		cliente.setDivida(cliente.getDivida() + (valor * quantidade));
		return true;
	}

}
