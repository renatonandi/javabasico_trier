package br.com.trier.aula_2.imc;

import javax.swing.JOptionPane;

public class Pessoa {
    private String nome;
    private char sexo;
    private Double peso;
    private Double altura;
    
    
    public Pessoa(String nome, char sexo, Double altura, Double peso) {
        this.nome = nome;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }
    
    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public Double getAltura() {
        return altura;
    }

    public Double getPeso() {
        return peso;
    }
    public void cadastrar() {
        nome = JOptionPane.showInputDialog("Nome");
        sexo = JOptionPane.showInputDialog("Sexo (M/F)").toUpperCase().charAt(0);
        peso = Double.parseDouble(JOptionPane.showInputDialog("Peso (Kg)"));
        altura = Double.parseDouble(JOptionPane.showInputDialog("Altura (Metros)"));
    }
    
    
    public Double calculaImc() {
        double imc;
        if(sexo == 'M') {
            imc = peso / (altura * altura);
        }else {
            imc = 0.9 * peso / (altura * altura);
        }        
        return imc;
    }
    
    public String avaliaImc() {
        double imc = calculaImc();
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else {
            return "Obesidade";
        }
    }
    

}
