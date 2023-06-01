package br.com.trier.testes.farmacia.produtos;

import br.com.trier.testes.farmacia.cliente.Cliente;
import lombok.Getter;

@Getter
public class Medicamentos extends Produtos {

	private boolean receita;

	public Medicamentos(String nome, int estoque, double valor, boolean receita) {
		super(nome, estoque, valor);
		this.receita = receita;
	}

	@Override
	public boolean realizaVenda(Cliente cliente, Produtos produto) {
		if (!receita && isEstoque(produto)) {
			super.realizaVenda(cliente, produto);
			return true;
		}
		return false;
	}

	public boolean vendaReceita(Cliente cliente, Produtos produto, String nomeMedico) {
		if (isEstoque(produto)) {
			super.realizaVenda(cliente, produto);
			return true;
		}
		return false;
	}

}
