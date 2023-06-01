package br.com.trier.testes.banco.conta;

public class ContaUniversitaria extends ContaCorrente {
	private final Double saldoLimite = 2000.00;

	public ContaUniversitaria(int numero, int agencia, String nomeCorrentista, Double saldo) {
		super(numero, agencia, nomeCorrentista, saldo);
		this.saldo = saldo;
	}

	@Override
	public boolean deposito(double valor) {

		if (saldoLimite >= saldo + valor) {
			return super.deposito(valor);
		} else {			
			return false;
		}
	}

}
