package colecoes;

public class AVL<E> extends ArvoreAbstrata<E> {

    @Override
    public void inserir(E valor) {
        raiz = inserir(valor, raiz);
    }

    private No inserir(E valor, No no){
        if(no == null){
            tamanho++;
            return new No(valor);
        }

        int comparacao = comparar(valor, no.valor);
        if(comparacao < 0){
            no.esquerda = inserir(valor, no.esquerda);
        } else if (comparacao > 0){
            no.direita = inserir(valor, no.direita);
        } else {
            return no;
        }
        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        return balancear(no);
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

    @Override
    public E buscar(E valor) {
        No atual = contem(valor, raiz);
        return atual != null ? atual.valor : null;
    }

    @Override
    public E deletar(E valor) {
        int tamanhoAnterior = tamanho;
        raiz = deletar(valor, raiz);
        return tamanhoAnterior != tamanho ? valor : null;
    }

    private No deletar(E valor, No no){
        if(no == null){
            return null;
        }

        int comparacao = comparar(valor, no.valor);

        if(comparacao < 0){
            no.esquerda = deletar(valor, no.esquerda);
        } else if (comparacao > 0){
            no.direita = deletar(valor, no.direita);
        } else {
            tamanho--;
            if(no.esquerda == null || no.direita == null){
                No temp = no.esquerda != null ? no.esquerda : no.direita;
                if(temp == null){
                    no = null;
                } else {
                    no = temp;
                }
            } else {
                No temp = valorNoMin(no.direita);
                no.valor = temp.valor;
                no.direita = deletar(temp.valor, no.direita);
            }
        }

        if (no == null){
            return null;
        }

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        return balancear(no);
    }

    private No valorNoMin(No no){
        No atual = no;
        while(atual.esquerda != null){
            atual = atual.esquerda;
        }
        return atual;
    }

    private int altura(No atual){
        return atual == null ? 0 : atual.altura;
    }

    private int fatorBalaceamento(No atual){
        return atual == null ? 0 : altura(atual.esquerda) - altura(atual.direita);
    }

    private No rotacaoDireita(No y){
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private No rotacaoEsquerda(No x){
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    @Override
    public boolean estaVazio() {
        return tamanho == 0;
    }

    private No balancear(No atual){
        int balancear = fatorBalaceamento(atual);

        if(balancear > 1){
            if(fatorBalaceamento(atual.esquerda) < 0){
                atual.esquerda = rotacaoEsquerda(atual.esquerda);
            }
            return rotacaoDireita(atual);
        }

        if(balancear < -1){
            if(fatorBalaceamento(atual.direita) > 0){
                atual.direita = rotacaoDireita(atual.direita);
            }
            return rotacaoEsquerda(atual);
        }

        return atual;

    }

    @Override
    public void limpar() {
        raiz = null;
        tamanho = 0;
    }

    public int tamanho(){
        return tamanho;
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
