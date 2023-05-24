package br.com.trier.aula_2.carros;

import javax.swing.JOptionPane;

public class Util {

	static int opcaoSelecionada() {
		String menu = "1 - Cadastrar novo carro\n" 
		            + "2 - Listar carros por período de fabricação\n"
		            + "3 - Listar carros por marca\n"     
		            + "4 - Listar carros por cor\n\n" 
		            + "5 - Sair";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
	public static void listarPorPeriodo() {
        boolean validador = false;
        int anoInicial = 0;
        int anoFinal = 0;
        while (!validador) {

            try {
                String dataInicioDigitada = JOptionPane.showInputDialog("Digite o ano inicial do carro");
                if (dataInicioDigitada.length() != 4) {
                    throw new Exception("Ano inválido, digite um ano no formato yyyy");
                }
                anoInicial = Integer.parseInt(dataInicioDigitada);

                String dataFinalDigitada = JOptionPane.showInputDialog("Digite o ano final do carro");
                if (dataFinalDigitada.length() != 4) {
                    throw new Exception("Ano inválido, digite um ano no formato yyyy");
                }
                anoFinal = Integer.parseInt(dataFinalDigitada);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                continue;
            }
            validador = true;

        }

        String retorno = "";
        int count = 0;
        for (Carro carro : PrincipalCarros.carros) {
            if (carro.ano >= anoInicial && carro.ano <= anoFinal) {
                retorno += "Marca: " + carro.marca + ", Ano: " + carro.ano + ", Cor: " + carro.cor.name() + "\n";
                count++;
            }
        }
        double percentual = (double) count / PrincipalCarros.carros.size() * 100;
        JOptionPane.showMessageDialog(null, "A porcentagem de carros nesse período é de: " + percentual + "%");
        JOptionPane.showMessageDialog(null, retorno);

    }
	
	public static void listarPorMarca() {
        String marca = JOptionPane.showInputDialog("Digite a marca do carro: ").toUpperCase();
        int count = 0;

        String retorno = "";
        for (Carro carro : PrincipalCarros.carros) {
            if (carro.marca.equals(marca)) {
                retorno += "Marca: " + carro.marca + ", Ano: " + carro.ano + ", Cor: " + carro.cor.name() + "\n";
                count++;
            }
        }
        double percentual = (double) count / PrincipalCarros.carros.size() * 100;
        JOptionPane.showMessageDialog(null, "Percentual de carros da marca " + marca + " foi de " + percentual);
        JOptionPane.showMessageDialog(null, retorno);
    }
	
	public static void listarPorCor() {
        Cores[] cores = Cores.values();
        String[] coresStr = new String[cores.length];
        for (int i = 0; i < cores.length; i++) {
            coresStr[i] = cores[i].name();
        }

        String corStr = (String) JOptionPane.showInputDialog(null, "Selecione a cor: ", "Listagem por Cor ",
                JOptionPane.PLAIN_MESSAGE, null, coresStr, coresStr[0]);

        Cores cor = Cores.valueOf(corStr);
        int count = 0;
        String retorno = "";
        for (Carro carro : PrincipalCarros.carros) {
            if (carro.cor == cor) {
                count++;
                retorno += "Marca: " + carro.marca + ", Ano: " + carro.ano + ", Cor: " + carro.cor.name() + "\n";
            }

        }
        double percentual = (double) count / PrincipalCarros.carros.size() * 100;
        JOptionPane.showMessageDialog(null, "Percentual de carros da cor " + cor + " foi de " + percentual);
        JOptionPane.showMessageDialog(null, retorno);

    }
	

}
