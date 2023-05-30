package br.com.trier.testes.aulas.util;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.testes.aulas.Enuns.FormacaoEnum;
import br.com.trier.testes.aulas.models.Aluno;
import br.com.trier.testes.aulas.models.Disciplina;
import br.com.trier.testes.aulas.models.NotaDisciplina;
import br.com.trier.testes.aulas.models.Professor;

public class AulasUtil {
	private List<Professor> professores = new ArrayList<Professor>();
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public Aluno addAluno(Aluno a) {
		a.setId(alunos.size() + 1);
		alunos.add(a);
		return a;
	}

	public Professor addProfessor(Professor p) {
		p.setId(professores.size() + 1);
		professores.add(p);
		return p;
	} 

	public Disciplina addDisciplina(Disciplina d) {
		disciplinas.add(d);
		return d;
	}

	public Aluno findAlunoById(final Integer id) {
		return alunos.stream().filter(a -> id.equals(a.getId())).findAny().orElse(null);
	}

	public Professor findProfessorById(final Integer id) {
		return professores.stream().filter(p -> id.equals(p.getId())).findAny().orElse(null);
	}		
	
	public List<Disciplina> disciplinasPosGraduacao(final FormacaoEnum formacao){		
		return disciplinas.stream().filter(d -> d.getProfessor().getFormacao().equals(FormacaoEnum.POS_GRADUACAO)).toList();
		
	}
	public Aluno getNotasDisciplinas(final Integer id){
	    return alunos.stream().filter(a -> a.getNotaDisciplinas().contains(a.getId())).findAny().orElse(null);
	}

	public void clearData() {
		professores.clear();
		alunos.clear();
		disciplinas.clear();
	}

}
