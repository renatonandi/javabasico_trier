package br.com.trier.testes.farmacia.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.testes.farmacia.cliente.Cliente;
import br.com.trier.testes.farmacia.produtos.EquipamentosMedicos;
import br.com.trier.testes.farmacia.produtos.Medicamentos;
import br.com.trier.testes.farmacia.produtos.Perfumaria;
import br.com.trier.testes.farmacia.produtos.Produtos;

class FarmaciaUtilTest {
    
    private FarmaciaUtil fu = new FarmaciaUtil();
    
    @BeforeEach
    void init() {
        fu.getProdutos().clear();
        
        Produtos p1 = new Produtos("Produto1", 5, 20);
        Produtos m1 = new Medicamentos("Medicamento1", 2, 15, false);
        Produtos e1 = new EquipamentosMedicos("Equipamento Médico 1", 0, 100);
        Produtos pe1 = new Perfumaria("Perfume1", 2, 30);
        fu.cadastraProduto(p1);
        fu.cadastraProduto(m1);
        fu.cadastraProduto(e1);
        fu.cadastraProduto(pe1);
        
        Cliente cliente1 = new Cliente("Renato", 0);
        Cliente cliente2 = new Cliente("Vinicius", 200);
        
    }
    
    @Test
    @DisplayName("Teste de cadastro de produtos ")
    void cadastraProduto() {
        Produtos p3 = new Produtos("Produto3", 1, 40);
        fu.cadastraProduto(p3);
        assertEquals(5, fu.listaTodos().size());
    }
    
    @Test
    @DisplayName("Teste de listagem de equipamentos medicos")
    void listaEquipaentosMedicos() {
        assertEquals(1, fu.listaEquipamentosMedico().size());
        Produtos e2 = new EquipamentosMedicos("Equipamento Médico 2", 0, 200);
        fu.cadastraProduto(e2);
        assertEquals(2, fu.listaEquipamentosMedico().size());
    }
    
    @Test
    @DisplayName("Teste de listagem de medicamentos")
    void listaMedicamento() {
        assertEquals(1, fu.listaMedicamento().size());
        Produtos m2 = new Medicamentos("Medicamento 2", 0, 200, false);
        fu.cadastraProduto(m2);
        assertEquals(2, fu.listaMedicamento().size());
    }
    
    @Test
    @DisplayName("Teste de listagem de medicamentos com receita")
    void listaMedicamentoComReceita() {
        assertEquals(0, fu.listaMedicamentosReceita().size());
        Produtos mr = new Medicamentos("Medicamento 2", 0, 200, true);
        fu.cadastraProduto(mr);
        assertEquals(1, fu.listaMedicamentosReceita().size());
    }
    @Test
    @DisplayName("Teste de listagem de perfumarias")
    void listaPerfumaria() {
        assertEquals(1, fu.listaPerfumadia().size());
        Produtos pe2 = new Perfumaria("Perfume 2", 0, 150);
        fu.cadastraProduto(pe2);
        assertEquals(2, fu.listaPerfumadia().size());
    }
    @Test
    @DisplayName("Teste de venda medicamento")
    void vendaMedicamentoTest() {
        Medicamentos m3 = new Medicamentos("TesteVenda1", 5, 40, false);
        fu.cadastraProduto(m3);
        Cliente cliente = new Cliente("Cliente", 100);
        m3.realizaVenda(cliente, m3, 3);
        assertEquals(220, cliente.getDivida());
        assertEquals(2, m3.getEstoque());
    }
    
    @Test
    @DisplayName("Teste de venda sem estoque")
    void vendaMedicamentoSemEstoque() {
        Medicamentos medicamento = new Medicamentos("Medicamento", 5, 30, true);
        fu.cadastraProduto(medicamento);
        Cliente cliente = new Cliente("Cliente", 0);
        medicamento.realizaVenda(cliente, medicamento, 10, "Medico");
        assertEquals(5, medicamento.getEstoque());
        assertEquals(0, cliente.getDivida());
    }
    
    @Test
    @DisplayName("Teste de venda com divida alta")
    void vendaPerfumariaDividaClienteInvalida() {
        Perfumaria perfume = new Perfumaria("Perfume", 10, 100);
        fu.cadastraProduto(perfume);
        Cliente cliente = new Cliente("Cliente", 200);
        perfume.realizaVenda(cliente, perfume, 2);
        
        assertEquals(10, perfume.getEstoque());
        assertEquals(200, cliente.getDivida());
    }
    
    @Test
    @DisplayName("Teste de pagamento inteiro")
    void pagamentoInteiro() {
        Cliente cliente = new Cliente("Cliente", 200);
        fu.pagamentoTotal(cliente);
        
        assertEquals(0, cliente.getDivida());
    }

    @Test
    @DisplayName("Teste de pagamento parcial")
    void pagamentoParcial() {
        Cliente cliente = new Cliente("Cliente", 200);
        fu.pagamentoParcial(cliente, 100.00);
        
        assertEquals(100.00, cliente.getDivida());
    }
    
    @Test
    @DisplayName("Teste de pagamento parcial com valor maior que o devido")
    void pagamentoParcialValorInvalido() {
        Cliente cliente = new Cliente("Cliente", 200);
        fu.pagamentoParcial(cliente, 300.00);
        
        assertEquals(200.00, cliente.getDivida());
    }
    
    @Test
    @DisplayName("Teste de venda sem receita para medicamento com receita")
    void vendaMedicamentoSemReceitaInvalida() {
        Medicamentos medicamento = new Medicamentos("Medicamento", 5, 30, true);
        fu.cadastraProduto(medicamento);
        Cliente cliente = new Cliente("Cliente", 0);
        medicamento.realizaVenda(cliente, medicamento, 2);
        assertEquals(5, medicamento.getEstoque());
        assertEquals(0, cliente.getDivida());
    }
    
    @Test
    @DisplayName("Teste de venda com receita OK")
    void vendaMedicamentoComReceita() {
        Medicamentos medicamento = new Medicamentos("Medicamento", 5, 30, true);
        fu.cadastraProduto(medicamento);
        Cliente cliente = new Cliente("Cliente", 0);
        medicamento.realizaVenda(cliente, medicamento, 2, "Medico");
        assertEquals(3, medicamento.getEstoque());
        assertEquals(60, cliente.getDivida());
    }
    
    @Test
    @DisplayName("Teste de venda de equipamentos medicos")
    void vendaEquipamentosMedicos() {
        EquipamentosMedicos em = new EquipamentosMedicos("Medicamento", 0, 60);
        fu.cadastraProduto(em);
        Cliente cliente = new Cliente("Cliente", 0);
        em.realizaVenda(cliente, em, 2);
        assertEquals(120, cliente.getDivida());
    }
    
    @Test
    @DisplayName("Teste de venda de perfumaria OK")
    void vendaPerfumaria() {
        Perfumaria perfume = new Perfumaria("Perfume", 10, 100);
        fu.cadastraProduto(perfume);
        Cliente cliente = new Cliente("Cliente", 0);
        perfume.realizaVenda(cliente, perfume, 2);
        
        assertEquals(8, perfume.getEstoque());
        assertEquals(200, cliente.getDivida());
    }
    
    @Test
    @DisplayName("Teste de venda de produto sem estoque")
    void vendaProdutoSemEstoque() {
        Produtos produto = new Produtos("Perfume", 10, 100);
        fu.cadastraProduto(produto);
        Cliente cliente = new Cliente("Cliente", 0);
        produto.realizaVenda(cliente, produto, 15);
        
        assertEquals(10, produto.getEstoque());
        assertEquals(0, cliente.getDivida());
    }

}
