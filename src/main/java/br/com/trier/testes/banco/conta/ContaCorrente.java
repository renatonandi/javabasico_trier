package br.com.trier.testes.banco.conta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContaCorrente {

	private int numero;
	private int agencia;
	private String nomeCorrentista;
	protected Double saldo;

	public boolean deposito(double valor) {
		saldo += valor;
		return true;
	}

	public boolean saque(double valor) {

		if ((getSaldo() - valor) < 0) {
			return false;
		}
		saldo -= valor;
		return true;

	}

	public boolean transferencia(ContaCorrente contaDestino, ContaCorrente contaOrigem, double valor) {

		if (!contaOrigem.saque(valor)) {
			return false;
		} else if (!contaDestino.deposito(valor)) {
			contaOrigem.deposito(valor);
			return false;
		}else {
		return contaDestino.deposito(valor) && contaOrigem.saque(valor);
		}
	}
}
