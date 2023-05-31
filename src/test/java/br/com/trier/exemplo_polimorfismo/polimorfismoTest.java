package br.com.trier.exemplo_polimorfismo;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class polimorfismoTest {
    private List<Forma> lista = new ArrayList<Forma>();

    @BeforeEach
    void test() {
        lista.add(new Circulo(3));
        lista.add(new Cone());
        lista.add(new Quadrado());
        lista.add(new Triangulo());
       
    }

    
    @Test
    @DisplayName("Teste desenhar circulo")
    public void dsenharCirculoTest() {
        String c = lista.get(0).desenhar();
        assertEquals("Desenhando um Circulo", c);
    }
    
    @Test
    @DisplayName("Teste área círculo")
    public void areaCirculoTest() {
        Circulo c = (Circulo) lista.get(0);
        double area = c.calculaArea();
        DecimalFormat df = new DecimalFormat("##.00");
        assertEquals("28,27", df.format(area));
    }
    
    @Test
    @DisplayName("Teste desenhar quadrado")
    public void desenharQuadradoTest() {
        String q = lista.get(2).desenhar();
        assertEquals("Desenhando um Quadrado com 4 lados", q);
    }
    @Test
    @DisplayName("Teste desenhar triângulo")
    public void desenharTrianguloTest() {
        String t = lista.get(3).desenhar();
        assertEquals("Desenhando um Triângulo com 3 lados", t);
    }
}
