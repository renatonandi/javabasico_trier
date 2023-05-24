package br.com.trier.aula_3.timeFutebol;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Jogador {
    
    public void setNome(String nome) {
    	if (!nome.trim().isEmpty()) {
    		this.nome = nome;		
		}else {
			JOptionPane.showMessageDialog(null, "Não pode estar com o nome em branco");
		}
	}
	private String nome;
    private int numeroCamisa;
    private int golsMarcados;
    

}
