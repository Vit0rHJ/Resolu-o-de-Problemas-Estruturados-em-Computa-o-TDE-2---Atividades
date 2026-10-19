public class MainFila {

    public static void main(String[] args) {

        testeOperacoes();
        testeCircularidade();
        testeMerge();
    }

    private static void testeOperacoes() {
        System.out.println("=== operacoes do TAD ===");

        FilaCircular f = new FilaCircular(5);

        System.out.println("vazia: " + f.vazia());

        f.insere(10);
        f.insere(20);
        f.insere(30);

        System.out.println("fila: " + f);
        System.out.println("primeiro: " + f.primeiro());
        System.out.println("ultimo: " + f.ultimo());
        System.out.println("removeu: " + f.remove());
        System.out.println("fila: " + f);

        f.insere(40);
        f.insere(50);
        f.insere(60);

        System.out.println("fila: " + f);
        System.out.println("cheia: " + f.cheia());
        System.out.println();
    }

    private static void testeCircularidade() {
        System.out.println("=== circularidade ===");

        FilaCircular f = new FilaCircular(4);

        f.insere(1);
        f.insere(2);
        f.insere(3);
        f.insere(4);
        System.out.println("fila: " + f);

        f.remove();
        f.remove();
        System.out.println("apos 2 remocoes: " + f);

        f.insere(5);
        f.insere(6);
        System.out.println("apos 2 insercoes: " + f);
        System.out.println("primeiro: " + f.primeiro() + "  ultimo: " + f.ultimo());
        System.out.println();
    }

    private static void testeMerge() {
        System.out.println("=== merge ===");

        FilaCircular a = new FilaCircular(4);
        a.insere(12);
        a.insere(35);
        a.insere(52);
        a.insere(64);

        FilaCircular b = new FilaCircular(5);
        b.insere(5);
        b.insere(15);
        b.insere(23);
        b.insere(55);
        b.insere(75);

        System.out.println("Fila A: " + a);
        System.out.println("Fila B: " + b);

        FilaCircular c = MergeFilas.merge(a, b);

        System.out.println("Fila C: " + c);
        System.out.println("A apos o merge: " + a);
        System.out.println("B apos o merge: " + b);
    }
}
