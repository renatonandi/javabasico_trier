package br.com.trier.aula_3.livraria;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
@Getter
public class Livro {
    private String titulo;
    private Double preco;
    private List<Autor> autores = new ArrayList<Autor>();

    public void cadastraLivro(List<Autor> todosAutores) {
        int opcao = 0;
        boolean valido = false;
        

        while (!valido) {
            try {
                titulo = JOptionPane.showInputDialog("Digite o titulo do livro que deseja cadastrar").toLowerCase();
                if (titulo.trim().equals("")) {
                    throw new Exception("O titulo é obrigatório");
                }
                String precoDigitado = JOptionPane.showInputDialog("Digite o valor do livro");
                if (precoDigitado.trim().equals("")) {
                    throw new Exception("O preço é obrigatório");
                }
                preco = Double.parseDouble(precoDigitado);
                if (preco <= 0) {
                    throw new Exception("O valor precisa ser maior que 0");                  
                }
                
                do {
                    Autor autor = selecionaAutor(todosAutores);
                    if (autor == null) {
                        continue;
                    }
                    autores.add(autor);
                    opcao = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar outro autor \n(1 - SIM)\n(2 - NÃO)"));
                    
                } while (autores.size() < 4 && opcao == 1);
                
                      
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                continue;
                
            }
            valido = true;

        }

    }

    static Autor selecionaAutor(List<Autor> autores) {
        String nomeAutor = "";
        
        try {
            nomeAutor = JOptionPane.showInputDialog("Escolha um autor: \n" + LivrariaUtil.retornaString(autores));
            
            if (nomeAutor.trim().equals("")) {
                throw new Exception("Escolha um autor");                
            }
        } catch (Exception e) {
        }
        
        for (Autor autor : autores) {
            if (autor.getNome().equals(nomeAutor.toUpperCase())) {
                return autor;
            }
        }
        return null;
        
    }
    
    public boolean isAutorPresente(Autor autor) {
        for (Autor autorLivro : this.autores) {
            if (autor.getNome().equals(autorLivro.getNome())) {
                return true;
            }            
        }
        return false;
    }
    
    public boolean isNoPreco(double valorMin, double valorMax) {
        if (preco >= valorMin && preco <= valorMax) {
            return true;
        }        
        return false;
    }
    
    public boolean isCrianca() {
        for (Autor autor : autores) {
            if (autor.getIdade() <= 12) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isSexoSelecionado(GeneroEnum sexo) {
        for (Autor autor : autores) {
            if (autor.getSexo().equals(sexo)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        
        return "\nTitulo: " + titulo.toLowerCase() + " \nPreço: R$" + preco + "\nAutores:\n" + LivrariaUtil.retornaString(autores);
    }

}
