package br.com.trier.aula_2.carros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class Carro {

    String marca;
    int ano;
    Cores cor;

    public void cadastrar() {
        marca = JOptionPane.showInputDialog("Digite a marca do carro".toUpperCase());
        ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do carro"));
        Cores[] cores = Cores.values();
        String[] coresStr = new String[cores.length];
        for (int i = 0; i < cores.length; i++) {
            coresStr[i] = cores[i].name();
        }

        String corStr = (String) JOptionPane.showInputDialog(null, "Selecione a cor do carro", "Cadastro de carro",
                JOptionPane.PLAIN_MESSAGE, null, coresStr, coresStr[0]);

        cor = Cores.valueOf(corStr);
        
    }

    public static void listarPorPeriodo() {
        int anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano inicial do carro"));
        int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano final do carro"));        
        

        List<Carro> carrosPeriodo = new ArrayList<Carro>();
        for (Carro carro : PrincipalCarros.carros) {
            if (carro.ano >= anoInicial && carro.ano <= anoFinal) {
                carrosPeriodo.add(carro);
            }
        }

        double percentual = (double) carrosPeriodo.size() / PrincipalCarros.carros.size() * 100;
        JOptionPane.showMessageDialog(null, "A porcentagem de carros nesse período é de: " + percentual);

        StringBuilder listaCarros = new StringBuilder();
        for (Carro carro : carrosPeriodo) {
            listaCarros.append("Marca: ").append(carro.marca).append(", Ano: ").append(carro.ano).append(", Cor: ")
                    .append(carro.cor.name()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaCarros.toString());
    }
    public static void listarPorMarca() {
        String marca = JOptionPane.showInputDialog("Digite a marca do carro: ".toUpperCase());
        int count = 0;
        
        StringBuilder listaMarcas = new StringBuilder();
        
        for(Carro carro : PrincipalCarros.carros) {
            if(carro.marca.equals(marca)) {
                count++;
                listaMarcas.append("Ano: ").append(carro.ano).append(", Cor: ").append(carro.cor.name()).append("\n");
            }
        }
        double percentual = (double) count / PrincipalCarros.carros.size() * 100;
        JOptionPane.showMessageDialog(null, "Percentual de carros da marca " + marca + " foi de " + percentual);
        JOptionPane.showMessageDialog(null, listaMarcas.toString());
        
    }

}
