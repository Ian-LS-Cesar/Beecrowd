package colecoes;

import excecoes.EmptyQueueException;

public interface Fila<E> {
    void enfileirar(E valor);
    E desenfileirar() throws EmptyQueueException;
    E primeiro() throws EmptyQueueException;
    int tamanho();
    boolean estaVazio();
}
