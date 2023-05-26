package br.com.trier.aula_3.livraria;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class LivrariaUtil {

    static int exibirMenu() {
        String menu = "----- MENU -----\n" 
                    + "1 - Cadastrar Autores\n" 
                    + "2 - Cadastrar livros\n"
                    + "3 - Listar todos os livros cadastrados\n" 
                    + "4 - Pesquisar por autor\n"
                    + "5 - Pesquisar por faixa de valor\n" 
                    + "6 - Listar todos os livros cujo autores tenham crianças\n" 
                    + "7 - Listar todos os livros que foram escritos apenas por homens ou mulheres\n\n"
                    + "8 - SAIR\n" 
                    + "Escolha uma opção";

        return Integer.parseInt(JOptionPane.showInputDialog(menu));
    }
    
    static <V> String retornaString(List<V> Array) {
        String ret = "";
        for (V objeto : Array) {
            ret += objeto.toString();
        }        
        return ret;
    }
    
    static String getLivrosPorAutor(List<Autor> autores, List<Livro> livros) {
        List<Livro> autoresLivro = new ArrayList<Livro>();
        Autor autor = Livro.selecionaAutor(autores);
        for (Livro livro : livros) {
        	
            if (livro.isAutorPresente(autor)) {
                autoresLivro.add(livro);
            }
        }
        return retornaString(autoresLivro);
    }
    
    
    static String getLivrosPorPreco(List<Livro> livros) {
        List<Livro> livrosNoPreco = new ArrayList<Livro>();
        Double valorMin = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor minimo que deseja buscar"));
        Double valorMax = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor máximo que deseja buscar"));
               
        for (Livro livro : livros) {
         
            if (livro.isNoPreco(valorMin, valorMax)) {
            	livrosNoPreco.add(livro);
            }
        }
        
        return retornaString(livrosNoPreco);
    }
    static String getAutoresCriancas(List<Livro> livros) {
    	List<Livro> livrosComCrianca = new ArrayList<Livro>();
    	
    	for (Livro livro : livros) {
			if (livro.isCrianca()) {
				livrosComCrianca.add(livro);				
			}
		}
    	return LivrariaUtil.retornaString(livrosComCrianca);
    }
    static String getLivrosPorSexo(List<Livro> livros) {
    	List<Livro> livrosPorSexo = new ArrayList<Livro>();
    	GeneroEnum sexo = GeneroEnum.selecionaSexo();
    	for (Livro livro : livros) {
			if (livro.isSexoSelecionado(sexo)) {
				livrosPorSexo.add(livro);
			}
		}
    	return LivrariaUtil.retornaString(livrosPorSexo);
    }
    
}
