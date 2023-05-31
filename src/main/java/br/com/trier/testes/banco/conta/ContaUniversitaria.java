package br.com.trier.testes.banco.conta;

public class ContaUniversitaria extends ContaCorrente{
    private final Double saldoLimite = 2000.00;

    public ContaUniversitaria(int numero, int agencia, String nomeCorrentista, Double saldo) {
        super(numero, agencia, nomeCorrentista, saldo);
    }


    @Override
    public boolean deposito(double valor) {
        try {
            if (getSaldo() + valor > saldoLimite) {
                throw new Exception("Deposito inválido");
            }
            return super.deposito(valor);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
