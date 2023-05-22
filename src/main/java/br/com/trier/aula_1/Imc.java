package br.com.trier.aula_1;

import javax.swing.JOptionPane;

public class Imc {
    public static void main(String[] args) {
        int quantidadePessoas = Integer
                .parseInt(JOptionPane.showInputDialog("Digite a quantidade de pessoas a ser feito o IMC"));

        for (int i = 0; i < quantidadePessoas; i++) {
            String nome = JOptionPane.showInputDialog("Digite o nome");
            Double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso em kg da pessoa"));
            Double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura em metros da pessoa"));
            Integer sexo = Integer
                    .parseInt(JOptionPane.showInputDialog("Digite 1 para Masculino \nDigite 2 para Feminino"));
            double imc = calculaImc(peso, altura);
            System.out.println("Nome: " + nome);
            System.out.printf("Seu IMC é %.2f: \n", imc );
            
           switch (sexo) {
        case 1:
            if (imc < 20.7) {
                System.out.println("Seu peso está abaixo do ideal");                
            }else if(imc >= 20.7 && imc <= 26.4) {
                System.out.println("Seu peso está ideal");
            }else if(imc >= 26.5 && imc <=27.8) {
                System.out.println("Seu peso está pouco acima do ideal");
            }else if(imc >= 27.9 && imc <=31.1) {
                System.out.println("Seu peso está acima do ideal");
            }else if(imc >= 31.2) {
                System.out.println("Seu peso está em grau de obesidade");
            }            
            break;
        case 2:
            if(imc < 19.1) {
                System.out.println("Seu peso está abaixo do ideal"); 
            }else if(imc >= 19.1 && imc <= 25.8) {
                System.out.println("Seu peso está ideal");
            }else if(imc >= 25.9 && imc <= 27.3) {
                System.out.println("Seu peso está pouco acima do ideal");
            }else if(imc >= 27.4 && imc <= 32.3) {
                System.out.println("Seu peso está acima do ideal");
            }else if(imc >= 32.4) {
                System.out.println("Seu peso está em grau de obesidade");
            }
            break;

        default:
            System.out.println("Valor para sexo incorreto");
            break;
        }

        }

    }

    public static Double calculaImc(Double peso, Double altura) {
        double imc = peso / (altura * altura);

        return imc;
    }

}
