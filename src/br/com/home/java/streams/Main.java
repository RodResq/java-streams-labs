package br.com.home.java.streams;

import br.com.home.java.desafios.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

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

        /* Implementacao anonima
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
//        System.out.println("*** Execucao do Consumer ***");
//        Consumer<Empregado> consumer = (emp) -> {
//            System.out.println(emp.getNome() + ", R$ " + emp.getSalario());
//        };
//        consumer.accept(new Empregado(10l, "Empregado 10", 1000, "Educacao"));

        System.out.println("########### Executando O Consumer ##############");
//        Entre um parametro e nao retorna nada (void)
        Consumer<Empregado> consumer = (emp) -> {
            System.out.println(String.format("Empregado: %s, recebe: R$ %.2f", emp.getNome(), emp.getSalario()));
        };

        consumer.accept(new Empregado(100l, "Teste", 1000, "TI"));


        //Functions
        System.out.println("Execucao da Function: ");
        Function<Empregado, Double> function = emp -> emp.getSalario() * 10;
        Function<Empregado, String> functionStr = empregado -> empregado.getNome();
        double novoSalario = function.apply(new Empregado(1l, "EMpregado 1", 1, ""));
        System.out.println("Novo salario: " + novoSalario);
        System.out.println(functionStr.apply(new Empregado(11l, "Empregado 11", 2000, "Ti")));

        //BinaryOperator
        System.out.println("Execucao do BinaryOperator: ");
        BinaryOperator<Empregado> binaryOperator = (emp1, emp2) ->
                new Empregado(-1l, emp1.getNome() + emp2.getNome(), emp1.getSalario() + emp2.getSalario(),
                        "");
        Empregado novoEmpregado = binaryOperator.apply(
                new Empregado(1l, "Treina", 1000, ""),
                new Empregado(2l, "Web", 10000, "")
                );
        System.out.println("Novo Empregado: " + novoEmpregado.getNome() + ", RS " + novoEmpregado.getSalario());

        //Predicate
        System.out.println("Execucao do Predicate");
        Predicate<Empregado> predicate = (emp) -> emp.getNome().endsWith("Web");
        Boolean terminaComWeb = predicate.test(new Empregado(0l, "TreinaWeb", 0, ""));
        System.out.println(terminaComWeb);

        //Supplier
        Supplier<Empregado> supplier = () -> new Empregado(new Random().nextLong(), "TreinaWeb", 0, "");
        Empregado emp1 = supplier.get();
        System.out.println(emp1.getId());
        Empregado emp2 = supplier.get();
        System.out.println(emp2.getId());

    }
}
