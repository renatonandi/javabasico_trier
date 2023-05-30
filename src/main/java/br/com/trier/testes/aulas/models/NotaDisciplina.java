package br.com.trier.testes.aulas.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NotaDisciplina {
	private Aluno aluno;
	private Disciplina disciplina;
	private List<Double> notas = new ArrayList<Double>();
	
	public double calculaMedia() {
	    return notas.stream().mapToDouble(n -> n).average().orElse(0.0);
	    
	}

}
