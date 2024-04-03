package org.example;

public class Jogador {
    private String nome;
    private String sobrenome;
    private String posicao;
    private String clube;
    private short idade;

    public Jogador(String nome, String sobrenome, String posicao, String clube, short idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.posicao = posicao;
        this.clube = clube;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getClube() {
        return clube;
    }

    public short getIdade() {
        return idade;
    }

    public String getDescricao() {
        return nome + " " + sobrenome + " é um futebolista brasileiro de " + idade + " anos que atua como " + posicao + ". Atualmente defende o " + clube + ".";
    }
}
