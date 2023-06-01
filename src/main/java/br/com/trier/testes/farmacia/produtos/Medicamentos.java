package br.com.trier.testes.farmacia.produtos;

import br.com.trier.testes.farmacia.cliente.Cliente;
import lombok.Getter;

@Getter
public class Medicamentos extends Produtos {

	private boolean receita;
	private String nomeMedico;

	public Medicamentos(String nome, int estoque, double valor, boolean receita) {
		super(nome, estoque, valor);
		this.receita = receita;
	}
	

	@Override
	public boolean realizaVenda(Cliente cliente, Produtos produto, Integer quantidade) {
		if (!receita && isEstoque(produto, quantidade)) {
			super.realizaVenda(cliente, produto, quantidade);
			return true;
		}
		return false;
	}

	public boolean realizaVenda(Cliente cliente, Produtos produto, Integer quantidade, String nomeMedico) {
		if (isEstoque(produto, quantidade)) {
			super.realizaVenda(cliente, produto, quantidade);
			return true;
		}
		return false;
	}

}
