import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);


        int casosTeste = leitor.nextInt();


        for (int i = 0; i < casosTeste; i++) {

            int quantAlunos = leitor.nextInt();

            int[] notas = new int[quantAlunos];


            for (int j = 0; j < quantAlunos; j++) {

                notas[j] = leitor.nextInt();

            }


            int trocaAlunos = 0;


            for (int j = 0; j < quantAlunos; j++) {

                int maiorNota = notas[j];

                int posicaoMaiorNota = j;


                for (int k = j + 1; k < quantAlunos; k++) {

                    if (notas[k] > maiorNota) {

                        maiorNota = notas[k];

                        posicaoMaiorNota = k;

                    }

                }


                if (posicaoMaiorNota != j) {

                    trocaAlunos++;

                }

            }


            System.out.println(quantAlunos - trocaAlunos);

        }


        leitor.close();

    }

}


interface Pilha<E> {
    void empilhar(E valor);
    E tirar();
    E topo();
    boolean estaVazio();
    int altura();
}



class PilhaEstatica<E> implements Pilha<E> {

    private int altura;
    private E[] pilha;
    
    @SuppressWarnings("unchecked")
    public PilhaEstatica(int alturaMax){
        pilha = (E[])new Object[alturaMax];
    }

    @Override
    public int altura() {
        return altura;
    }

    @Override
    public void empilhar(E valor) {
       
       
       pilha[altura] = valor;
       altura++;
    }

    @Override
    public boolean estaVazio() {
        return altura == 0;
    }


    @Override
    public E tirar(){
        return pilha[--altura];
    }

    @Override
    public E topo(){
        
        return pilha[altura - 1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for(int i = altura-1; i>=0; i--){
            sb.append(pilha[i]);
            if(i == altura-1){
                sb.append(" -> Topo");
            }
                sb.append("\n");
        }
        return sb.toString();
    }
    
    
}
