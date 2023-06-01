package br.com.trier.testes.banco.caixa;

import br.com.trier.testes.banco.conta.ContaCorrente;

public class Caixa {
    
        
    public boolean operacaoSaque(ContaCorrente conta, double valor) {        
        return conta.saque(valor);
    }
    public boolean operacaoDeposito(ContaCorrente conta, double valor) {
        return conta.deposito(valor);
    }
    public boolean operacaoTransferencia(ContaCorrente contaDestino, ContaCorrente contaOrigem, double valor) {
        return contaOrigem.transferencia(contaDestino, contaOrigem, valor);
    }

}
