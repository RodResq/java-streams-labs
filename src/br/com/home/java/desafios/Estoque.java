package br.com.home.java.desafios;

@SuppressWarnings("all")
@FunctionalInterface
public interface Estoque {
    Produto operacao(Produto p);
}
