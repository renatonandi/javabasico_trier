package br.com.trier.testes.banco.caixa;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.testes.banco.conta.ContaCorrente;
import br.com.trier.testes.banco.conta.ContaEspecial;
import br.com.trier.testes.banco.conta.ContaUniversitaria;

class CaixaTest {
    Caixa caixa = new Caixa();
    private ContaCorrente contaCorrente;
    private ContaCorrente contaEspecial;
    private ContaCorrente contaUniversitaria;
    
   
    @BeforeEach
    void init() {
    	
                
        contaCorrente = new ContaCorrente(123, 001, "Renato", 1000.00);
        contaEspecial = new ContaEspecial(124, 001, "João", 1500.00, 500.00);
        contaUniversitaria = new ContaUniversitaria(125, 002, "Universitário", 500.00);
        
    }
    
    
    @Test
    @DisplayName("Teste de depositos da conta corrente")
    void depositoContaCorreteTest() {
        assertTrue(caixa.operacaoDeposito(contaCorrente, 500.00));
        assertEquals(1500.00, contaCorrente.getSaldo());
               
    }
    
    
    @Test
    @DisplayName("Teste de saque da conta corrente")
    void saqueContaCorrente() {
        assertTrue(caixa.operacaoSaque(contaCorrente, 500.00));
        assertEquals(500.00, contaCorrente.getSaldo());      
        
    }
    
    
    @Test
    @DisplayName("Teste saque conta corrente com valor inválido")
    void saqueContaCorrenteValorInvalido() {
    	assertFalse(caixa.operacaoSaque(contaCorrente, 1500.00));
        assertEquals(1000.00, contaCorrente.getSaldo()); 
    	
    }
    
    @Test
    @DisplayName("Teste deposito conta especial")
    void depositoContaEspecial() {
    	assertTrue(caixa.operacaoDeposito(contaEspecial, 1000.00));
    	assertEquals(2500.00, contaEspecial.getSaldo());
    }
    
    @Test
    @DisplayName("Teste retirada conta especial usando saldo especial")
    void saqueContaEspecial() {
    	assertTrue(caixa.operacaoSaque(contaEspecial, 1700.00));
    	assertEquals(300.00, contaEspecial.getSaldo());
    }
    
    @Test
    @DisplayName("Teste retirada conta especial com saldo insuficiente")
    void saqueContaEspecialValorInvalido() {
    	assertFalse(caixa.operacaoSaque(contaEspecial, 2500));
    	assertEquals(1500.00, contaEspecial.getSaldo());
    }
    
    @Test
    @DisplayName("Teste deposito conta universitária com valor valido")
    void depositoContaUniversitariaValorValido() {
    	assertTrue(caixa.operacaoDeposito(contaUniversitaria, 1000.00));
    	assertEquals(1500.00, contaUniversitaria.getSaldo());
    }
    
    @Test
    @DisplayName("Teste deposito conta universitaria com valor inválido")
    void depositoContaUniversitariaValorInvalido() {
    	assertFalse(caixa.operacaoDeposito(contaUniversitaria, 1600.00));
    	assertEquals(500.00, contaUniversitaria.getSaldo());
    }
    
    @Test
    @DisplayName("Teste transferencia para conta corrente")
    void transferenciaContaCorrente() {
    	assertTrue(caixa.operacaoTransferencia(contaCorrente, contaEspecial, 500.00));
    	assertEquals(2000.00, contaCorrente.getSaldo());
    	assertEquals(1500.00, contaEspecial.getSaldo());
    }
    
    @Test
    @DisplayName("Teste transferenda tirando da conta especial com valor invalido")
    void transferenciaValorInvalido() {
    	assertFalse(caixa.operacaoTransferencia(contaCorrente, contaUniversitaria, 2100.00));
    	assertEquals(1000.00, contaCorrente.getSaldo());
    	assertEquals(1500.00, contaEspecial.getSaldo());
    }
    
    @Test
    @DisplayName("Teste de transferencia para conta universitaria estourando limite da conta")
    void transferenciaContaUniversitariaSemLimite() {
    	assertFalse(caixa.operacaoTransferencia(contaUniversitaria, contaEspecial, 1900.00));
    	assertEquals(500.00, contaUniversitaria.getSaldo());
    	assertEquals(2000.00, contaEspecial.getSaldo());
    }
    
    

}
