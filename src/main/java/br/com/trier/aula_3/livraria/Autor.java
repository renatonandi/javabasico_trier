package br.com.trier.aula_3.livraria;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import lombok.Getter;

@Getter
public class Autor {
    private String nome;
    private GeneroEnum sexo;
    private int idade;

    public void cadastraAutor() {
        boolean valido = false;

        while (!valido) {
            try {
                nome = JOptionPane.showInputDialog("Digite o nome e o sobrenome").toUpperCase();               
                if (validaNomeComposto(nome)) {
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

            GeneroEnum[] sex = GeneroEnum.values();
            String[] sexStr = new String[sex.length];
            for (int i = 0; i < sex.length; i++) {
                sexStr[i] = sex[i].name();
            }
            String sexoStr = (String) JOptionPane.showInputDialog(null, "Selecione o gênero do autor",
                    "Cadastro de Gênero", JOptionPane.PLAIN_MESSAGE, null, sexStr, sexStr[0]);

            sexo = GeneroEnum.valueOf(sexoStr);

            valido = true;
        }

    }
    public static boolean validaNomeComposto(String nome) {
        String padrao = "^[A-Za-z]+( [A-Za-z]+)?$";
        Pattern pattern = Pattern.compile(padrao);
        Matcher matcher = pattern.matcher(nome);
        return matcher.matches();
    }

    @Override
    public String toString() {
        return nome.trim() + ", Sexo: " + sexo + ", idade: " + idade + "\n";
    }

}
