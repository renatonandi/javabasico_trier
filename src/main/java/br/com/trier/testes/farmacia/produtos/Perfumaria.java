package br.com.trier.testes.farmacia.produtos;

import br.com.trier.testes.farmacia.cliente.Cliente;
import lombok.Getter;

@Getter
public class Perfumaria extends Produtos{

	public Perfumaria(String nome, int estoque, double valor) {
		super(nome, estoque, valor);
	}
	
	@Override
	public boolean realizaVenda(Cliente cliente, Produtos produto, Integer quantidade) {
		if (cliente.getDivida() + (produto.getValor() * quantidade) < 300.00 && isEstoque(produto, quantidade)) {
			super.realizaVenda(cliente, produto, quantidade);
			return true;
		}
		return false;
	}

}
