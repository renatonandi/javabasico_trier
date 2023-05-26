package br.com.trier.aula_3.livraria;

import javax.swing.JOptionPane;

import lombok.Getter;
@Getter
public enum GeneroEnum {
    
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private String descricao;
    
    GeneroEnum(String descricao) {
        this.descricao = descricao;
    }
    
    public static GeneroEnum selecionaSexo() {
    	GeneroEnum sexoSelecionado;
    	GeneroEnum[] sex = GeneroEnum.values();
        String[] sexStr = new String[sex.length];
        for (int i = 0; i < sex.length; i++) {
            sexStr[i] = sex[i].name();
        }
        String sexoStr = (String) JOptionPane.showInputDialog(null, "Selecione o gênero do autor",
                "Cadastro de Gênero", JOptionPane.PLAIN_MESSAGE, null, sexStr, sexStr[0]);

        sexoSelecionado = GeneroEnum.valueOf(sexoStr);
        return sexoSelecionado;          
    }
    
    @Override
    public String toString() {
        return descricao;
    }

}
