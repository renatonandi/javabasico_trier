package br.com.trier.testes.aulas.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.trier.testes.aulas.Enuns.FormacaoEnum;
import br.com.trier.testes.aulas.models.Aluno;
import br.com.trier.testes.aulas.models.Disciplina;
import br.com.trier.testes.aulas.models.Professor;
import br.com.trier.testes.aulas.util.AulasUtil;

public class AulasUtilTest {
	
	private AulasUtil au = new AulasUtil();
	
	
	@BeforeEach
	void init() {
		
		au.clearData();
		
		Aluno a1 = new Aluno("Aluno 1");
		Aluno a2 = new Aluno("Aluno 2");
		Aluno a3 = new Aluno("Aluno 3");
		Aluno a4 = new Aluno("Aluno 4");
		au.addAluno(a1);
		au.addAluno(a2);
		au.addAluno(a3);
		au.addAluno(a4);
		
		Professor p1 = new Professor("Professor 1", FormacaoEnum.ESPECIALIZACAO);
		Professor p2 = new Professor("Professor 2", FormacaoEnum.GRADUACAO);
		Professor p3 = new Professor("Professor 3", FormacaoEnum.POS_GRADUACAO);
		Professor p4 = new Professor("Professor 4", FormacaoEnum.ESPECIALIZACAO);
		au.addProfessor(p1);
		au.addProfessor(p2);
		au.addProfessor(p3);
		au.addProfessor(p4);
		
		
		Disciplina d1 = new Disciplina("Matematica", 20, p1);
		Disciplina d2 = new Disciplina("Portugues", 20, p2);
		Disciplina d3 = new Disciplina("História", 20, p3);
		Disciplina d4 = new Disciplina("Ed Fisica", 20, p4);
		au.addDisciplina(d1);
		au.addDisciplina(d2);
		au.addDisciplina(d3);
		au.addDisciplina(d4);	
		
		a1.matricular(d1);
		a2.matricular(d2);
		a3.matricular(d3);
		a4.matricular(d1);
		
		a1.adicionarNota(d1, 8.0, 7.0, 6.0);
		a2.adicionarNota(d2, 9.0, 8.0, 7.5);
		a3.adicionarNota(d3, 8.0, 7.0, 8.0);
		a4.adicionarNota(d4, 3.0, 5.0, 8.0);
		
		
	}
	

	@Test
	void addAlunoTest() {
		Aluno aluno = au.addAluno(new Aluno("Renato"));
		assertEquals(aluno, au.findAlunoById(5));		
	}
	
	@Test
	void addProfessorTest() {
		Professor pr = au.addProfessor(new Professor("Matheus", FormacaoEnum.POS_GRADUACAO));
		assertEquals(pr, au.findProfessorById(5));
	}
	
	@Test
	void addDisciplinaTest() {
		Disciplina dp = au.addDisciplina(new Disciplina("Geografia", 30, new Professor("Ricardo", FormacaoEnum.ESPECIALIZACAO)));
		assertEquals(dp, au.findDisciplinaById(5));
	}
	
	@Test
	void listDisciplinasAlunoTest() {		
		List<Disciplina> disciplinasAluno1 = au.listDiscAluno(1);
		assertEquals(1, disciplinasAluno1.size());
	}
	
	@Test
	void listDisciplinasPosGrad() {
		List<Disciplina> disciplinasPos = au.disciplinasPosGraduacao(FormacaoEnum.POS_GRADUACAO);
		assertEquals(1, disciplinasPos.size());
	}
	
	

}
