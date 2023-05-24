package br.com.trier.aula_3.timeFutebol;

import java.util.List;

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
					jogadoresString.append("Nome: ").append(jogador.getNome().toUpperCase())
							.append(", Numero da camisa: ").append(jogador.getNumeroCamisa()).append(", Gos marcados: ")
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
		Jogador artilheiro = null;
		int maxGols = 0;

		for (Time time : times) {
			List<Jogador> jogadores = time.getJogadores();
			for (Jogador jogador : jogadores) {
				if (jogador.getGolsMarcados() > maxGols) {
					maxGols = jogador.getGolsMarcados();
					artilheiro = jogador;
				}
			}
		}
		if (artilheiro != null) {
			JOptionPane.showMessageDialog(null, "Artilhieiro do campeonato: " + artilheiro.getNome() + ", Com um total de " + artilheiro.getGolsMarcados() + " gols");
		}else {
			JOptionPane.showMessageDialog(null, "Não há jogadores cadastrados.");
		}

	}

	static void exibirTimeMaisGol(List<Time> times) {
		Time timeMaisGols = null;
		int maxGols = 0;

		for (Time time : times) {
			int totalGols = time.getTotalGolsMarcados();
			if (totalGols > maxGols) {
				maxGols = totalGols;
				timeMaisGols = time;
			}
		}

		if (timeMaisGols != null) {
			JOptionPane.showMessageDialog(null,
					"Time com mais gols: " + timeMaisGols + ", Com um total de " + maxGols + " gols");
		} else {
			JOptionPane.showMessageDialog(null, "Não há times cadastrados.");
		}
	}

}
