package br.com.trier.testes.farmacia.produtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Produtos {
	private String nome;
	private int estoque;
	private double valor;
	
	
	public boolean isEstoque(Produtos produto) {		
		if (produto.getEstoque() > 0) {
			return true ;
		}
		return false;
	}
	
	public boolean autorizaVenda() {
		return true;
	}

}
