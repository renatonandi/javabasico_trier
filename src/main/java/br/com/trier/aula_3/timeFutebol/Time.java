package br.com.trier.aula_3.timeFutebol;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Time {
    private String nome;
    private List<Jogador> jogadores;

    public Time(String nome) {
        this.nome = nome;
        this.jogadores = new ArrayList<>();
    }

    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public int getTotalGolsMarcados() {
    	
    	int totalGols = 0;
    	for (Jogador jogador : jogadores) {
			totalGols += jogador.getGolsMarcados();
		}
        return totalGols;
    }
    
    public Jogador getArtilheiro() {
    	Jogador artilhieiro = null;
    	int maxGols = 0;
    	
    	for (Jogador jogador : jogadores) {
			if(jogador.getGolsMarcados() > maxGols)
				maxGols = jogador.getGolsMarcados();
				artilhieiro = jogador;
		}
    	
    	return artilhieiro;
    }
    
    
    static void cadastrarTime(List<Time> times) {
        String nomeTime = JOptionPane.showInputDialog(null, "Digite o nome do time:");
        if (nomeTime == null) {
            return;
        }
        Time time = new Time(nomeTime);
        int opcao = 0;
        
        
        do {
            
            String nomeJogador = JOptionPane.showInputDialog(null, "Digite o nome do jogador:");
            if (nomeJogador == null) {
                
            }
            String numeroCamisaStr = JOptionPane.showInputDialog(null, "Digite o número da camisa:");
            if (numeroCamisaStr == null) {
                
            }
            int numeroCamisa;
            try {
                numeroCamisa = Integer.parseInt(numeroCamisaStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Número de camisa inválido. Tente novamente.");
                continue;
            }
            String golsMarcadosStr = JOptionPane.showInputDialog(null, "Digite a quantidade de gols marcados:");
            if (golsMarcadosStr == null) {
                break;
            }
            int golsMarcados;
            try {
                golsMarcados = Integer.parseInt(golsMarcadosStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantidade de gols inválida. Tente novamente.");
                continue;
            }
            
            Jogador jogador = new Jogador();
            jogador.setNome(nomeJogador);
            jogador.setNumeroCamisa(numeroCamisa);
            jogador.setGolsMarcados(golsMarcados);
            
            time.adicionarJogador(jogador);
            
            opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro jogador?", "Confirmação", JOptionPane.YES_NO_OPTION);
            
        } while (opcao == JOptionPane.YES_OPTION);        

        times.add(time);
        JOptionPane.showMessageDialog(null, "Time cadastrado com sucesso!");
    }
}

