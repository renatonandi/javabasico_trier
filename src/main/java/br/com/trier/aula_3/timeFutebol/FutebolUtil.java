package br.com.trier.aula_3.timeFutebol;

import java.lang.StackWalker.Option;
import java.security.KeyStore.Entry;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class FutebolUtil {
    static int exibirMenu() {
        String menu = "----- MENU -----\n" + "1 - Cadastrar time\n" + "2 - Listar jogadores de um time\n"
                + "3 - Verificar artilheiro do campeonato\n" + "4 - Verificar time com mais gols\n"
                + "5 - Encerrar o programa\n" + "Escolha uma opção";

        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }

    static void listarJogadoresTime(String nomeTime, List<Time> times) {
        boolean encontrou = false;

        for (Time time : times) {
            if (time.getNome().equalsIgnoreCase(nomeTime)) {

                encontrou = true;
                List<Jogador> jogadores = time.getJogadores();
                StringBuilder jogadoresString = new StringBuilder();
                jogadoresString.append("\nJogadores do time ").append(time.getNome().toUpperCase()).append("\n");

                for (Jogador jogador : jogadores) {
                    jogadoresString.append("Nome: ").append(jogador.getNome().toUpperCase()).append(", Numero da camisa: ")
                            .append(jogador.getNumeroCamisa()).append(", Gos marcados: ")
                            .append(jogador.getGolsMarcados()).append("\n");
                }
                JOptionPane.showMessageDialog(null, jogadoresString.toString());
                break;
            }
        }
        if (!encontrou) {
            JOptionPane.showMessageDialog(null, "Time não encontrado");
        }
    }
    
    static void exibirArtilheiroCampeonato(List<Time> times) {
        List<Jogador> todosJogadores = times.stream().flatMap(time -> time.getJogadores().stream()).collect(Collectors.toList());

        Optional<Jogador> artilheiro = todosJogadores.stream().max(Comparator.comparingInt(Jogador::getGolsMarcados));

        artilheiro.ifPresent(jogador ->
                JOptionPane.showMessageDialog(null, "Artilheiro do campeonato: " + jogador.getNome() +
                        " - Gols marcados: " + jogador.getGolsMarcados()));
        
    }
    static void exibirTimeMaisGol(List<Time> times) {
        Map<Time, Integer> golsPorTime = new HashMap<>();
        for (Time time : times) {
            golsPorTime.put(time, time.getTotalGolsMarcados());
        }
        Optional<Map.Entry<Time, Integer>> timeMaisGols = golsPorTime.entrySet().stream().max(Map.Entry.comparingByValue());
        
        timeMaisGols.ifPresent(entry -> JOptionPane.showMessageDialog(null, "Time com mais gols: " + entry.getKey().getNome() + " - Total de gols: " + entry.getValue()));
        
    }

}
