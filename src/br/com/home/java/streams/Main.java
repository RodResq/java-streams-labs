package br.com.home.java.streams;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        List<Empregado> empregados = new ArrayList<>();
        empregados.add(new Empregado(1L, "Joao", 2000, "Producao"));
        empregados.add(new Empregado(2L, "Maria", 3000, "RH"));
        empregados.add(new Empregado(3L, "Jose", 5000, "Controladoria"));
        empregados.add(new Empregado(4L, "Joao", 7000, "CTO"));
        System.out.println("** LISTA DE EMPREGADOS **");
        for (Empregado emp: empregados) {
            System.out.println(emp.getNome());
        }
        double salarioTotal = 0.0;
        for (Empregado emp: empregados) {
            salarioTotal = salarioTotal + emp.getSalario();
        }
        System.out.println("Salario total: R$ " + salarioTotal);
    }
}
