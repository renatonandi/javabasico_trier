package br.com.trier.testes.farmacia.produtos;

import br.com.trier.testes.farmacia.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Produtos {
	private String nome;
	private int estoque;
	protected double valor;
	
	
	public boolean isEstoque(Produtos produto) {		
		if (produto.getEstoque() > 0) {
			return true ;
		}
		return false;
	}
	
	public boolean realizaVenda(Cliente cliente, Produtos produto) {
		if (estoque > 0) {
			estoque -= 1;
			cliente.setDivida(cliente.getDivida() + valor); 
			return true;
		}
		return false;
	}

}
