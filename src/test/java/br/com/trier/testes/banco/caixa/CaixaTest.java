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
    private Caixa caixa = new Caixa();
    private ContaCorrente contaCorrente;
    private ContaEspecial contaEspecial;
    private ContaUniversitaria contaUniversitaria;
    
   
    @BeforeEach
    void init() {
                
        contaCorrente = new ContaCorrente(123, 001, "Renato", 1000.00);
        contaEspecial = new ContaEspecial(124, 001, "João", 1500.00);
        contaUniversitaria = new ContaUniversitaria(125, 002, "Universitário", 100.00);
        
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
        assertEquals(500.00, contaCorrente.getSaldo(), 0.01);
        
        assertFalse(caixa.operacaoSaque(contaCorrente, 1500.00));
        assertThrows(Exception.class, () -> {
            contaCorrente.saque(1500);
        });
        
    }

}
