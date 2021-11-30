package br.com.home.java.desafios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("all")
public class ProgramaControleEstoque {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Produto> produtos = new ArrayList<Produto>();
        while (sc.hasNext()) {
            produtos.add(new Produto(sc.next(), sc.nextDouble()));
        }

        ControleEstoque controle = new ControleEstoque();

        for (Produto p: produtos) {
            Estoque inflacao = controle.inflacao();
            Estoque promocao = controle.promocao();
            System.out.println(controle.correcao(inflacao, p));
            System.out.println(controle.correcao(promocao, p));
        }
    }
}
