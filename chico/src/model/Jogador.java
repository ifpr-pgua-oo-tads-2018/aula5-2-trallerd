package model;

import java.io.Serializable;

public class Jogador implements Serializable {
    private String nome;
    private String email;
    private String senha;
    private long nJogadas;
    private long pontos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getnJogadas() {
        return nJogadas;
    }

    public void setnJogadas(long nJogadas) {
        this.nJogadas = nJogadas;
    }

    public long getPontos() {
        return pontos;
    }

    public void setPontos(long pontos) {
        this.pontos = pontos;
    }
}
