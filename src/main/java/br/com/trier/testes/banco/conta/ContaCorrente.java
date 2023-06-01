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
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }

    public boolean saque(double valor) {

        if ((getSaldo() - valor) < 0) {
            return false;
        }
        saldo = getSaldo() - valor;
        return true;

    }

    public boolean transferencia(ContaCorrente contaDestino, ContaCorrente contaOrigem, double valor) {

        if (saque(valor)) {
            if (contaDestino.deposito(valor)) {
                return true;
            } else {
                deposito(valor);
                return false;
            }
        }
        return false;
    }
}
