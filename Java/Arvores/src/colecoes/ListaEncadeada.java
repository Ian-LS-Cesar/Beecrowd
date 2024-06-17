package colecoes;

import excecoes.EmptyListException;

public class ListaEncadeada<E> implements Lista<E>{

    private class No{
        E valor;
        No proximo;

        public No(E valor) {
            this.valor = valor;
        }
    }

    private int tamanho;
    private No comeco;
    private No fim;

    public ListaEncadeada(){}

    public ListaEncadeada(E valor){
        adicionar(valor);
    }

    @Override
    public void adicionar(E valor) {
        No novoNo = new No(valor);
        if(estaVazio()){
            comeco = novoNo;
        }else{
            fim.proximo = novoNo;
        }
        fim = novoNo;
        tamanho++;
    }

    @Override
    public void inserir(E valor) {
        No novoNo = new No(valor);

        if(estaVazio()){
            comeco = novoNo;
            fim = novoNo;
        }else{
            novoNo.proximo = comeco;
            comeco = novoNo;
        }

        tamanho++;
    }

    private No buscarNo(int indice){
        No noAux = comeco;
        for(int i = 0; i < indice; i++){
            noAux = noAux.proximo;
        }
        return noAux;
    }

    @Override
    public void inserir(int indice, E valor) throws IndexOutOfBoundsException {

        if(indice <= 0){
            inserir(valor);
        }else if(indice >= tamanho){
            adicionar(valor);
        }else{
            No novoNo = new No(valor);
            No noAux = buscarNo(indice - 1);
            novoNo.proximo = noAux.proximo;
            noAux.proximo = novoNo;
            tamanho++;
        }
    }

    @Override
    public E removerUltimo() throws EmptyListException {
        if(estaVazio()) throw new EmptyListException("A Lista está vazia!");
        E valor = fim.valor;
        if(tamanho == 1){
            comeco = null;
            fim = null;
        }else{
            No noAux = buscarNo(tamanho - 2);
            fim = noAux;
            noAux.proximo = null;
        }
        tamanho--;
        return valor;
    }

    @Override
    public E removerPrimeiro() throws EmptyListException {
        if(estaVazio()) throw new EmptyListException("A Lista está vazia!");
        No noAux = comeco;
        if(tamanho == 1){
            comeco = null;
            fim = null;
        }else{
            comeco = comeco.proximo;
            noAux.proximo = null;
        }
        tamanho--;
        return noAux.valor;
    }

    @Override
    public E removerPorIndice(int indice) throws IndexOutOfBoundsException, EmptyListException {
        if(estaVazio()) throw new EmptyListException("A Lista está vazia!");
        if(indice < 0 || indice >= tamanho) throw new IndexOutOfBoundsException("Índice "+indice+" inválido. Os índices válidos estão entre 0 até "+(tamanho - 1));
        E valor = null;
        if(indice == 0){
            valor = removerPrimeiro();
        }else if(indice == tamanho - 1){
            valor = removerUltimo();
        }else{
            No noAux1 = buscarNo(indice - 1);
            No noAux2 = noAux1.proximo;
            noAux1.proximo = noAux2.proximo;
            valor = noAux2.valor;
            tamanho--;
        }

        return valor;
    }

    @Override
    public boolean estaVazio() {
        return tamanho == 0;
    }

    @Override
    public E buscar(int indice) throws IndexOutOfBoundsException {
        if(estaVazio()) throw new EmptyListException("A Lista está vazia!");
        if(indice < 0 || indice >= tamanho) throw new IndexOutOfBoundsException("Índice "+indice+" inválido. Os índices válidos estão entre 0 até "+(tamanho - 1));
        return buscarNo(indice).valor;
    }

    @Override
    public void transformar(int indice, E valor) throws IndexOutOfBoundsException {
        if(estaVazio()) throw new EmptyListException("A Lista está vazia!");
        if(indice < 0 || indice >= tamanho) throw new IndexOutOfBoundsException("Índice "+indice+" inválido. Os índices válidos estão entre 0 até "+(tamanho - 1));
        buscarNo(indice).valor = valor;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        No noAux = comeco;
        while(noAux != null){
            sb.append(noAux.valor);
            if(noAux.proximo != null){
                sb.append(", ");
            }
            noAux = noAux.proximo;
        }
        return sb.append("]").toString();
    }
}
