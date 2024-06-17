package colecoes;

public class ArvorePesquisaBinaria<E> extends ArvoreAbstrata<E> {

    @Override
    public void inserir(E valor) {
        No novoNo = new No(valor);
        if(estaVazio()){
            raiz = novoNo;
        }else{
            No noAux = raiz;
            while(true){
                if(comparar(novoNo, noAux) < 0){
                    if(noAux.esquerda == null){
                        noAux.esquerda = novoNo;
                        break;
                    }
                    noAux = noAux.esquerda;
                }else if(comparar(novoNo, noAux) > 0){
                    if(noAux.direita == null){
                        noAux.direita = novoNo;
                        break;
                    }
                    noAux = noAux.direita;
                }else{
                    return;
                }
            }
        }
        tamanho++;
    }

    @Override
    public boolean contem(E valor) {
        return false;
    }

    @Override
    public E buscar(E valor) {
        No atual = raiz;

        while (atual != null){
            int comparacao = comparar(valor,atual.valor);
            if(comparacao < 0){
                atual = atual.esquerda;
            } else if (comparacao > 0){
                atual = atual.direita;
            } else {
                return atual.valor;
            }
        }
        return null;
    }

    private E removerNoMinimo(No pai) {
        No noMinimo = pai.direita;
        No paiNoMinimo = pai;

        // Encontrar o nó mínimo na subárvore direita
        while (noMinimo.esquerda != null) {
            paiNoMinimo = noMinimo;
            noMinimo = noMinimo.esquerda;
        }

        // Remover o nó mínimo
        if (noMinimo.direita != null) {
            if (paiNoMinimo.esquerda == noMinimo) {
                paiNoMinimo.esquerda = noMinimo.direita;
            } else {
                paiNoMinimo.direita = noMinimo.direita;
            }
        } else {
            if (paiNoMinimo.esquerda == noMinimo) {
                paiNoMinimo.esquerda = null;
            } else {
                paiNoMinimo.direita = null;
            }
        }
        return noMinimo.valor;
    }


    @Override
    public E deletar(E valor) {
        if(estaVazio()) throw new RuntimeException("A Árvore está vazia!");
        No alvo = raiz, pai = null;

        while(alvo != null && comparar(valor, alvo) != 0){
            pai = alvo;
            if(comparar(valor, alvo) > 0) {
                alvo = alvo.direita;
            }else{
                alvo = alvo.esquerda;
            }
        }

        if (alvo == null){
            return null;
        }
        //Nó sem Filhos
        if(alvo.esquerda == null && alvo.direita == null){
            if(alvo == raiz){
                raiz = null;
            }else if(pai.esquerda == alvo){
                pai.esquerda = null;
            }else{
                pai.direita = null;
            }
        //Nó com 2 filhos
        }else if(alvo.esquerda != null && alvo.direita != null){
            alvo.valor = removerNoMinimo(alvo);
        //Nó com 1 filho
        }else{
            No filho = alvo.esquerda != null ? alvo.esquerda: alvo.direita;

            if(alvo == raiz){
                raiz = filho;
            }else if(pai.esquerda == alvo){
                    pai.esquerda = filho;
            }else{
                pai.direita = filho;
            }

        }
        tamanho--;
        return alvo.valor;
    }

    @Override
    public boolean estaVazio() {
        return raiz == null;
    }

    @Override
    public void limpar() {
        raiz = null;
        tamanho = 0;
    }

    @Override
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

}
