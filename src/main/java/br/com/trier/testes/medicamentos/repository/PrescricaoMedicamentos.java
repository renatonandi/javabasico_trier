package br.com.trier.testes.medicamentos.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.trier.testes.medicamentos.models.Medicamento;
import br.com.trier.testes.medicamentos.models.Pessoa;
import lombok.Getter;

@Getter
public class PrescricaoMedicamentos {
	private Map<String, Medicamento> medicamentos;
	private Map<Integer, Pessoa> pessoas;
	private int nextId;
	
	
	public PrescricaoMedicamentos() {
		medicamentos = new HashMap<>();
		pessoas = new HashMap<>();
		nextId = 1;
	}
	
	
	public void cadastrarMedicamento(Medicamento medicamento) {
		medicamentos.put(medicamento.getNome(), medicamento);
	}
	
	
	public void cadastrarPessoa(Pessoa pessoa) {
		pessoa.setId(nextId);
		pessoas.put(nextId, pessoa);
		nextId++;
	}
	
	
	public boolean prescreverMedicamentoParaPessoa(Integer pessoaId, String nomeMedicamento) {
		Pessoa pessoa = pessoas.get(pessoaId);
		Medicamento medicamento = medicamentos.get(nomeMedicamento);
		
		if (pessoa != null && medicamento != null && pessoa.getMedicamentosPrescritos().isEmpty()) {
			if (medicamento.getIndicacoes().contains(pessoa.getSintoma())) {
				boolean possuiAlergia = pessoa.getAlergias().stream().anyMatch(medicamento.getAlergias()::contains);
				if (!possuiAlergia) {
					pessoa.addMedicamentoPrescrito(medicamento);
					return true;
				}
			}
			
		}
		return false;
	}
	
	public Pessoa findById(Integer id) {			
		return pessoas.get(id);
	}
	
	
	public Medicamento buscarPorNome(String nomeMedicmanto) {
		return medicamentos.get(nomeMedicmanto);
	}
	
	
	public List<String> listPessoasMedicamentos() {
		return pessoas.values().stream().map(Pessoa::toString).collect(Collectors.toList());
	}
	
	
	public void clearData() {
		pessoas.clear();
		medicamentos.clear();
	}

}
