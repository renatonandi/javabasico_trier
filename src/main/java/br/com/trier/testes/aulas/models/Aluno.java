package br.com.trier.testes.aulas.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Aluno {
    private String nome;
    private List<Disciplina> disciplinas;
    private List<Double> notas;
    
    public void matricular(Disciplina disciplina) {
        disciplinas.add(disciplina);
        notas.add(0.0);
    }
    
    public void adicionarNota(Disciplina disciplina, double nota) {
        int aux = disciplinas.indexOf(disciplina);
        if (aux != -1) {
            notas.set(aux, nota);
        }
    }
    
    public double obterMedia(Disciplina disciplina) {
        int aux = disciplinas.indexOf(disciplina);
        if (aux != -1) {
            double nota1 = notas.get(aux);
            double nota2 = notas.get(aux);
            double nota3 = notas.get(aux);
            return (nota1 + nota2 + nota3) / 3;
        }
        
        return 0.0;
    }

}
