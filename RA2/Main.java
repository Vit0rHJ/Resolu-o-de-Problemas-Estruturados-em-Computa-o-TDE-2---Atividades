import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        arvore.inicializar();
        arvore.carregarAlfabeto();

        testeDoEnunciado();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println();
            System.out.println("===== CODIGO MORSE =====");
            System.out.println("1 - Exibir a arvore");
            System.out.println("2 - Decodificar mensagem em Morse");
            System.out.println("3 - Codificar texto para Morse");
            System.out.println("4 - Buscar um codigo (codigo -> letra)");
            System.out.println("5 - Buscar uma letra (letra -> codigo)");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            if (!entrada.hasNextInt()) {
                entrada.nextLine();
                System.out.println("Digite um numero da lista.");
                continue;
            }

            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao == 1) {
                arvore.exibir();

            } else if (opcao == 2) {
                System.out.println("Separe as letras com espaco e as palavras com /");
                System.out.print("Mensagem: ");
                String mensagem = entrada.nextLine();
                System.out.println("Texto: " + arvore.decodificar(mensagem));

            } else if (opcao == 3) {
                System.out.print("Texto: ");
                String texto = entrada.nextLine();
                System.out.println("Morse: " + arvore.codificar(texto));

            } else if (opcao == 4) {
                System.out.print("Codigo: ");
                String codigo = entrada.nextLine().trim();
                char letra = arvore.buscar(codigo);

                if (letra == NodoMorse.VAZIO) {
                    System.out.println("Codigo nao encontrado na arvore.");
                } else {
                    System.out.println("Letra: " + letra);
                }

            } else if (opcao == 5) {
                System.out.print("Letra: ");
                String linha = entrada.nextLine().trim();

                if (linha.isEmpty()) {
                    System.out.println("Nada digitado.");
                } else {
                    String codigo = arvore.codigoDe(linha.charAt(0));

                    if (codigo.isEmpty()) {
                        System.out.println("Letra nao encontrada na arvore.");
                    } else {
                        System.out.println("Codigo: " + codigo);
                    }
                }

            } else if (opcao != 0) {
                System.out.println("Opcao invalida.");
            }
        }

        System.out.println("Encerrado.");
        entrada.close();
    }

    private static void testeDoEnunciado() {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        arvore.inicializar();
        arvore.inserir("...", 'S');
        arvore.inserir("---", 'O');

        System.out.println("--- teste do enunciado ---");
        System.out.println(arvore.buscar("..."));
        System.out.println(arvore.buscar("---"));
        System.out.println(arvore.decodificar("... --- ..."));
    }
}
