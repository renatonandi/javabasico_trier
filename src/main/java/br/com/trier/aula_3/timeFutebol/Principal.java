package br.com.trier.aula_3.timeFutebol;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) throws Exception {
        List<Time> times = new ArrayList<Time>();

        int opcao = 0;

        while (opcao != 5) {

            try {
                int opcaoDigitada = FutebolUtil.exibirMenu();
                if (opcao > 5 && opcao <= 0) {
                    throw new Exception();
                }
                opcao = opcaoDigitada;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, tente novamente.");
                continue;
            }

            switch (opcao) {
            case 1:
                Time.cadastrarTime(times);
                break;
        case 2:
            String nomeTime = JOptionPane.showInputDialog(null, "Digite o nome do time:");
            FutebolUtil.listarJogadoresTime(nomeTime, times);
            break;
        case 3:
            FutebolUtil.exibirArtilheiroCampeonato(times);
            break;
        case 4:
            FutebolUtil.exibirTimeMaisGol(times);
            break;
        case 5:
            JOptionPane.showMessageDialog(null, "Encerrando o programa...");
            return;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, tente novamente.");
            }
        }
    }

}
