package br.com.trier.testes.aulas.models;

import br.com.trier.testes.aulas.Enuns.FormacaoEnum;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants.Exclude;

@Getter
@Setter
@RequiredArgsConstructor
public class Professor {
	@Exclude
	private int id;
    @NonNull
    private String nome;
    @NonNull
    private FormacaoEnum formacao;    
}
