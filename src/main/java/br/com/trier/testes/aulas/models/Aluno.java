package br.com.trier.testes.aulas.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private List<NotaDisciplina> notaDisciplinas = new ArrayList<NotaDisciplina>();
	
    
    public void addNotaDisciplina(Disciplina disciplina, List<Double> notas) {
        notaDisciplinas.add(new NotaDisciplina(this, disciplina, notas));
       
    }
    
    public List<Double> notasAlunosDisciplina(Disciplina disciplina) {
        NotaDisciplina nd = notaDisciplinas.stream().filter(n -> n.getDisciplina().equals(disciplina)).findAny().orElse(null);
        
        if (nd != null) {
            return nd.getNotas();
        }
        return null;
      
    }
    
    public String obterMedia() {
        String media = notaDisciplinas.stream().map(nd -> nd.getDisciplina().getNome() + " - " + nd.calculaMedia()).collect(Collectors.joining("\n"));
        return media;
    }

}
