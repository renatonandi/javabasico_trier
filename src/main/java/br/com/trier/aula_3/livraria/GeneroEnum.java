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

        return sexoSelecionado = GeneroEnum.valueOf(sexoStr);          
    }
    public static GeneroEnum selecionaSexoInvertido() {
        GeneroEnum sexoSelecionadoInvertido = null;
        GeneroEnum[] sex = GeneroEnum.values();
        String[] sexStr = new String[sex.length];
        for (int i = 0; i < sex.length; i++) {
            sexStr[i] = sex[i].name();
        }
        
        
        String sexoStr = (String) JOptionPane.showInputDialog(null, "Selecione o gênero do autor",
                "Cadastro de Gênero", JOptionPane.PLAIN_MESSAGE, null, sexStr, sexStr[0]);
        
        sexoSelecionadoInvertido = GeneroEnum.valueOf(sexoStr);
        
        if (sexoSelecionadoInvertido == GeneroEnum.MASCULINO) {
            sexoSelecionadoInvertido = GeneroEnum.FEMININO;
        }else if (sexoSelecionadoInvertido == GeneroEnum.FEMININO) {
            sexoSelecionadoInvertido = GeneroEnum.MASCULINO;
        }
        
        return sexoSelecionadoInvertido;       
    }
    
    @Override
    public String toString() {
        return descricao;
    }

}
