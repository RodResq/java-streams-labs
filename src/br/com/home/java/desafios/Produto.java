package br.com.home.java.desafios;

@SuppressWarnings("all")
public class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public String toString() {
        return String.format("%s - R$ %5.2f", nome, preco);
    }
}
