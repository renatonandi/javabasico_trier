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
        try {
            if ((getSaldo() - valor) < 0) {
                throw new Exception("Saldo insuficiente");
            }
            saldo -= valor;
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean transferencia(ContaCorrente contaDestino, ContaCorrente contaOrigem, double valor) {
        try {
            if (saque(valor) == false) {
                throw new Exception("Transferencia não realizada");
            }
            contaDestino.deposito(valor);
            contaOrigem.saque(valor);
            
        } catch (Exception e) {
            
        }
        return false;
    }
    
    
    
}
