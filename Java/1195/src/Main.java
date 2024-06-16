import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class No {
    int valor;
    No esquerda, direita;

    public No(int valor) {
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

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    private No inserir(No no, int valor) {
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
        List<Integer> listaInt = new ArrayList<>();
        percursoInfixo(raiz, listaInt);
        imprimirComEspacos(listaInt);
    }

    private void percursoInfixo(No no, List<Integer> listaInt) {
        if (no!= null) {
            percursoInfixo(no.esquerda, listaInt);
            listaInt.add(no.valor);
            percursoInfixo(no.direita, listaInt);
        }
    }

    public void percursoPrefixo() {
        List<Integer> listaInt = new ArrayList<>();
        percursoPrefixo(raiz, listaInt);
        imprimirComEspacos(listaInt);
    }

    private void percursoPrefixo(No no, List<Integer> listaInt) {
        if (no!= null) {
            listaInt.add(no.valor);
            percursoPrefixo(no.esquerda, listaInt);
            percursoPrefixo(no.direita, listaInt);
        }
    }

    public void percursoPosfixo() {
        List<Integer> listaInt = new ArrayList<>();
        percursoPosfixo(raiz, listaInt);
        imprimirComEspacos(listaInt);
    }

    private void percursoPosfixo(No no, List<Integer> listaInt) {
        if (no!= null) {
            percursoPosfixo(no.esquerda, listaInt);
            percursoPosfixo(no.direita, listaInt);
            listaInt.add(no.valor);
        }
    }

    private void imprimirComEspacos(List<Integer> listaInt) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < listaInt.size(); i++) {
            resultado.append(listaInt.get(i));
            if (i < listaInt.size() - 1) {
                resultado.append(" ");
            }
        }
        System.out.println(resultado.toString());
    }

    public boolean procurar(int valor) {
        return procurar(raiz, valor);
    }

    private boolean procurar(No no, int valor) {
        if (no == null) {
            return false;
        }

        if (valor == no.valor) {
            return true;
        }

        return valor < no.valor? procurar(no.esquerda, valor) : procurar(no.direita, valor);
    }

    public void remover(int valor) {
        raiz = remover(raiz, valor);
    }

    private No remover(No no, int valor) {
        if (no == null) {
            return no;
        }

        if (valor < no.valor) {
            no.esquerda = remover(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = remover(no.direita, valor);
        } else {
            if (no.esquerda == null) {
                return no.direita;
            } else if (no.direita == null) {
                return no.esquerda;
            }

            no.valor = encontrarMaior(no.esquerda);
            no.esquerda = remover(no.esquerda, no.valor);
        }

        return no;
    }

    private int encontrarMaior(No no) {
        int maior = no.valor;
        while (no.direita!= null) {
            maior = no.direita.valor;
            no = no.direita;
        }
        return maior;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int casosTeste = leitor.nextInt();

        for(int i = 0; i < casosTeste; i++){

            int quantNum = leitor.nextInt();
            ArvoreBuscaBinaria arvore = new ArvoreBuscaBinaria();

            for(int j = 0; j < quantNum; j++){
                arvore.inserir(leitor.nextInt());
            }

            System.out.println("Case "+ (i + 1) +":");
            System.out.print("Pre.: " );
            arvore.percursoPrefixo();
            System.out.print("In..: ");
            arvore.percursoInfixo();
            System.out.print("Post: ");
            arvore.percursoPosfixo();
            System.out.print("\n");
        }

        leitor.close();
    }
}