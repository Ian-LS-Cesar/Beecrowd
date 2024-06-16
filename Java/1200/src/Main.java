import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class No {
    Character valor;
    No esquerda, direita;

    public No(Character valor) {
        this.valor = valor;
        esquerda = null;
        direita = null;
    }
}

class ArvoreBuscaBinaria {
    No raiz;

    public ArvoreBuscaBinaria() {
        raiz = null;
    }

    public void inserir(Character valor) {
        raiz = inserir(raiz, valor);
    }

    private No inserir(No no, Character valor) {
        if (no == null) {
            no = new No(valor);
            return no;
        }

        if (valor < no.valor) {
            no.esquerda = inserir(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserir(no.direita, valor);
        }

        return no;
    }

    public void percursoInfixo() {
        List<Character> listaChar = new ArrayList<>();
        percursoInfixo(raiz, listaChar);
        imprimirComEspacos(listaChar);
    }

    private void percursoInfixo(No no, List<Character> listaChar) {
        if (no != null) {
            percursoInfixo(no.esquerda, listaChar);
            listaChar.add(no.valor);
            percursoInfixo(no.direita, listaChar);
        }
    }

    public void percursoPrefixo() {
        List<Character> listaChar = new ArrayList<>();
        percursoPrefixo(raiz, listaChar);
        imprimirComEspacos(listaChar);
    }

    private void percursoPrefixo(No no, List<Character> listaChar) {
        if (no != null) {
            listaChar.add(no.valor);
            percursoPrefixo(no.esquerda, listaChar);
            percursoPrefixo(no.direita, listaChar);
        }
    }

    public void percursoPosfixo() {
        List<Character> listaChar = new ArrayList<>();
        percursoPosfixo(raiz, listaChar);
        imprimirComEspacos(listaChar);
    }

    private void percursoPosfixo(No no, List<Character> listaChar) {
        if (no != null) {
            percursoPosfixo(no.esquerda, listaChar);
            percursoPosfixo(no.direita, listaChar);
            listaChar.add(no.valor);
        }
    }

    private void imprimirComEspacos(List<Character> listaChar) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < listaChar.size(); i++) {
            resultado.append(listaChar.get(i));
            if (i < listaChar.size() - 1) {
                resultado.append(" ");
            }
        }
        System.out.println(resultado.toString());
    }

    public boolean procurar(Character valor) {
        return procurar(raiz, valor);
    }

    private boolean procurar(No no, Character valor) {
        if (no == null) {
            return false;
        }

        if (valor == no.valor) {
            return true;
        }

        return valor < no.valor ? procurar(no.esquerda, valor) : procurar(no.direita, valor);
    }
}

public class Main {
    public static void main(String[] args) {
        ArvoreBuscaBinaria arvore = new ArvoreBuscaBinaria();
        Scanner leitor = new Scanner(System.in);

        while (leitor.hasNextLine()) {
            String[] entrada = leitor.nextLine().split(" ");
            String comando = entrada[0];

            switch (comando) {
                case "I":
                    arvore.inserir(entrada[1].charAt(0));
                    break;
                case "INFIXA":
                    arvore.percursoInfixo();
                    break;
                case "PREFIXA":
                    arvore.percursoPrefixo();
                    break;
                case "POSFIXA":
                    arvore.percursoPosfixo();
                    break;
                case "P":
                    if (arvore.procurar(entrada[1].charAt(0))) {
                        System.out.println(entrada[1].charAt(0) + " existe");
                    } else {
                        System.out.println(entrada[1].charAt(0) + " nao existe");
                    }
                    break;
            }
        }

        leitor.close();
    }
}
