package br.com.trier.testes.medicamentos.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.trier.testes.medicamentos.enums.UsoEnum;
import br.com.trier.testes.medicamentos.models.Medicamento;
import br.com.trier.testes.medicamentos.models.Pessoa;

public class PrescricaoMedicamentosTest {
	
	
	private PrescricaoMedicamentos pm = new PrescricaoMedicamentos();
	
	
	@BeforeEach
	void init() {
		pm.clearData();
		
		
		
		Medicamento medicamento1 = new Medicamento("Ibuprofeno", UsoEnum.ORAL, Arrays.asList("Alergia1"), Arrays.asList("Dor de cabeça", "Inflamação"));
		Medicamento medicamento2 = new Medicamento("Paracetamol", UsoEnum.ORAL, Arrays.asList("Alergia2"), Arrays.asList("Febre", "Dor no corpo"));
		
		pm.cadastrarMedicamento(medicamento1);
		pm.cadastrarMedicamento(medicamento2);
		
		Pessoa pessoa1 = new Pessoa("Renato", "Dor de cabeça", Arrays.asList("Alergia1", "Alergia2")); 
		Pessoa pessoa2 = new Pessoa("João", "Febre", Arrays.asList("Alergia2")); 
		pm.cadastrarPessoa(pessoa1);
		pm.cadastrarPessoa(pessoa2);
		
	}
	
	@Test
	void cadastrarMedicamentoTest() {
		Medicamento medicamento3 = new Medicamento("Aspirina", UsoEnum.ORAL, Arrays.asList("Alergia3"), Arrays.asList("Dor de cabeça", "Inflamação"));
		pm.cadastrarMedicamento(medicamento3);	
		
		Medicamento medicamentoEncontrado = pm.findMedicamento("Aspirina");
		assertNotNull(medicamentoEncontrado);

		assertEquals("Aspirina", medicamentoEncontrado.getNome());
	}
	
	@Test
	void cadastrarPessoaTest() {
	    Pessoa pessoa3 = new Pessoa("Beatriz", "Dor de cabeça", Arrays.asList("Alergia2"));
	    pm.cadastrarPessoa(pessoa3);
	    
	    Pessoa pessoaEncontrada = pm.findPessoaById(3);
	    assertNotNull(pessoaEncontrada);
	    assertEquals("Beatriz", pessoaEncontrada.getNome());
	    
	}
	@Test	
	void listPessoasMedicamentosTest() {
	    List<String> pessoasMedicamentos = pm.listPessoasMedicamentos();
	    assertEquals(2, pessoasMedicamentos.size());
	    assertEquals("Pessoa: Renato, Sintoma: Dor de cabeça, Medicamento: Ibuprofeno, ORAL", pessoasMedicamentos.get(0));
	    assertEquals("Pessoa: João, Sintoma: Febre, Medicamento: Ibuprofeno, ORAL", pessoasMedicamentos.get(1));
	}
	
	
}
