package br.com.trier.testes.banco.conta;

public class ContaEspecial extends ContaCorrente{
	private Double limite;

    public ContaEspecial(int numero, int agencia, String nomeCorrentista, Double saldo, Double limite) {
        super(numero, agencia, nomeCorrentista, saldo);
        this.limite = limite;
        
    }
    
    
    
    @Override
    public boolean saque(double valor) {       
       
            if (saldo + limite < valor) {
            	return false;
            }else if (saldo + limite >= valor) {				
            	saldo = getSaldo() - valor;
			}
            return true;
			
    }

}
