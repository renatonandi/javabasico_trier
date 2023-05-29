package br.com.trier.testes.aulas.models;

import br.com.trier.testes.aulas.Enuns.FormacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Professor {
    @NonNull
    private String nome;
    @NonNull
    private FormacaoEnum formacao;    
}
