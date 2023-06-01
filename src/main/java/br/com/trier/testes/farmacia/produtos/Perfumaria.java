package br.com.trier.testes.farmacia.produtos;

import br.com.trier.testes.farmacia.cliente.Cliente;
import lombok.Getter;

@Getter
public class Perfumaria extends Produtos{

	public Perfumaria(String nome, int estoque, double valor) {
		super(nome, estoque, valor);
	}
	
	@Override
	public boolean realizaVenda(Cliente cliente, Produtos produto) {
		if (cliente.getDivida() < 300.00 && isEstoque(produto)) {
			super.realizaVenda(cliente, produto);
			return true;
		}
		return false;
	}

}
