package br.com.home.java.dasafio_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class Programa {
    public static void main(String args[])
    {
        List<Animal> animais = new ArrayList<Animal>();
        Scanner sc = new Scanner(System.in);

        System.out.println("############# Iniciando o Programa ###################");

        int condicaoParada = 1;
        while(condicaoParada == 1){
            System.out.print("Digite o nome do Animal: ");
            String nome = sc.next();
            System.out.print("Digite a especie do Animal: ");
            String especie = sc.next();

            animais.add(new Animal(nome, especie));

            System.out.print("Desaja Prossegir ? 0 - Nao, 1 - Sim: ");
            condicaoParada = sc.nextInt();
        }
        System.out.println("saindo do Laco...");

        Stream<Animal> stream = animais.stream();

        filtro(stream).forEach(System.out::println);
    }

    private static List<String> filtro(Stream<Animal> streamAnimal) {
        return streamAnimal.filter(animal -> animal.getEspecie().contains("Gato"))
                .map(ani -> ani.getNome())
                .collect(Collectors.toList());

    }
}
