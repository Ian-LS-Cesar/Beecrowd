import colecoes.AVL;
import colecoes.ArvoreAbstrata;
import colecoes.ArvorePesquisaBinaria;
import colecoes.ArvoreRecursivaBuscaBinaria;

public class Main {
    public static void main(String[] args) {

        ArvorePesquisaBinaria<Integer> apb = new ArvorePesquisaBinaria<>();
        ArvoreRecursivaBuscaBinaria<Integer> arb = new ArvoreRecursivaBuscaBinaria<>();
        AVL<Integer> avl = new AVL<>();

        System.out.println("Arvore Pesquisa Binária:");
        apb.inserir(5398);
        apb.inserir(12);
        apb.inserir(421);
        apb.inserir(829);

        apb.inOrder();
        apb.preOrder();
        apb.postOrder();

        System.out.println("Arvore Recursiva de Pesquisa Binária:");
        arb.inserir(5398);
        arb.inserir(12);
        arb.inserir(421);
        arb.inserir(829);

        arb.inOrder();
        arb.preOrder();
        arb.postOrder();

        System.out.println("AVL:");
        avl.inserir(5398);
        avl.inserir(12);
        avl.inserir(421);
        avl.inserir(829);

        avl.inOrder();
        avl.preOrder();
        avl.postOrder();


    }
}