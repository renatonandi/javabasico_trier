package br.com.trier.aula_2.carros;

import javax.swing.JOptionPane;

public class Carro {

    String marca;
    int ano;
    Cores cor;

    public void cadastrar() {
        boolean validadorMarca = false;
        while (!validadorMarca) {
            try {
                String marcaDigitada = JOptionPane.showInputDialog("Digite a marca do carro").toUpperCase();
                if (marcaDigitada.trim().isEmpty()) {
                    throw new Exception("A marca do carro deve ser preenchida ");
                }
                marca = marcaDigitada;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                continue;
            }
            validadorMarca = true;
        }

        ano = 0;
        boolean validador = false;
        while (!validador) {
            try {
                String dataDigitada = JOptionPane.showInputDialog("Digite o ano do carro");
                if (dataDigitada.length() != 4) {
                    throw new Exception("Ano inválido, digite um ano no formato yyyy");
                }
                ano = Integer.parseInt(dataDigitada);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                continue;
            }
            validador = true;
        }

        Cores[] cores = Cores.values();
        String[] coresStr = new String[cores.length];
        for (int i = 0; i < cores.length; i++) {
            coresStr[i] = cores[i].name();
        }
        String corStr = (String) JOptionPane.showInputDialog(null, "Selecione a cor do carro", "Cadastro de carro",
                JOptionPane.PLAIN_MESSAGE, null, coresStr, coresStr[0]);
        cor = Cores.valueOf(corStr);
    }

}
