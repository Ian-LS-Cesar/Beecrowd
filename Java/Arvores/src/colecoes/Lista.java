package colecoes;

import excecoes.EmptyListException;

public interface Lista<E> {
    void adicionar(E valor);
    void inserir(E valor);
    void inserir(int indice, E valor) throws IndexOutOfBoundsException;
    E removerUltimo() throws EmptyListException;
    E removerPrimeiro() throws EmptyListException;
    E removerPorIndice(int indice) throws IndexOutOfBoundsException, EmptyListException;
    boolean estaVazio();
    E buscar(int indice) throws IndexOutOfBoundsException;
    void transformar(int indice, E valor) throws IndexOutOfBoundsException;
    int tamanho();
}
