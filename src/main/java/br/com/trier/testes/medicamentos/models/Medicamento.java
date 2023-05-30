package br.com.trier.testes.medicamentos.models;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.testes.medicamentos.enums.UsoEnum;
import lombok.Getter;

@Getter
public class Medicamento {

	private String nome;
	private UsoEnum uso;
	private List<String> alergias = new ArrayList<String>();
	private List<String> indicacoes = new ArrayList<String>();
	
	
	public Medicamento(String nome, UsoEnum uso, List<String> alergias, List<String> indicacoes) {
		this.nome = nome;
		this.uso = uso;
		this.alergias = alergias;
		this.indicacoes = indicacoes;
	}
	
	@Override
	public String toString() {
		return "Medicamento: " + nome + ", Tipo de Uso: " + uso.getDescricao();
	}
	
}
