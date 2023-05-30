package br.com.trier.testes.medicamentos.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

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
		Medicamento medicamento2 = new Medicamento("Paracetamol", UsoEnum.ORAL, Arrays.asList("Alergia1", "Alergia2"), Arrays.asList("Dor de cabeça", "Febre"));
		
		pm.cadastrarMedicamento(medicamento1);
		pm.cadastrarMedicamento(medicamento2);
		
		Pessoa pessoa1 = new Pessoa(1, "Renato", "Dor de cabeça", Arrays.asList("Alergia1", "Alergia2")); 
		Pessoa pessoa2 = new Pessoa(2, "João", "Febre", Arrays.asList("Alergia2")); 
		pm.cadastrarPessoa(pessoa1);
		pm.cadastrarPessoa(pessoa2);
		
	}
	
	@Test
	void cadastrarMedicamentoTest() {
		Medicamento medicamento = new Medicamento("Aspirina", UsoEnum.ORAL, Arrays.asList("Alergia3"), Arrays.asList("Dor de cabeça", "Febre"));
		pm.cadastrarMedicamento(medicamento);		

		assertEquals(medicamento, pm.buscarPorNome("Aspirina"));
	}
	
	
}
