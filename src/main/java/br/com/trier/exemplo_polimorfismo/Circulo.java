package br.com.trier.exemplo_polimorfismo;

import lombok.Getter;

@Getter
public class Circulo extends Forma {
    private int raio;

    public Circulo(int raio) {
        super("Circulo");
        this.raio = raio;
    }
    
    public double calculaArea() {
        return Math.PI * Math.pow(raio, 2);
        
    }

}
