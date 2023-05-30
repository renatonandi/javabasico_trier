package br.com.trier.testes.medicamentos.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.trier.testes.medicamentos.models.Medicamento;
import br.com.trier.testes.medicamentos.models.Pessoa;
import lombok.Getter;

@Getter
public class PrescricaoMedicamentos {
     List<Medicamento> medicamentos = new ArrayList<Medicamento>();
     List<Pessoa> pessoas = new ArrayList<Pessoa>();

    

    public void cadastrarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        pessoa.setId(pessoas.size() + 1);
        pessoas.add(pessoa);
    }

    public boolean prescreverMedicamentoParaPessoa(Pessoa p, Medicamento m) {
		
        if (p != null && m != null) {
            return p.addMedicamento(m);
        }	
        return false;		
	}    

    public Pessoa findPessoaById(Integer id) {
        return pessoas.stream().filter(p -> id.equals(p.getId())).findAny().orElse(null);
    }
    
    public Medicamento findMedicamento(String nome) {
        return medicamentos.stream().filter(m -> m.getNome().equals(nome)).findFirst().orElse(null);
    }
       
    

    public List<String> listPessoasMedicamentos() {
        return pessoas.stream().map(p -> p.toString()).collect(Collectors.toList());
    }
    

    

}
