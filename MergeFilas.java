public class MergeFilas {

    public static FilaCircular merge(FilaCircular a, FilaCircular b) {

        FilaCircular r = new FilaCircular(a.tamanho() + b.tamanho());

        while (!a.vazia() && !b.vazia()) {

            if (a.primeiro() <= b.primeiro()) {
                r.insere(a.remove());
            } else {
                r.insere(b.remove());
            }
        }

        while (!a.vazia()) {
            r.insere(a.remove());
        }

        while (!b.vazia()) {
            r.insere(b.remove());
        }

        return r;
    }
}
