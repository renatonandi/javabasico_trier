package br.com.trier.aula_3.livraria;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Autor {
    private String nome;
    private GeneroEnum sexo;
    private int idade;

    public void cadastraAutor() {
        boolean valido = false;

        while (!valido) {
            try {
                nome = JOptionPane.showInputDialog("Digite o nome e o sobrenome").trim().toUpperCase();               
                if (nome.isEmpty() || !validaNomeComposto(nome)) {
                    throw new Exception("O nome deve conter nome e sobrenome");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                continue;
            }
            try {
                String idadeDigitada = JOptionPane.showInputDialog("Digite a idade do autor");
                if (idadeDigitada.isEmpty() || idadeDigitada.equals("0")) {
                    throw new Exception("A idade é obrigatória e precisa ser maior que 0");
                }
                idade = Integer.parseInt(idadeDigitada);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                continue;
            }
            
            sexo = GeneroEnum.selecionaSexo();

            valido = true;
        }

    }
    public static boolean validaNomeComposto(String nome) {
        String padrao = "^[A-Za-z]+ [A-Za-z]+$";
        Pattern pattern = Pattern.compile(padrao);
        Matcher matcher = pattern.matcher(nome);
        return matcher.matches();
    }

    @Override
    public String toString() {
        return nome + ", Sexo: " + sexo + ", Idade: " + idade + "\n";
    }

}
