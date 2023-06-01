package br.com.trier.testes.farmacia.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Cliente {
	private String nome;
	@Setter
	private double divida;
	
	
	public boolean isDevedor(Cliente cliente) {
		if (cliente.getDivida() > 0) {
			return true;
		}
		return false;
	}
	
	

}
