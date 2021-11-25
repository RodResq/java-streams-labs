package br.com.home.java.streams;

import br.com.home.java.desafios.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        List<Empregado> empregados = new ArrayList<>();
        empregados.add(new Empregado(1L, "Joao", 2000, "Producao"));
        empregados.add(new Empregado(2L, "Maria", 3000, "RH"));
        empregados.add(new Empregado(3L, "Jose", 5000, "Controladoria"));
        empregados.add(new Empregado(4L, "Antonio", 7000, "CTO"));
        System.out.println("** LISTA DE EMPREGADOS **");
        /*for (Empregado emp: empregados) {
            System.out.println(emp.getNome());
        }*/
        empregados.stream().forEach(emp -> {
            System.out.println(emp.getNome());
        });
        /*
        double salarioTotal = 0.0;
        for (Empregado emp: empregados) {
            salarioTotal = salarioTotal + emp.getSalario();
        }*/
        double salarioTotal = empregados.stream().mapToDouble(emp -> emp.getSalario()).sum();
        System.out.println("Salario total: R$ " + salarioTotal);

//        Mensageiro mensageiro = new MensageiroConsole();
//        mensageiro.emitirMessagem("TreinaWeb");

        /*
        Mensageiro mensageiro = new Mensageiro() {
            @Override
            public void emitirMessagem(String mensagem) {
                System.out.println("Mensagem do Objeto Anonimo: " + mensagem);
            }
        };
        mensageiro.emitirMessagem("Treina Web");
         */
        //criacao methodo ondFly
        Mensageiro mensageiro = (mensagem) -> System.out.println("Mensagem da expressao Lambda: " + mensagem);
        mensageiro.emitirMessagem("TReina WEb");

        //Consumer
        //Entra um paramentro e nao retorna nda
        System.out.println("*** Execucao do Consumer ***");
        Consumer<Empregado> consumer = (emp) -> {
            System.out.println(emp.getNome() + ", R$ " + emp.getSalario());
        };
        consumer.accept(new Empregado(10l, "Empregado 10", 1000, "Educacao"));

        //Functions
        System.out.println("Execucao da Function: ");
        Function<Empregado, Double> function = emp -> emp.getSalario() * 10;
        Function<Empregado, String> functionStr = empregado -> empregado.getNome();
        double novoSalario = function.apply(new Empregado(1l, "EMpregado 1", 1, ""));
        System.out.println("Novo salario: " + novoSalario);
        System.out.println(functionStr.apply(new Empregado(11l, "Empregado 11", 2000, "Ti")));

    }
}
