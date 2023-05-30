package br.com.trier.testes.medicamentos.models;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.testes.medicamentos.enums.UsoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class Medicamento {
    @NonNull
	private String nome;
    @NonNull
    private UsoEnum uso;
	@NonNull
    private List<String> alergias = new ArrayList<String>();
	@NonNull
	private List<String> indicacoes = new ArrayList<String>();
	
	
	

	public boolean isIndicado(String sintoma) {
        return indicacoes.contains(sintoma);
    }	
	
	public boolean isContraIndicado(List<String> condicaoSaude) {
        return alergias.stream().anyMatch(condicaoSaude :: contains);
    }
	
	
	
}
