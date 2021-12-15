package br.com.home.java.dasafio_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class mainProduto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<Produto>();


        int saida = 1;
        while (saida == 1) {
            System.out.print("Entre com o nome do produto: ");
            String nome = sc.next();
            System.out.print("Entre com o valor do Produto: ");
            double valor = sc.nextDouble();
            System.out.print("Entre com a quantidade: ");
            int quantidade = sc.nextInt();

            produtos.add(new Produto(nome, valor, quantidade));
            System.out.print("cadastart outro produto ? 0 - Nao , 1 - Sim: ");
            saida = sc.nextInt();
        }
        System.out.println("");
        System.out.println("saiu do loop");
        List<Produto> filtro = filtro(produtos.stream());
    }

    private static List<Produto> filtro(Stream<Produto> streamProdutos) {
        List<Produto> produtosSemEstoque = streamProdutos.filter(prod -> prod.getQuantidade() == 0).collect(Collectors.toList());
        return produtosSemEstoque;
    }
}
