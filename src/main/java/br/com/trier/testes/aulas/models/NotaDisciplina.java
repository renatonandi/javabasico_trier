package br.com.trier.testes.aulas.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotaDisciplina {
	private Aluno aluno;
	private Disciplina disciplina;
	private List<Double> notas = new ArrayList<Double>();

}
