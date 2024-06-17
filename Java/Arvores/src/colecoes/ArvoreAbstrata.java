package colecoes;

import entidades.ComparadorPadrao;

import java.util.Comparator;

public abstract class ArvoreAbstrata<E> implements Arvore<E> {

    class No{
        No esquerda;
        No direita;
        int altura;
        E valor;

        public No(E valor) {
            this.valor = valor;
            altura = 1;
        }
    }

    protected No raiz;
    protected int tamanho;
    protected Comparator<E> comparador;

    public ArvoreAbstrata(){
        comparador = new ComparadorPadrao<>();
    }

    public int comparar(E valor1, E valor2){
        return comparador.compare(valor1, valor2);
    }

    public int comparar(No no1, No no2){
        return comparador.compare(no1.valor, no2.valor);
    }

    public int comparar(E valor, No no){
        return comparador.compare(valor, no.valor);
    }

    @Override
    public int tamanho(){
        return tamanho;
    }
}


