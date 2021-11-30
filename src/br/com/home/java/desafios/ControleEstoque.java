package br.com.home.java.desafios;

import br.com.home.java.streams.Empregado;

import java.util.function.Function;

@SuppressWarnings("all")
public class ControleEstoque {

    public Produto correcao(Estoque e, Produto p) {
        return e.operacao(p);
    }

    //Functions
    /**
    System.out.println("Execucao da Function: ");
    Function<Empregado, Double> function = emp -> emp.getSalario() * 10;
    Function<Empregado, String> functionStr = empregado -> empregado.getNome();
    double novoSalario = function.apply(new Empregado(1l, "EMpregado 1", 1, ""));
        System.out.println("Novo salario: " + novoSalario);
        System.out.println(functionStr.apply(new Empregado(11l, "Empregado 11", 2000, "Ti")));
     **/
    public Estoque inflacao() {
        return (p) -> {
            double preco = p.getPreco();
            preco += p.getPreco() * 0.1;

            p.setPreco(preco);
            return p;
        };
    }

    public Estoque promocao() {
        return (p) -> new Produto(p.getNome(), p.getPreco() - p.getPreco() * 0.23);
    }
}
