package br.com.trier.testes.medicamentos.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {
	private int id;
	private String nome;
	private String sintoma;
	private List<String> alergias;
	private List<Medicamento> medicamentosPrescritos;
	
	
	public Pessoa(String nome, String sintoma, List<String> alergias) {
		this.nome = nome;
		this.sintoma = sintoma;
		this.alergias = alergias;
		this.medicamentosPrescritos = new ArrayList<>();
	}
	
	public boolean addMedicamento(Medicamento m) {
        if(m.isIndicado(sintoma) && !m.isContraIndicado(alergias)) {
            medicamentosPrescritos.add(m);
            return true;
        }
        return false;
    }
	
	@Override
	public String toString() {
		return "Pessoa: " + nome + ", Sintoma: " + sintoma + ", " + medicamentosPrescritos.toString();
	}
	
	

}
