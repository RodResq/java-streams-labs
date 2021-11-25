package br.com.home.java.streams;

@SuppressWarnings("all")
public class MensageiroConsole implements Mensageiro{

    @Override
    public void emitirMessagem(String mensagem) {
        System.out.println("Mensagem " + mensagem);
    }
}
