package br.com.trier.testes.aulas.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Disciplina {
    @NonNull
    private String nome;
    @NonNull
    private Integer cargaHoraria;
    @NonNull
    private Professor professor;

}