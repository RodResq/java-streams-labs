package br.com.home.java.streams;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Empregado> empregados = new ArrayList<>();
        empregados.add(new Empregado(1L, "Joao", 100, "Producao"));
        empregados.add(new Empregado(2L, "Maria", 3000, "RH"));
        empregados.add(new Empregado(3L, "Jose", 5000, "Controladoria"));
        empregados.add(new Empregado(4L, "Joao", 7000, "CTO"));
        System.out.println("** LISTA DE EMPREGADOS **");
        for (Empregado emp: empregados) {
            System.out.println(emp.getNome());
        }
    }
}
