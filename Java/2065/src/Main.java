
import java.util.Scanner;

import collections.SortedPriorityQueue;


public class Main {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        SortedPriorityQueue<Integer, Integer> funcLivres = new SortedPriorityQueue<>();
        SortedPriorityQueue<Integer, Integer> funcOcupados = new SortedPriorityQueue<>();
        SortedPriorityQueue<Integer, Integer> clientes = new SortedPriorityQueue<>(); 
        
        int tempoTotal = 0;
        int quantFun = leitor.nextInt();
        int quantCli = leitor.nextInt();
        
        for (int id = 1; id <= quantFun ; id++){
            int tempoFun = leitor.nextInt();
            funcLivres.insert(id,tempoFun);
        }

        for (int i = 0; i < quantCli; i++){
            int produtos = leitor.nextInt();
            clientes.insert(i,produtos);
        }

        System.out.println(funcLivres);
        System.out.println(clientes);

        for(int i = 0; i < quantCli; i++){
            if(quantCli == quantFun){
                
            }
        }
    }
}
