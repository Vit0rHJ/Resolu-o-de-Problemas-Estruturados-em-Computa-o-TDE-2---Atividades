public class FilaCircular {

    private int[] dados;
    private int inicio;
    private int fim;
    private int quantidade;

    public FilaCircular(int capacidade) {
        this.dados = new int[capacidade];
        this.inicio = 0;
        this.fim = -1;
        this.quantidade = 0;
    }

    public boolean vazia() {
        return quantidade == 0;
    }

    public boolean cheia() {
        return quantidade == dados.length;
    }

    public void insere(int elemento) {
        if (cheia()) {
            throw new IllegalStateException("Fila cheia.");
        }

        fim = (fim + 1) % dados.length;

        dados[fim] = elemento;
        quantidade++;
    }

    public int remove() {
        if (vazia()) {
            throw new IllegalStateException("Fila vazia.");
        }

        int elemento = dados[inicio];

        inicio = (inicio + 1) % dados.length;

        quantidade--;
        return elemento;
    }

    public int primeiro() {
        if (vazia()) {
            throw new IllegalStateException("Fila vazia.");
        }
        return dados[inicio];
    }

    public int ultimo() {
        if (vazia()) {
            throw new IllegalStateException("Fila vazia.");
        }
        return dados[fim];
    }

    public int tamanho() {
        return quantidade;
    }

    public int capacidade() {
        return dados.length;
    }

    public String toString() {
        String saida = "[";

        for (int i = 0; i < quantidade; i++) {
            int posicao = (inicio + i) % dados.length;

            saida = saida + dados[posicao];

            if (i < quantidade - 1) {
                saida = saida + ", ";
            }
        }

        return saida + "]";
    }
}
