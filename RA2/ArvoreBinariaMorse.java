public class ArvoreBinariaMorse {

    private NodoMorse raiz;

    public ArvoreBinariaMorse() {
        this.raiz = null;
    }

    public NodoMorse getRaiz() {
        return raiz;
    }

    public void inicializar() {
        this.raiz = new NodoMorse(NodoMorse.VAZIO);
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public void inserir(String codigo, char letra) {
        if (raiz == null) {
            inicializar();
        }

        NodoMorse atual = raiz;

        for (int i = 0; i < codigo.length(); i++) {

            char simbolo = codigo.charAt(i);

            if (simbolo == '.') {
                if (atual.getEsquerda() == null) {
                    atual.setEsquerda(new NodoMorse(NodoMorse.VAZIO));
                }
                atual = atual.getEsquerda();

            } else if (simbolo == '-') {
                if (atual.getDireita() == null) {
                    atual.setDireita(new NodoMorse(NodoMorse.VAZIO));
                }
                atual = atual.getDireita();

            } else {
                return;
            }
        }

        atual.setSimbolo(letra);
    }

    public char buscar(String codigo) {
        if (raiz == null) {
            return NodoMorse.VAZIO;
        }

        NodoMorse atual = raiz;

        for (int i = 0; i < codigo.length(); i++) {
            char simbolo = codigo.charAt(i);

            if (simbolo == '.') {
                atual = atual.getEsquerda();
            } else if (simbolo == '-') {
                atual = atual.getDireita();
            } else {
                return NodoMorse.VAZIO;
            }

            if (atual == null) {
                return NodoMorse.VAZIO;
            }
        }

        return atual.getSimbolo();
    }

    public String codigoDe(char letra) {
        String encontrado = codigoDe(raiz, Character.toUpperCase(letra), "");
        return (encontrado == null) ? "" : encontrado;
    }

    private String codigoDe(NodoMorse no, char letra, String caminho) {
        if (no == null) {
            return null;
        }

        if (no.temSimbolo() && no.getSimbolo() == letra) {
            return caminho;
        }

        String achadoEsquerda = codigoDe(no.getEsquerda(), letra, caminho + ".");
        if (achadoEsquerda != null) {
            return achadoEsquerda;
        }

        return codigoDe(no.getDireita(), letra, caminho + "-");
    }

    public String decodificar(String mensagem) {
        if (mensagem == null || mensagem.trim().isEmpty()) {
            return "";
        }

        String texto = "";

        String[] partes = mensagem.trim().split(" +");

        for (int i = 0; i < partes.length; i++) {
            String codigo = partes[i];

            if (codigo.equals("/")) {
                texto = texto + " ";
                continue;
            }

            char letra = buscar(codigo);

            if (letra == NodoMorse.VAZIO) {
                texto = texto + "?";
            } else {
                texto = texto + letra;
            }
        }

        return texto;
    }

    public String codificar(String texto) {
        if (texto == null) {
            return "";
        }

        String mensagem = "";
        texto = texto.toUpperCase();

        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);

            if (letra == ' ') {
                mensagem = mensagem + "/ ";
                continue;
            }

            String codigo = codigoDe(letra);
            if (!codigo.isEmpty()) {
                mensagem = mensagem + codigo + " ";
            }
        }

        return mensagem.trim();
    }

    public void exibir() {
        if (raiz == null) {
            System.out.println("Arvore vazia.");
            return;
        }

        System.out.println("[raiz]");
        exibir(raiz.getEsquerda(), ".", 1);
        exibir(raiz.getDireita(), "-", 1);
    }

    private void exibir(NodoMorse no, String codigo, int nivel) {
        if (no == null) {
            return;
        }

        String recuo = "";
        for (int i = 0; i < nivel; i++) {
            recuo = recuo + "    ";
        }

        char letra = no.temSimbolo() ? no.getSimbolo() : '?';

        System.out.println(recuo + codigo + "  ->  " + letra);

        exibir(no.getEsquerda(), codigo + ".", nivel + 1);
        exibir(no.getDireita(), codigo + "-", nivel + 1);
    }

    public void carregarAlfabeto() {
        String[] codigos = {
            ".-",   "-...", "-.-.", "-..",  ".",    "..-.", "--.",  "....",
            "..",   ".---", "-.-",  ".-..", "--",   "-.",   "---",  ".--.",
            "--.-", ".-.",  "...",  "-",    "..-",  "...-", ".--",  "-..-",
            "-.--", "--..",
            "-----", ".----", "..---", "...--", "....-",
            ".....", "-....", "--...", "---..", "----."
        };

        char[] letras = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z',
            '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9'
        };

        for (int i = 0; i < codigos.length; i++) {
            inserir(codigos[i], letras[i]);
        }
    }
}
