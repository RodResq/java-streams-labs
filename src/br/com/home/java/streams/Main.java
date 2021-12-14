package br.com.home.java.streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {
        List<Empregado> empregados = new ArrayList<>();
        empregados.add(new Empregado(1L, "Joao", 2000, "Producao"));
        empregados.add(new Empregado(2L, "Maria", 3000, "RH"));
        empregados.add(new Empregado(3L, "Jose", 5000, "Controladoria"));
        empregados.add(new Empregado(4L, "Josefina", 7000, "CTO"));
        /*
        System.out.println("Funcionarios que comecam com J");
        Stream<Empregado> empregadoStream = empregados.stream();
        Stream<Empregado> empregadosFiltrado = empregadoStream.filter((emp) -> emp.getNome().startsWith("J"));
        List<Empregado> empregadosComJ = empregadosFiltrado.collect(Collectors.toList());
        Usando Pipeline de Streams
        */

        /**
         * @Method_References - Alternativa as operacoes intermediarias dos streams (Classe::metodo)
         */
        /*
        DoubleSummaryStatistics estatisticaSalario =
                empregados.stream().collect(Collectors.summarizingDouble(Empregado::getSalario));
        System.out.println("** Estatiticas dos Empregados");
        System.out.println("Maximo: R$ " + estatisticaSalario.getMax());
        System.out.println("Minimo: R$ " + estatisticaSalario.getMin());
        System.out.println("Media R$: " + estatisticaSalario.getAverage());
        System.out.println("Folha Salaria R$: " + estatisticaSalario.getSum());
        */

        /**
         * @map() - Ultilizado para fazer um mapeamento de um tipo <T> em outro tipo <R>,
         * para isso, ultiliza partes da informacaoes de T, que sera ultilizada em <R>.
         * @Obs: Pode-se criar objetos com partes da informacoes de <T>
         */
        /*
        System.out.println("*** Exemplo de uso do map() ***");
        *//*Retorna uma lista so com os nomes dos empregados*//*
        List<String> nomeEmpregados = empregados.stream().map(emp -> emp.getNome()).collect(Collectors.toList());
        nomeEmpregados.forEach(System.out::println);
        */

        /**
         *  Inicio Testando o Lazy Loading dos Streams
         */
        /*
        Stream<Empregado> stream = empregados.stream().filter(emp -> {
            System.out.println("*** Filter sendo Excutado!");
            return emp.getNome().startsWith("J");
        });

        System.out.println("** Executando o Collect");
        List<Empregado> listaComJ = stream.collect(Collectors.toList());

        System.out.println("Convertendo o Stream em uma lista Novamente");
        List<Empregado> empregadosComJ = empregados.stream()
                .filter(emp -> emp.getNome().startsWith("J"))
                .collect(Collectors.toList());
        empregadosComJ.stream().forEach((emp) -> System.out.println(emp.getNome()));
        Retorna OptionalDouble pois nao ha garantia que valores dentro do stream
        OptionalDouble menorSalario = empregadosComJ.stream().mapToDouble((emp) -> emp.getSalario()).min();
        if (menorSalario.isPresent()) {
            System.out.println("Menor Salario : R$ " + menorSalario.getAsDouble());
        }
            Fim Testando o Lazy Loading dos Streams
        */


        /**
         * @Strem() - Comparando o for tradicional com o stream()
         */
        /*
        System.out.println("** LISTA DE EMPREGADOS **");
        for (Empregado emp: empregados) {
            System.out.println(emp.getNome());
        }
        empregados.stream().forEach(emp -> {
            System.out.println(emp.getNome());
        });
        double salarioTotal = 0.0;
        for (Empregado emp: empregados) {
            salarioTotal = salarioTotal + emp.getSalario();
        }
        */


        /**
         * @mapToDouble - Implementando o stream intermidiario com mapToDouble
         * recupera o sama de todos os salarios
         */
        /*double salarioTotal = empregados.stream().mapToDouble(emp -> emp.getSalario()).sum();
        System.out.println("Salario total: R$ " + salarioTotal);*/


        /**
         * @Functional_interfae - Maneira Tradicionar de Ultilizar uma interface Funcional
         */
        /*
        Mensageiro mensageiro = new MensageiroConsole();
        mensageiro.emitirMessagem("TreinaWeb");
        */


        /**
        * @Implementacao_Anonima - Conhecendo a Implementacao anonima do Java 8
        */
        /*
        Mensageiro mensageiro = new Mensageiro() {
            @Override
            public void emitirMessagem(String mensagem) {
                System.out.println("Mensagem do Objeto Anonimo: " + mensagem);
            }
        };
        mensageiro.emitirMessagem("Treina Web");
        */


        /**
         * @Expressoes_Lambdas Usando as Expressoes Lambdas para chamar os metodos das funcoes anonimas
         */
        /*
         Mensageiro mensageiro = (mensagem) -> System.out.println("Mensagem da expressao Lambda: " + mensagem);
        mensageiro.emitirMessagem("TReina WEb");
         */


        /**
         * @Consumer - Conhecento o consumer, nao retorna nada
         * @Params <T>
         */
        /*
        System.out.println("########### Executando O Consumer - Teste 1 ##############");
        Consumer<Empregado> consumer1 = (emp) -> {
            System.out.println(emp.getNome() + ", R$ " + emp.getSalario());
        };
        consumer1.accept(new Empregado(10l, "Empregado 10", 1000, "Educacao"));

        System.out.println("########### Executando O Consumer - Teste 2 ##############");
        Consumer<Empregado> consumer2 = (emp) -> {
            System.out.println(String.format("Empregado: %s, recebe: R$ %.2f", emp.getNome(), emp.getSalario()));
        };
        consumer2.accept(new Empregado(100l, "Teste", 1000, "TI"));
        */


        /**
         * @Functions - Conhecendo as Functions<T, R>
         * @Params <T>
         * @Return <R>
         */
        /*Exemplos de Funcions*/
        /*
        System.out.println("Execucao da Function: ");
        Function<Empregado, Double> function = emp -> emp.getSalario() * 10;
        Function<Empregado, String> functionStr = empregado -> empregado.getNome();
        double novoSalario = function.apply(new Empregado(1l, "EMpregado 1", 1, ""));
        System.out.println("Novo salario: " + novoSalario);
        System.out.println(functionStr.apply(new Empregado(11l, "Empregado 11", 2000, "Ti")));
         */


        /**
         * @BinaryOperator - Faz um operacao binaria em dois objeto tipo <T>
         * @Params <T> -> Recebe 2 parametros do mesmo tipo
         * @Return <T> -> Retorno do mesmo tipo apos a operacao binaria
         */
        /*
        System.out.println("Execucao do BinaryOperator: ");
        BinaryOperator<Empregado> binaryOperator = (emp1, emp2) ->
                new Empregado(-1l, emp1.getNome() + emp2.getNome(), emp1.getSalario() + emp2.getSalario(),
                        "");
        Empregado novoEmpregado = binaryOperator.apply(
                new Empregado(1l, "Treina", 1000, ""),
                new Empregado(2l, "Web", 10000, "")
                );
        System.out.println("Novo Empregado: " + novoEmpregado.getNome() + ", RS " + novoEmpregado.getSalario());
        */


        /**
         * @Predicate - Faz um operacao Booleana
         * @Params <T>
         * @Return Boolean
         */
        /*
        System.out.println("########## Execucao do Predicate #################");
        Predicate<Empregado> predicate1 = (emp) -> emp.getNome().endsWith("Web");
        Boolean terminaComWeb = predicate1.test(new Empregado(0l, "TreinaWeb", 0, ""));
        System.out.println(terminaComWeb);

        Predicate<Empregado> predicate2 = (emp) -> emp.getNome().endsWith("Web");
        boolean retornoPredicate = predicate2.test(new Empregado(135L, "TreinaWeb", 0, ""));
        System.out.println(retornoPredicate);
        */


        /**
         * @Suplier - Ultilizado para gerar tipos complexos
         * @Params - <T>
         * @Return - <T> -> Nova instancia
         */
        /*
        System.out.println("############### Executando o Supplier #################");
        Supplier<Empregado> supplier1 = () -> new Empregado(new Random().nextLong(), "TreinaWeb", 0, "");
        Empregado empregado1 = supplier1.get();
        System.out.println(empregado1.getId());
        Empregado empregado2 = supplier1.get();
        System.out.println(empregado2.getId());

        Supplier<Empregado> supplier2 = () -> new Empregado(new Random().nextLong(), "TreinaWeb", 0, "");
        Empregado emp1 = supplier2.get();
        System.out.println(emp1.getId());
        Empregado emp2 = supplier2.get();
        System.out.println(emp2.getId());
        */

    }
}
