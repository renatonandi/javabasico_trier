package br.com.trier.testes.medicamentos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UsoEnum {
	INJETAVEL(1, "Injetável"),
	TOPICO(2, "Tópico"),
	ORAL(3, "Oral"),
	SUPOSITORIO(4, "Supositório");
	
	private int id;
	private String descricao;
}
