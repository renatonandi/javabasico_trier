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
    private List<Medicamento> medicamentos;
    private List<Pessoa> pessoas;

    public PrescricaoMedicamentos() {
        medicamentos = new ArrayList<>();
        pessoas = new ArrayList<>();
    }

    public void cadastrarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        pessoa.setId(pessoas.size() + 1);
        pessoas.add(pessoa);
        return pessoa;
    }

    public boolean prescreverMedicamentoParaPessoa(Integer pessoaId) {
		Pessoa pessoa = findPessoaById(pessoaId);
		if (pessoa == null) {
            return false;
        }		
		List<Medicamento> medicamentosPrescritos = medicamentos.stream().filter(medicamento -> medicamento.getIndicacoes().contains(pessoa.getSintoma()))
		        .filter(medicamento -> !isAlergia(pessoa, medicamento)).collect(Collectors.toList()); 
		
		pessoa.getMedicamentosPrescritos().addAll(medicamentosPrescritos);
		return true;
	}
    

    public Pessoa findPessoaById(Integer id) {
        return pessoas.stream().filter(p -> id.equals(p.getId())).findAny().orElse(null);
    }
    
    public Medicamento findMedicamento(String nome) {
        return medicamentos.stream().filter(m -> m.getNome().equals(nome)).findFirst().orElse(null);
    }
    

    private boolean isAlergia(Pessoa pessoa, Medicamento medicamento) {
        List<String> alergias = pessoa.getAlergias();
        List<String> alergiasContraindicadas = medicamento.getAlergias();

        return alergias.stream().anyMatch(alergia -> alergiasContraindicadas.contains(alergia));
    }
    

    public List<String> listPessoasMedicamentos() {
        return pessoas.stream().map(p -> p.toString()).collect(Collectors.toList());
    }
    

    public void clearData() {
        pessoas.clear();
        medicamentos.clear();
    }

}
