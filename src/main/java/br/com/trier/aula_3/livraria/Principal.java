package br.com.trier.aula_3.livraria;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_3.timeFutebol.FutebolUtil;
import br.com.trier.aula_3.timeFutebol.Time;

public class Principal {
    public static void main(String[] args) {

        List<Autor> autores = new ArrayList<Autor>();
        List<Livro> livros = new ArrayList<Livro>();

        int opcao = 0;

        while (opcao != 8) {

            try {
                int opcaoDigitada = LivrariaUtil.exibirMenu();
                if (opcao > 8 && opcao <= 0) {
                    throw new Exception();
                }
                opcao = opcaoDigitada;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, tente novamente.");
                continue;
            }

            switch (opcao) {
            case 1:
                Autor autor = new Autor();
                autor.cadastraAutor();
                autores.add(autor);
                break;
            case 2:
                Livro livro = new Livro();
                livro.cadastraLivro(autores);
                livros.add(livro);
                
                break;
            case 3:
                JOptionPane.showMessageDialog(null, LivrariaUtil.retornaString(livros));
                break;
            case 4:
                JOptionPane.showMessageDialog(null, LivrariaUtil.getLivrosPorAutor(autores, livros));
                break;
            case 5:
                JOptionPane.showMessageDialog(null, LivrariaUtil.getLivrosPorPreco(livros));
                break;
            case 6:
                JOptionPane.showMessageDialog(null, LivrariaUtil.getAutoresCriancas(livros));
                break;
            case 7:
            	JOptionPane.showMessageDialog(null, LivrariaUtil.getLivrosPorSexo(livros));
            	break;
            case 8:
                JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                return;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, tente novamente.");
            }
        }

    }
}
