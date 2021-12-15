package br.com.home.java.dasafio_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class Programa {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        int condicaoParada = 1;

        while (condicaoParada == 1) {
            System.out.print("Digite o nome da Pessoa: ");
            String nome = sc.next();
            System.out.print("Digite a idade da Pessoa: ");
            int idade = sc.nextInt();
            pessoas.add(new Pessoa(nome, idade));

            System.out.print("Deseja Continuar o Cadastro ? 1 - Sim, 0 - Nao : ");
            condicaoParada = sc.nextInt();

        }
        System.out.println(transformacao(pessoas.stream()));

    }

    private static String transformacao(Stream<Pessoa> stream) {
        return stream.map(p -> p.getNome()).reduce("", (p1, p2) -> p1 + " " + p2).trim();
    }
}
