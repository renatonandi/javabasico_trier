package br.com.trier.testes.aulas.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Aluno {
	private int id;
	@NonNull
    private String nome;
	@NonNull
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	@NonNull
    private List<Double> notas = new ArrayList<Double>();
    
    public void matricular(Disciplina disciplina) {
        disciplinas.add(disciplina);
        notas.add(0.0);
        notas.add(0.0);
        notas.add(0.0);
    }
    
    public void adicionarNota(Disciplina disciplina, double nota1, double nota2, double nota3) {
        int aux = disciplinas.indexOf(disciplina);
        if (aux != -1) {
        	notas.set(aux * 3, nota1);
            notas.set(aux * 3 + 1, nota2);
            notas.set(aux * 3 + 2, nota3);
        }
    }
    
    public double obterMedia(Disciplina disciplina) {
        int aux = disciplinas.indexOf(disciplina);
        if (aux != -1) {
        	double nota1 = notas.get(aux * 3);
            double nota2 = notas.get(aux * 3 + 1);
            double nota3 = notas.get(aux * 3 + 2);
            return (nota1 + nota2 + nota3) / 3;
        }
        
        return 0.0;
    }

}
