package br.com.trier.aula_3.livraria;

import javax.swing.JOptionPane;

import lombok.Getter;
@Getter
public enum GeneroEnum {
    
    MASCULINO("Masculino"),
    FEMININO("Feminino");

   // private int num;
    private String descricao;
    
    GeneroEnum(String descricao) {
        this.descricao = descricao;
    }
    
//    public GeneroEnum selecionaSexo() {
//        String menu = "Gênero: \n";
//        for (GeneroEnum sexo : GeneroEnum.values()) {
//            menu += sexo.num + " - " + sexo.descricao + "\n";
//        }
//        
//        int sexoSelecionado = Integer.parseInt(JOptionPane.showInputDialog(menu));
//        return selecionaSexo();
//    }
    @Override
    public String toString() {
        return descricao;
    }

}
