package br.com.trier.testes.aulas.models;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Disciplina {
	private int id;
    @NonNull
    private String nome;
    @NonNull
    private Integer cargaHoraria;
    @NonNull
    private Professor professor;

}