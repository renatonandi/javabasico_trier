package br.com.trier.testes.banco.conta;

public class ContaEspecial extends ContaCorrente{
    private int limite;

    public ContaEspecial(int numero, int agencia, String nomeCorrentista, Double saldo) {
        super(numero, agencia, nomeCorrentista, saldo);
    }
    
    @Override
    public boolean saque(double valor) {
        
        try {
            if (saldo - valor < -limite) {
                throw new Exception("Saldo insuficiente");
            }
            saldo -= valor;
            return true;
            
        } catch (Exception e) {
            System.out.println(e);
        }        
        return false;
    }

}
