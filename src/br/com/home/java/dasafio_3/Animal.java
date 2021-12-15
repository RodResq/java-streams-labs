package br.com.home.java.dasafio_3;

@SuppressWarnings("all")
public class Animal {
    private String nome;
    private String especie;

    public Animal(String nome, String especie)
    {
        this.nome = nome;
        this.especie = especie;
    }

    public String getNome()
    {
        return nome;
    }

    public String getEspecie()
    {
        return especie;
    }

    @Override
    public String toString() {
        return  nome;
    }
}
