package colecoes;

import excecoes.EmptyQueueException;

public class FilaDinamica<E> implements Fila<E> {

    ListaEncadeada<E> fila;

    public FilaDinamica(){
        fila = new ListaEncadeada<>();
    }


    @Override
    public void enfileirar(E valor) {
        fila.adicionar(valor);
    }

    @Override
    public E desenfileirar() throws EmptyQueueException {
        return fila.removerPrimeiro();
    }

    @Override
    public E primeiro() throws EmptyQueueException {
        return fila.buscar(0);
    }

    @Override
    public int tamanho() {
        return fila.tamanho();
    }

    @Override
    public boolean estaVazio() {
        return fila.estaVazio();
    }

    @Override
    public String toString() {
        return "primeiro\n \\/ \n"+fila.toString();
    }
}
