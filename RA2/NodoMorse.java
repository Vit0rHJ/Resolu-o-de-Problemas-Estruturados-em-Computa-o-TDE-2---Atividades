public class NodoMorse {

    private char simbolo;

    public static final char VAZIO = '\u0000';

    private NodoMorse esquerda;
    private NodoMorse direita;

    public NodoMorse(char simbolo) {
        this.simbolo = simbolo;
        this.esquerda = null;
        this.direita = null;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public NodoMorse getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NodoMorse esquerda) {
        this.esquerda = esquerda;
    }

    public NodoMorse getDireita() {
        return direita;
    }

    public void setDireita(NodoMorse direita) {
        this.direita = direita;
    }

    public boolean temSimbolo() {
        return this.simbolo != VAZIO;
    }
}
