package br.com.trier.aula_2.carros;

import java.util.ArrayList;
import java.util.List;

public class PrincipalCarros {
    public static List<Carro> carros = new ArrayList<Carro>();
    
    public static void main(String[] args) {
        int opcao = 0;
        
        
        do {
            opcao = Util.opcaoSelecionada();
            
            if(opcao == 1) {
                Carro c = new Carro();
                c.cadastrar();
                carros.add(c);
            }else if(opcao == 2) {              
               Carro.listarPorPeriodo();
            }else if(opcao == 3) {
            	Carro.listarPorMarca();
            }else if(opcao == 4) {
            	Carro.listarPorCor();
            }
            
        } while (opcao != 5);
    }

}
