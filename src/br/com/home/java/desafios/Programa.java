package br.com.home.java.desafios;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class Programa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pessoa> pessoas = new LinkedList<Pessoa>();
        int contador = 0;
        while (contador < 5) {
            System.out.print("Informe o nome da pessoa: ");
            String nome = sc.next();
            System.out.print(String.format("Informe a idade de %s: ", nome));
            int idade = sc.nextInt();
            pessoas.add(new Pessoa(nome, idade));
            contador++;
        }
        /*
        for (Pessoa p: pessoas) {
            System.out.println(p.getNome() + " " + p.getIdade());
        }
        */
        /*
        for (Pessoa p: pessoas) {
            if (p.getIdade() > 18) {
                System.out.println(p.getNome());
            }
        }*/
        /*
        pessoas.stream().forEach(pessoa -> {
            if (pessoa.getIdade() > 18) {
                System.out.println(pessoa.getNome());
            }
        });*/
        /*
        System.out.println("*** MAIOR DE 18 ***");
        pessoas.stream().filter(pessoa -> pessoa.getIdade() > 18)
                .forEach(pessoa -> System.out.println(pessoa.getNome()));

         */
        OptionalInt maiorIdade = filtro(pessoas.stream());
        System.out.println(maiorIdade.getAsInt());

    }

    private static OptionalInt filtro(Stream<Pessoa> stream) {
        return  stream.mapToInt(pessoa -> pessoa.getIdade()).max();
    }
}
