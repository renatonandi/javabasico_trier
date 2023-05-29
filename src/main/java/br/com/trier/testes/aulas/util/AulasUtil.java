package br.com.trier.testes.aulas.util;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.testes.aulas.models.Aluno;
import br.com.trier.testes.aulas.models.Disciplina;
import br.com.trier.testes.aulas.models.Professor;

public class AulasUtil {
    private List<Professor> professores = new ArrayList<Professor>();
    private List<Aluno> alunos = new ArrayList<Aluno>();
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public Aluno addAluno(Aluno a) {
        alunos.add(a);
        return a;
    }

    public Professor addProfessor(Professor p) {
        professores.add(p);
        return p;
    }

    public Disciplina addDisciplina(Disciplina d) {
        disciplinas.add(d);
        return d;
    }

    public Aluno findByName(String nome) {
        return alunos.stream().filter(a -> nome.equalsIgnoreCase(a.getNome())).findAny().orElse(null);
    }
    
    public Aluno updateAluno(String nome, Aluno a) {
        Aluno alu = findByName(nome);
        if (alu != null) {
            alunos.remove(alu);
            alunos.add(alu);
            return alu;
        }
        
        return null;
    }
    public void deleteAluno(String nome) {
        Aluno alu = findByName(nome);
        if (alu != null) {
            alunos.remove(alu);
        }
    }
    public List<Aluno> listAllAlunos(){
        return alunos;
    }

}
