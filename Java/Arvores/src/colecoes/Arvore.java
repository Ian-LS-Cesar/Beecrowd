package colecoes;

public interface Arvore<E> {
    void inserir(E valor);
    boolean contem(E valor);
    E buscar(E valor);
    E deletar(E valor);
    int tamanho();
    boolean estaVazio();
    void limpar();
    void transversalArvore();
}
