package model;

import java.io.Serializable;

public class Jogadas implements Serializable {
    private Jogador jogador1, jogador2;
    private long palpite1, palpite2, soma;

    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public long getPalpite1() {
        return palpite1;
    }

    public void setPalpite1(long palpite1) {
        this.palpite1 = palpite1;
    }

    public long getPalpite2() {
        return palpite2;
    }

    public void setPalpite2(long palpite2) {
        this.palpite2 = palpite2;
    }

    public long getSoma() {
        return soma;
    }

    public void setSoma(long soma) {
        this.soma = soma;
    }
}
