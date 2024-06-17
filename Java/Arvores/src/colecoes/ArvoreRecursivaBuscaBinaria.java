package colecoes;

public class ArvoreRecursivaBuscaBinaria<E> extends ArvoreAbstrata<E> {

    @Override
    public void inserir(E valor) {
        raiz = inserir(valor, raiz);
    }

    private No inserir(E valor, No atual){
        if(atual == null){
            tamanho++;
            return new No(valor);
        }
        int comparacao = comparar(valor, atual.valor);

        if(comparacao < 0){
            atual.esquerda = inserir(valor, atual.esquerda);
        } else if (comparacao > 0){
            atual.direita = inserir(valor, atual.direita);
        }
        return atual;
    }

    @Override
    public boolean contem(E valor) {
        return contem(valor, raiz) != null;
    }

    private No contem(E valor, No atual){
        if(atual == null){
            return null;
        }
        int comparacao = comparar(valor, atual.valor);
        if(comparacao < 0){
            return contem(valor, atual.esquerda);
        } else if (comparacao > 0){
            return contem(valor, atual.direita);
        }
        return atual;
    }

    private No noMin(No atual){
        if(atual.esquerda == null){
            return atual;
        }
        return noMin(atual.esquerda);
    }
    @Override
    public E buscar(E valor) {
        No no = contem(valor, raiz);
        return no != null ? no.valor : null;
    }

    @Override
    public E deletar(E valor) {
        int tamanhoAnterior = tamanho;
        raiz = deletar(valor, raiz);
        return tamanhoAnterior != tamanho ? valor : null;
    }

    private No deletar(E valor, No atual){
        if(atual == null){
            return null;
        }

        int comparacao = comparar(valor, atual.valor);

        if(comparacao < 0){
            atual.esquerda = deletar(valor, atual.esquerda);
        } else if (comparacao > 0){
            atual.direita = deletar(valor, atual.direita);
        } else {
            //Sem filhos
            if(atual.esquerda == null && atual.direita == null){
                tamanho--;
                return null;
            //2 Filhos
            } else if (atual.esquerda != null && atual.direita != null){
                No sucessor = noMin(atual.direita);
                atual.valor = sucessor.valor;
                atual.direita = deletar(sucessor.valor, atual.direita);
            } else {
                tamanho--;
                return atual.esquerda != null ? atual.esquerda : atual.direita;
            }

        }
        return atual;
    }

    @Override
    public boolean estaVazio() {
        return tamanho == 0;
    }

    @Override
    public void limpar() {
        raiz = null;
        tamanho = 0;
    }

    private void inOrder(No no){
        if(no != null){
            inOrder(no.esquerda);
            System.out.print(no.valor + " ");
            inOrder(no.direita);
        }
    }

    public void inOrder(){
        inOrder(raiz);
        System.out.println();
    }

    private void preOrder(No no){
        if(no != null){
            System.out.print(no.valor + " ");
            preOrder(no.esquerda);
            preOrder(no.direita);
        }
    }

    public void preOrder(){
        preOrder(raiz);
        System.out.println();
    }

    private void postOrder(No no){
        if(no != null){
            postOrder(no.esquerda);
            postOrder(no.direita);
            System.out.print(no.valor + " ");
        }
    }

    public void postOrder(){
        postOrder(raiz);
        System.out.println();
    }

    public void transversalArvore() {
        if (raiz == null) return;

        Fila<No> fila = new FilaDinamica<>();
        fila.enfileirar(raiz);

        while(!fila.estaVazio()){
            No atual = fila.desenfileirar();
            System.out.print(atual.valor+ " ");

            if(atual.esquerda != null){
                fila.enfileirar(atual.esquerda);
            }
            if(atual.direita != null){
                fila.enfileirar(atual.direita);
            }
        }
    }
}
