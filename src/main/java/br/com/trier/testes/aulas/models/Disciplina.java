package br.com.trier.testes.aulas.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Disciplina {
    private String nome;
    private Integer cargaHoraria;
    private Professor professor;
    
    

}