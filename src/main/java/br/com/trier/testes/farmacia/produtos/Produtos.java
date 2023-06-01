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
	
	
	public boolean isEstoque(Produtos produto, int quantidade) {		
		if ((produto.getEstoque() - quantidade) > 0) {
			return true ;
		}
		return false;
	}
	
	public boolean realizaVenda(Cliente cliente, Produtos produto, Integer quantidade) {
		if ((estoque - quantidade) > 0) {
			estoque -= quantidade;
			cliente.setDivida(cliente.getDivida() + (valor * quantidade)); 
			return true;
		}
		return false;
	}

}
